package Slytherin.controle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import Slytherin.DAO.AutorDAO;
import Slytherin.DAO.BancoDados;
import Slytherin.DAO.EditoraDAO;
import Slytherin.DAO.LivroDAO;
import Slytherin.entidade.Autor;
import Slytherin.entidade.ContaRestrita;
import Slytherin.entidade.Editora;
import Slytherin.entidade.Funcionario;
import Slytherin.entidade.Livro;
import Slytherin.excecao.BancoException;
import Slytherin.excecao.FormatacaoIncorretaException;
import Slytherin.excecao.NegocioException;

/**
 * Esta classe controla o cadastro dos livro, verifica se todos os requisitos e
 * campos estão devidamente preenchidos
 *
 * @author Lukas e Rayssa
 */
public class ControleAdministracao {

    private String titulo;
    private String anoPublicacao;
    private String resumo;
    private String sumario;
    private String formato;
    private String numPaginas;
    private String qtdEstoque;
    private String precoVenda;
    private String precoOferta;
    private String precoCusto;
    private String margemLucro;
    private String isbn;
    private String nomeAutor;
    private String nomeEditora;
    private String categoria;
    private boolean digital;
    private boolean oferta;

    public String getTitulo() {
        return titulo;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getFormato() {
        return formato;
    }

    public String getNumPaginas() {
        return numPaginas;
    }
    
    public String getQtdEstoque() {
        return qtdEstoque;
    }

    public String getPrecoVenda() {
        return precoVenda;
    }

    public String getPrecoOferta() {
        return precoOferta;
    }

    public String getPrecoCusto() {
        return precoCusto;
    }

    public String getMargemLucro() {
        return margemLucro;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isDigital() {
        return digital;
    }

    public boolean isOferta() {
        return oferta;
    }

    /**
     * Verifica se o login e senha do administrador batem
     *
     * @param login uma String com o nome do usuário administrador armazenado no banco dados
     * @param senha uma String com a senha armazenada no banco de dados
     * @throws Slytherin.excecao.BancoException Caso não consiga conectar com o banco de dados
     * @throws Slytherin.excecao.NegocioException Caso a compra não possa ser concluida
     */
    public void verificaConta(String login, String senha) throws BancoException, NegocioException {
        Funcionario f = new Funcionario();
        f.setLogin(login);
        f.setSenha(senha);
        ContaRestrita.logar(f);
    }

    /**
     * Cadastra os livros deve ser feito depois dos cadastros de autor e editora
     *
     * @param isbn - Equivalente ao codigo do livro
     * @param autor - Objeto autor
     * @param titulo - O título do livro
     * @param editora - A editora com qual o livro pertence
     * @param anoPublicacao - Ano de publicação do livro
     * @param categoria - Categoria em que o livro se encaixa (ficção, produção científica...)
     * @param resumo - Resumo da obra
     * @param sumario - Capitulos do livro(com seus respectivos nomes)
     * @param formato - Digital ou Não
     * @param numPaginas - Quantidade de páginas do livro
     * @param qtdEstoque - Quantidade disponível em estoque
     * @param precoVenda - Preço pelo qual será vendido
     * @param precoOferta - Preço do item em oferta (se estiver em oferta)
     * @param precoCusto - Preço do custo do item para a livraria
     * @param margemLucro - Margem de lucro prevista
     * @param oferta - Item em oferta?
     * @param digital - Item em formato digital?
     * @return - Retorana true caso o livro consiga ser inserido com sucesso no banco e false caso os dados não forem inseridos corretamente
     * @throws Slytherin.excecao.NegocioException Caso a compra não possa ser concluida (se o item estiver fora de estoque, por exemplo)
     * @throws Slytherin.excecao.BancoException Caso não consiga conectar ao banco ou validar os dados
     */
    public boolean inserirLivro(String isbn, String titulo, String autor, String editora, String anoPublicacao, String categoria, String resumo, String sumario, String formato, String numPaginas, String qtdEstoque, String precoVenda, String precoOferta, String precoCusto, String margemLucro, boolean oferta, boolean digital) throws NegocioException, BancoException {
        BancoDados bd = new BancoDados();
        AutorDAO autorDAO = new AutorDAO(bd);
        EditoraDAO editoraDAO = new EditoraDAO(bd);
        LivroDAO livroDAO = new LivroDAO(bd);

        //Busca autor, caso não encontre, insere e busca
        Autor au = new Autor();
        au.setNome(autor);
        try {
            au = autorDAO.buscar(au);
        } catch (BancoException ex) {
            autorDAO.inserir(au);
            au = autorDAO.buscar(au);
        }

        //Busca editora, caso não encontre, insere e busca
        Editora ed = new Editora();
        ed.setNome(editora);
        try {
            ed = editoraDAO.buscar(ed);
        } catch (BancoException ex) {
            editoraDAO.inserir(ed);
            ed = editoraDAO.buscar(ed);
        }

        //Define e insere livro
        Livro livro = new Livro();
        try {
            livro.setIsbn(isbn);
            livro.setTitulo(titulo);
            livro.setAnoPublicacao(Integer.parseInt(anoPublicacao));
            livro.setCategoria(Livro.CategoriaLivro.valueOf(categoria));
            livro.setResumo(resumo);
            livro.setSumario(sumario);
            livro.setFormato(Livro.FormatoLivro.valueOf(formato));
            livro.setNumPaginas(Integer.parseInt(numPaginas));
            livro.setQtdEstoque(Integer.parseInt(qtdEstoque));
            livro.setPrecoVenda(Float.parseFloat(precoVenda));
            livro.setPrecoOferta(Float.parseFloat(precoOferta));
            livro.setPrecoCusto(Float.parseFloat(precoCusto));
            livro.setMargemLucro(Float.parseFloat(margemLucro));
            livro.setOferta(oferta);
            livro.setDigital(digital);
            livro.setAutor(au);// seta o objeto autor dentro de livro
            livro.setEditora(ed);//seta o objeto editora dentro de livro
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,"Não coloque texto em campo numérico. Utilize '.' como divisor decimal.");
            return false;
        }
        livroDAO.inserir(livro);
        return true;
    }

    public void inserirAutor(String nome, String codigo, String localNasc, String localMorte, String dataNasc, String dataMorte) throws ParseException, BancoException {
        SimpleDateFormat formaData = new SimpleDateFormat("dd/MM/yyyy");

        Autor autor = new Autor();
        autor.setNome(nome);
        autor.setCodigo(codigo);
        autor.setLocalNasci(localNasc);
        autor.setLocalMorte(localMorte);

        Date dataMort = formaData.parse(dataMorte);
        autor.setDataMorte(dataMort);
        Date dataNasce = formaData.parse(dataNasc);
        autor.setDataNasci(dataNasce);

        BancoDados bd = new BancoDados();
        AutorDAO autorDAO = new AutorDAO(bd);
        autorDAO.inserir(autor);
    }

    public void inserirEditora(String cnpj, String nomeEdi, String endereco, String telefone) throws FormatacaoIncorretaException, BancoException {
        Editora editora = new Editora();
        editora.setCnpj(cnpj);
        editora.setNome(nomeEdi);
        editora.setEndereco(endereco);
        editora.setTelefone(telefone);

        BancoDados bd = new BancoDados();
        EditoraDAO editoraD = new EditoraDAO(bd);
        editoraD.inserir(editora);
    }

    public void buscarLivro(String isbn) throws BancoException {
        BancoDados bd = new BancoDados();
        LivroDAO livroDAO = new LivroDAO(bd);
        AutorDAO autorDAO = new AutorDAO(bd);
        EditoraDAO editoraDAO = new EditoraDAO(bd);

        //Busca livro (ISBN)
        Livro livro = new Livro();
        livro.setIsbn(isbn);
        livro = livroDAO.buscar(livro);

        //Puxa autor
        Autor autor = new Autor();
        autor.setID(livro.getID_AUTOR());
        autor = autorDAO.buscarId(autor);

        //Puxa editora
        Editora editora = new Editora();
        editora.setID(livro.getID_EDITORA());
        editora = editoraDAO.buscarId(editora);

        //Define resultados
        this.titulo = livro.getTitulo();
        this.anoPublicacao = String.valueOf(livro.getAnoPublicacao());
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.formato = livro.getFormato().toString();
        this.numPaginas = String.valueOf(livro.getNumPaginas());
        this.qtdEstoque = String.valueOf(livro.getQtdEstoque());
        this.precoVenda = String.valueOf(livro.getPrecoVenda());
        this.precoOferta = String.valueOf(livro.getPrecoOferta());
        this.precoCusto = String.valueOf(livro.getPrecoCusto());
        this.margemLucro = String.valueOf(((int)livro.getMargemLucro()));
        this.isbn = livro.getIsbn();
        this.categoria = livro.getCategoria().toString();
        this.nomeAutor = autor.getNome();
        this.nomeEditora = editora.getNome();
        this.oferta = livro.isOferta();
        this.digital = livro.isDigital();
    }
    
    public boolean alterarLivro(String isbn, String titulo, String autor, String editora, String anoPublicacao, String categoria, String resumo, String sumario, String formato, String numPaginas, String qtdEstoque, String precoVenda, String precoOferta, String precoCusto, String margemLucro, boolean oferta, boolean digital) throws BancoException, NegocioException {
        BancoDados bd1 = new BancoDados();
        LivroDAO livroDAO = new LivroDAO(bd1);
        AutorDAO autorDAO = new AutorDAO(bd1);
        EditoraDAO editoraDAO = new EditoraDAO(bd1);

        //Busca livro, se não existir, pára
        Livro livro = new Livro();
        livro.setIsbn(isbn);
        livro = livroDAO.buscar(livro);

        //Altera autor
        Autor au = new Autor();
        au.setID(livro.getID_AUTOR());
        au.setNome(autor);
        autorDAO.alterar(au);

        //Altera editora
        Editora ed = new Editora();
        ed.setID(livro.getID_EDITORA());
        ed.setNome(editora);
        editoraDAO.alterar(ed);
        
        //Altera livro
        try {
            livro.setIsbn(isbn);
            livro.setTitulo(titulo);
            livro.setAnoPublicacao(Integer.parseInt(anoPublicacao));
            livro.setCategoria(Livro.CategoriaLivro.valueOf(categoria));
            livro.setResumo(resumo);
            livro.setSumario(sumario);
            livro.setFormato(Livro.FormatoLivro.valueOf(formato));
            livro.setNumPaginas(Integer.parseInt(numPaginas));
            livro.setQtdEstoque(Integer.parseInt(qtdEstoque));
            livro.setPrecoVenda(Float.parseFloat(precoVenda));
            livro.setPrecoOferta(Float.parseFloat(precoOferta));
            livro.setPrecoCusto(Float.parseFloat(precoCusto));
            livro.setMargemLucro(Float.parseFloat(margemLucro));
            livro.setOferta(oferta);
            livro.setDigital(digital);
            livro.setID_AUTOR(au.getID());
            livro.setID_EDITORA(ed.getID());
            livro.setAutor(au);
            livro.setEditora(ed);
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,"Não coloque texto em campo numérico. Utilize '.' como divisor decimal.");
            return false;
        }
        livroDAO.alterar(livro);
        return true;
    }
    
    public void removerLivro(String isbn) throws BancoException {
        BancoDados bd = new BancoDados();
        LivroDAO livroDAO = new LivroDAO(bd);

        //Busca livro, se não existir, pára
        Livro livro = new Livro();
        livro.setIsbn(isbn);
        livro = livroDAO.buscar(livro);

        //Exclui
        livroDAO.excluir(livro);

        //NOTA: Para segurança, não foi excluído autor nem editora
    }
}
