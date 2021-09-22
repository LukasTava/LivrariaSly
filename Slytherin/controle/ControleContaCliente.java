package Slytherin.controle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Slytherin.entidade.Cliente;
import Slytherin.entidade.Conta;
import Slytherin.entidade.Endereco;
import Slytherin.excecao.BancoException;
import Slytherin.excecao.FormatacaoIncorretaException;
import Slytherin.excecao.NegocioException;

/**
 * Esta classe controla o cadastro de clientes da livraria, atravez do form Cadastro livro
 * usuarios do sistema sem ser os administradores
 * @author Lukas e Rayssa
 */
public class ControleContaCliente {
    
    /**
     * Usuarios do sistema, clientes da loja virtual, poderam efetuar seu cadastro
     * @param email Email informado pelo cliente
     * @param senha Senha informada pelo cliente
     * @param nome Nome do cliente 
     * @param sobrenome Sobrenome do cliente
     * @param sexo Sexo do cliente
     * @param cpf CPF(Cadastro de Pessoa Física) do cliente
     * @param dataNascimento Data de nascimento do cliente
     * @param telefone Número de telefone fixo informado pelo cliente
     * @param telefoneAlt ?
     * @param celular Número de celular informado pelo cliente
     * @param endereco Rua informada
     * @param promocional ?
     * @param logadouro ?
     * @param numero Número da residencia do cliente
     * @param complemento Caso o cliente deseje informar pontos de referência
     * @param bairro Bairro do cliente
     * @param cidade Cidade de residência do cliente
     * @param estado Estado de residência do cliente
     * @param cep Cep da área de residência
     * @param referencia ?
     * @return false?
     * @throws NegocioException Caso a compra não possa ser concluida (se o item estiver fora de estoque, por exemplo)
     * @throws BancoException Caso não consiga conectar ao banco ou validar os dados
     * @throws FormatacaoIncorretaException Dados incorretamente informados
     * @throws java.text.ParseException  Passar uma data no formato com que o objeto foi criado ("dd/MM/yyyy")
     */

    
    
    public boolean cadastrarCliente(String email, String senha, String nome, 
            String sobrenome, String sexo, String cpf, String dataNascimento, 
            String telefone, String telefoneAlt, String celular, String endereco, 
            boolean promocional, String logadouro, String numero, String complemento, 
            String bairro, String cidade, String estado, String cep, String referencia)
            throws BancoException, FormatacaoIncorretaException, NegocioException, ParseException {
        //variavel endereco não usada 
        Conta conta = new Conta();
        Cliente cliente = new Cliente();
        Endereco enderecoC = new Endereco();
        
        cliente.setEmail(email);
        cliente.setSenha(senha);
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setSexo(sexo);
        cliente.setCpf(cpf);
        
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNasc = formato.parse(dataNascimento);
        cliente.setDataNascimento(dataNasc);
        
        cliente.setTelefone(telefone);
        cliente.setTelefoneAlt(telefoneAlt);
        cliente.setCelular(celular);
        cliente.setEndereco(null);//mudar - temporario
        cliente.setPromocional(promocional);
        
        
        enderecoC.setBairro(bairro);
        enderecoC.setCep(cep);
        enderecoC.setCidade(cidade);
        enderecoC.setComplemento(complemento);
        enderecoC.setEstado(estado);
        enderecoC.setLogradouro(logadouro);
        enderecoC.setNumero(numero);
        enderecoC.setReferencia(referencia);
        
        
        
        cliente.setEndereco(enderecoC);
        //try {
            Conta.cadastrar(cliente);//enviando objeto
            //Foi encontrado o cliente, portanto não poderá cadastrar
        //    throw new NegocioException("Não é pos          sível cadastrar, pois já existe uma conta com esse e-mail.");
        //} catch(BancoException ex) {}
        
        
        
        
        
        return false;//temporario
    }
    
    /**
     * 
     * @param email Email informado pelo cliente
     * @param senha Senha informada pelo cliente
     */
    public void logar(String email, String senha){
        
        
        
    }
    
    public void deslogar(){
        
    }
    
    /**
     * 
     * @param logradouro ..
     * @param numero ..
     * @param complemento ..
     * @param bairro ..
     * @param cep Cep da área de residência
     * @param estado ..
     * @param cidade ..
     * @param referencia ..
     */
    public void adicionarEndereco(String logradouro, String numero, String complemento, String bairro, String cidade, String estado, String cep, String referencia){
        
    }
}
