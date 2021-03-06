package Slytherin.controle;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import Slytherin.DAO.BancoDados;
import Slytherin.DAO.EnderecoDAO;
import Slytherin.DAO.EntregaDAO;
import Slytherin.DAO.ItemPedidoDAO;
import Slytherin.DAO.LivroDAO;
import Slytherin.DAO.PagamentoDAO;
import Slytherin.DAO.PedidoDAO;
import Slytherin.DAO.VendaDAO;
import Slytherin.entidade.Carrinho;
import Slytherin.entidade.Conta;
import Slytherin.entidade.Endereco;
import Slytherin.entidade.Entrega;
import Slytherin.entidade.ItemPedido;
import Slytherin.entidade.Livro;
import Slytherin.entidade.Pagamento;
import Slytherin.entidade.Pedido;
import Slytherin.entidade.Venda;
import Slytherin.excecao.BancoException;
import Slytherin.excecao.FormatacaoIncorretaException;
import Slytherin.excecao.NegocioException;


/**
 * Controla todo o sistema de venda e pagamento.
 * <br>É possivel verificar os itens do pedido quanto o proprio pedido por inteiro.
 * <br>Instancie o controle na classe
 * @author Lukas e Rayssa
 */
public class ControleVendas {
    
    Venda venda = new Venda();
    
    /**
     * Cria o pedido da venda e define o endereço padrão do cliente nela
     * @throws Slytherin.excecao.NegocioException Caso o cliente não esteja logado
     */
    public void criarVenda() throws NegocioException {
        //Abrtura de pedido
        Pedido p = new Pedido();
        p.abrirPedido();
        
        //Apresentar isso caso não está logado ou cadastrado (quem chamar)
        /*
        CadastroUsuario j1 = new CadastroUsuario();
        j1.setVisible(true);
        UsuarioCadastrado j2 = new UsuarioCadastrado();
        j2.setVisible(true);
        */
        
        //Define pedido e agrega à venda
        ArrayList<ItemPedido> itens = Carrinho.getItens();
        p.setCliente(Conta.getCliente());
        p.setDataHora(new Date());
        p.setItensPedido(itens);
        venda.abrirVenda(p);
        //Copia endereço de cliente e agrega à venda
        venda.setEndereco(Conta.getCliente().getEndereco());
    }
    

    /**
     * Define a entrega da venda
     * @param tipo Tipos de entrega
     * @param dataEntrega Data da entrega
     */
    public void definirEntrega(String tipo, String dataEntrega){
        //Conforme o modelo dd/mm/aaaa
        String[] sData = dataEntrega.split("/");
        Date data = new Date(Integer.parseInt(sData[2]),Integer.parseInt(sData[1]),Integer.parseInt(sData[0]));
        
        //Define entrega
        Entrega et = new Entrega();
        try {
            switch(Entrega.TipoEntrega.valueOf(tipo)) {
                case RAPIDA:
                case ECONOMICA:
                    et.criarEntrega(Entrega.TipoEntrega.valueOf(tipo));
                    break;
                case AGENDADA:
                    et.criarEntregaAgendada(data);
                    break;
            }
        //Para, caso dê problema com a entrega
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        }
        //Agrega à venda
        venda.setEntrega(et);
    }
    
    
    /**
     * Define o pagamento da venda
     * @param forma Define a forma de pagamento
     * @param numParcelas número de parcelas
     */
    public void definirPagamento(String forma, int numParcelas){
        //Define pagamento
        Pagamento pg = new Pagamento();
        try {
            pg.setForma(Pagamento.TipoPagamento.valueOf(forma));
            pg.setNumParcelas(numParcelas);
            pg.setParcelaRestante(numParcelas);
        //Para, caso dê problema com pagamento
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        }
        //Agrega à venda
        venda.setPagamento(pg);
    }
    
    /**
     * Define o endereço da venda
     * @param logradouro ..
     * @param numero ..
     * @param complemento ..
     * @param bairro ..
     * @param cidade ..
     * @param estado ..
     * @param cep ..
     */
   public void definirEndereco(String logradouro, String numero, String complemento, String bairro, String cidade, String estado, String cep){
        //Define o endereço
        Endereco ed = new Endereco();
        try {
            ed.setLogradouro(logradouro);
            ed.setNumero(numero);
            ed.setComplemento(complemento);
            ed.setBairro(bairro);
            ed.setCidade(cidade);
            ed.setEstado(estado);
            ed.setCep(cep);
        } catch (FormatacaoIncorretaException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        //Agrega à venda
        venda.setEndereco(ed);
   } 
   
   /**
    * Registra a venda por inserção no BD
    */
   public void registrarVenda(){
        try {
            BancoDados bd = new BancoDados();
            EnderecoDAO edDao = new EnderecoDAO(bd);
            PagamentoDAO pgDao = new PagamentoDAO(bd);
            EntregaDAO etDao = new EntregaDAO(bd);
            PedidoDAO pDao = new PedidoDAO(bd);
            ItemPedidoDAO iDao = new ItemPedidoDAO(bd);
            VendaDAO vDao = new VendaDAO(bd);
            LivroDAO lDao = new LivroDAO(bd);
            
            //Registra endereço
            Endereco edx = venda.getEndereco();
            edDao.inserir(edx);
            edx = edDao.buscar(edx);
            venda.setEndereco(edx);
            
            //Registra pagamento
            Pagamento pgx = venda.getPagamento();
            pgDao.inserir(pgx);
            pgx = pgDao.buscar(pgx);
            venda.setPagamento(pgx);
            
            //Registra entrega
            Entrega etx = venda.getEntrega();
            etDao.inserir(etx);
            etx = etDao.buscar(etx);
            venda.setEntrega(etx);
            
            //Registra pedido
            Pedido px = venda.getPedido();
            pDao.inserir(px);
            Pedido ppx = pDao.buscar(px);
            venda.setPedido(ppx);

            //Registra itens do pedido
            Livro lx;
            for(ItemPedido ix : venda.getPedido().getItensPedido()) {
                //Definir Id do livro e do pedido
                lx = lDao.buscar(ix.getLivro());
                ix.setID_LIVRO(lx.getID());
                ix.setID_PEDIDO(px.getID());
                //Registrar
                iDao.inserir(ix);
            }
            
            //Registra venda
            vDao.inserir(venda);
        } catch (BancoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
   }
}
