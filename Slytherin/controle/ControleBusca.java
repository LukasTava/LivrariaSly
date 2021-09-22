package Slytherin.controle;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Slytherin.DAO.AutorDAO;
import Slytherin.DAO.BancoDados;
import Slytherin.DAO.EditoraDAO;
import Slytherin.DAO.LivroDAO;
import Slytherin.entidade.Autor;
import Slytherin.entidade.BuscaLivro;
import Slytherin.entidade.Editora;
import Slytherin.entidade.Livro;
import Slytherin.excecao.BancoException;

/**
 * Está classe gerencia a busca do livro
 *
 * @author Lukas e Rayssa
 */
public class ControleBusca {

    ArrayList<Livro> resultadosBusca = new ArrayList<>();

    public ArrayList<Livro> getResultadosBusca() {
        return resultadosBusca;
    }

    /**
     * Vai enviar os parametros para buscar um livro atravez do objeto
     * buscalivro e retornar o livro se caso encontrado
     *
     * @param palChave A palavra chave que será enviada
     * @param criterio O criterio da busca A forma que será organizado
     * @throws Slytherin.excecao.BancoException Caso não consiga conectar ao banco ou validar os dados
     */
    public void fazerBusca(String palChave, int criterio) throws BancoException {
        BuscaLivro busca = new BuscaLivro();
        Livro l = new Livro();
        ArrayList<Livro> resultados = new ArrayList<>();
       
        /*
        0 = Filtros
        1 = Editora
        2 = Título
        3 = Autor
        4 = ISBN
        5 = Categoria
         */
        switch (criterio) {
            case 1:
                resultados = busca.buscarLivros(palChave, (BuscaLivro.CriterioBusca.EDITORA));
                break;
            case 2:
                resultados = busca.buscarLivros(palChave, (BuscaLivro.CriterioBusca.TITULO));
                break;
            case 3:
                resultados = busca.buscarLivros(palChave, (BuscaLivro.CriterioBusca.AUTOR));
                break;
            case 4:
                resultados = buscarPorISBN(palChave);
                break;
            case 5:
                resultados = busca.buscarLivros(palChave, (BuscaLivro.CriterioBusca.CATEGORIA));
                break;
            default:
                JOptionPane.showMessageDialog(null, "ERRO - Criterio de busca");
                break;
        }

        //BuscaLivro.CriterioBusca.valueOf(valor) ===> Converte
        /*
         for(Livro x:resultados) {
         System.out.println("_____________________________________teste_");
         System.out.println(x.getTitulo());
         System.out.println(x.getAutor());
         System.out.println(x.getEditora());
         }
         */
        resultadosBusca = resultados;

        //JOptionPane.showMessageDialog(null, resultados);
    }

    /**
     * Busca o livro pelo ISBN
     * @param isbn -  String com o código correspondente ao livro a ser inserido no banco
     * @return Retorna o livro correspondente ao ISBN informado
     * @throws BancoException Caso não consiga conectar ao banco de dados
     */
    public ArrayList<Livro> buscarPorISBN(String isbn) throws BancoException {
        BancoDados bd = new BancoDados();
        LivroDAO livroDAO = new LivroDAO(bd);
        AutorDAO autorDAO = new AutorDAO(bd);
        EditoraDAO editoraDAO = new EditoraDAO(bd);
        
        Livro liOb = new Livro();
        liOb.setIsbn(isbn);
        liOb = livroDAO.buscar(liOb);
        
        Autor autor = new Autor();
        autor.setID(liOb.getID_AUTOR());
        autor = autorDAO.buscarId(autor);
            
        Editora editora = new Editora();
        editora.setID(liOb.getID_EDITORA());
        editora = editoraDAO.buscarId(editora);
        
        liOb.setAutor(autor);
        liOb.setEditora(editora);
        
        ArrayList<Livro> livros = new ArrayList<>();
        livros.add(liOb);
        
        return livros;
    }

    /**
     * Organiza por ordem definida
     * @param palChave String com a palavra chave
     * @param criterio Criterios de exibição de resultados 
     * @param organizacao Organização dos resultados com base nos critérios
     * @deprecated Códigos apresentando falha (sem uso)
     * @throws Slytherin.excecao.BancoException Caso não consiga conectar ao banco ou validar os dados
     */
    public void fazerBusca(String palChave, int criterio, int organizacao) throws BancoException {
        BuscaLivro busca = new BuscaLivro();
        Livro l = new Livro();
        ArrayList<Livro> resultados = new ArrayList<>();

        /*
        0 = CATEGORIA
        1 = EDITORA
        2 = TITULO
        3 = AUTOR     
         */
        /*
        FORMA COMO SERÁ ORGANIZADO
        0 = ALFA_ASC
        1 = ALFA_DESC,
        2 = PRECO_ASC,
        3 = PRECO_DESC
         */
        switch (criterio) {
            case 0:
            switch (organizacao) {
                case 0:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.CATEGORIA, BuscaLivro.OrganizacaoBusca.ALFA_ASC);
                    break;
                case 1:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.CATEGORIA, BuscaLivro.OrganizacaoBusca.ALFA_DESC);
                    break;
                case 2:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.CATEGORIA, BuscaLivro.OrganizacaoBusca.PRECO_ASC);
                    break;
                case 3:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.CATEGORIA, BuscaLivro.OrganizacaoBusca.PRECO_DESC);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERRO - Organização de busca");
                    break;
            }
break;

            case 1:
            switch (organizacao) {
                case 0:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.EDITORA, BuscaLivro.OrganizacaoBusca.ALFA_ASC);
                    break;
                case 1:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.EDITORA, BuscaLivro.OrganizacaoBusca.ALFA_DESC);
                    break;
                case 2:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.EDITORA, BuscaLivro.OrganizacaoBusca.PRECO_ASC);
                    break;
                case 3:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.EDITORA, BuscaLivro.OrganizacaoBusca.PRECO_DESC);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERRO - Organização de busca");
                    break;
            }
break;

            case 2:
            switch (organizacao) {
                case 0:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.TITULO, BuscaLivro.OrganizacaoBusca.ALFA_ASC);
                    break;
                case 1:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.TITULO, BuscaLivro.OrganizacaoBusca.ALFA_DESC);
                    break;
                case 2:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.TITULO, BuscaLivro.OrganizacaoBusca.PRECO_ASC);
                    break;
                case 3:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.TITULO, BuscaLivro.OrganizacaoBusca.PRECO_DESC);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERRO - Organização de busca");
                    break;
            }
break;

            case 3:
            switch (organizacao) {
                case 0:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.AUTOR, BuscaLivro.OrganizacaoBusca.ALFA_ASC);
                    break;
                case 1:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.AUTOR, BuscaLivro.OrganizacaoBusca.ALFA_DESC);
                    break;
                case 2:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.AUTOR, BuscaLivro.OrganizacaoBusca.PRECO_ASC);
                    break;
                case 3:
                    resultados = busca.buscarLivros(palChave, BuscaLivro.CriterioBusca.AUTOR, BuscaLivro.OrganizacaoBusca.PRECO_DESC);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERRO - Organização de busca");
                    break;
            }
break;

            default:
                JOptionPane.showMessageDialog(null, "ERRO - Criterio de busca");
                break;
        }
        
        resultadosBusca = resultados;
        /*
         for(Livro x:resultadosBusca) {
         System.out.println("_____________________________________teste_");
         System.out.println(x.getTitulo());
         System.out.println(x.getAutor());
         System.out.println(x.getEditora());
         }
         */

        //JOptionPane.showMessageDialog(null, resultados);
    }
    
    /**
     * Vai retornar o livro q foi encontrado no buscalivro
     * @deprecated Não tem uso
     */
    public void mostrarLivros() {

    }
    
    /**
     * Busca por categoria
     * @deprecated Não tem uso
     */
    public void buscarCategoria() {
        BuscaLivro busca = new BuscaLivro();
    }
}
