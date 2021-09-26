package Slytherin.teste;

import Slytherin.excecao.BancoException;
import Slytherin.excecao.FormatacaoIncorretaException;
import Slytherin.excecao.NegocioException;
import Slytherin.entidade.Autor;
import Slytherin.DAO.LivroDAO;
import Slytherin.DAO.AutorDAO;
import Slytherin.DAO.BancoDados;
import Slytherin.DAO.EditoraDAO;
import Slytherin.entidade.Livro;
import Slytherin.entidade.Editora;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteUnit {

	Livro l;
	   @Before	
       public void prepararCenario() throws FormatacaoIncorretaException {
            Autor a = new Autor();
            Editora e = new Editora();
            Livro l = new Livro();
            ArrayList<Autor> autores = null;
            ArrayList<Editora> editoras = null;
            ArrayList<Livro> livros = null;
            a.setNome("Floriano Marquendes");
            a.setDataNasci(new Date(1920 - 1900,11,21)); 
            a.setDataMorte(new Date(1997 - 1900,03,15)); 
            a.setLocalNasci("São Pedro, MG");
            a.setLocalMorte("Rio de Janeiro, RJ");
            e.setCnpj("12.123.123/1234-56");
            e.setEndereco("R. dos Leões, 142, São Beto, São Paulo, SP");
            e.setNome("Editora Manzollini");
            e.setTelefone("(11)1234-1234");
       }
       @Test
       public void inserirLivro(Autor a, Editora e,  ArrayList<Livro> livros, ArrayList <Editora> editoras, ArrayList<Autor> autores) throws NegocioException, BancoException, SQLException{  
    	   Livro novoLivro = new Livro();
    	   novoLivro.setAutor(a);
    	   novoLivro.setEditora(e);
    	   novoLivro.setIsbn("1234567890123");
    	   novoLivro.setTitulo("A Classe Insecta");
    	   novoLivro.setResumo("Aqui vai o resumo...");
    	   novoLivro.setSumario("Aqui vai o sumário...");
    	   novoLivro.setAnoPublicacao(1982);
    	   novoLivro.setCategoria(Livro.CategoriaLivro.CIENCIAS_BIO);
    	   novoLivro.setMargemLucro(25.0f);
    	   novoLivro.setPrecoCusto(25.0f);
    	   novoLivro.setPrecoVenda(50.0f);
    	   novoLivro.setPrecoOferta(35.0f);
    	   novoLivro.setQtdEstoque(500);
    	   novoLivro.setDigital(false);
    	   novoLivro.setOferta(false);
    	   
           BancoDados banco = new BancoDados();
           LivroDAO lDao = new LivroDAO(banco);
           AutorDAO aDao = new AutorDAO(banco);
           EditoraDAO eDao = new EditoraDAO(banco);
           aDao.inserir(a);
           a = aDao.buscar(a);
           eDao.inserir(e);
           e = eDao.buscar(e);
           novoLivro.setAutor(a);
           novoLivro.setEditora(e);
           
           lDao.inserir(novoLivro);
           
           livros = (ArrayList<Livro>) lDao.listar();
           autores = (ArrayList<Autor>) aDao.listar();
           editoras = (ArrayList<Editora>) eDao.listar();
           
           Assert.assertEquals(1, novoLivro.getQtdEstoque());
   
       }
       @Test
       public void atualizarLivro(Autor a, Editora e,  ArrayList<Livro> livros, ArrayList <Editora> editoras, ArrayList<Autor> autores) throws NegocioException, BancoException {
    	   Livro novoLivro = new Livro();
    	   novoLivro.setAutor(a);
    	   novoLivro.setEditora(e);
    	   novoLivro.setIsbn("1234567890123");
    	   novoLivro.setTitulo("Assassinato no Expresso do Oriente");
    	   novoLivro.setResumo("Aqui vai o resumo...");
    	   novoLivro.setSumario("Aqui vai o sumário...");
    	   novoLivro.setAnoPublicacao(1982);
    	   novoLivro.setCategoria(Livro.CategoriaLivro.CIENCIAS_BIO);
    	   novoLivro.setMargemLucro(25.0f);
    	   novoLivro.setPrecoCusto(25.0f);
    	   novoLivro.setPrecoVenda(50.0f);
    	   novoLivro.setPrecoOferta(35.0f);
    	   novoLivro.setQtdEstoque(500);
    	   novoLivro.setDigital(false);
    	   novoLivro.setOferta(false);
           BancoDados banco = new BancoDados();
           LivroDAO lDao = new LivroDAO(banco);
           AutorDAO aDao = new AutorDAO(banco);
           EditoraDAO eDao = new EditoraDAO(banco);
           aDao.inserir(a);
           a = aDao.buscar(a);
           eDao.inserir(e);
           e = eDao.buscar(e);
           novoLivro.setAutor(a);
           novoLivro.setEditora(e);
           
           lDao.inserir(novoLivro);
           livros = (ArrayList<Livro>) lDao.listar();
           autores = (ArrayList<Autor>) aDao.listar();
           editoras = (ArrayList<Editora>) eDao.listar();
           Assert.assertEquals(1,novoLivro.getQtdEstoque());
          
           Livro atualizarLivro = new Livro();
           atualizarLivro.setAutor(a);
           atualizarLivro.setEditora(e);
           atualizarLivro.setIsbn("1234567890123");
           atualizarLivro.setTitulo("Assassinato no Expresso do Oriente");
           atualizarLivro.setResumo("Aqui vai o resumo...");
           atualizarLivro.setSumario("Aqui vai o sumário...");
           atualizarLivro.setAnoPublicacao(1982);
           atualizarLivro.setCategoria(Livro.CategoriaLivro.CIENCIAS_BIO);
           atualizarLivro.setMargemLucro(25.0f);
           atualizarLivro.setPrecoCusto(25.0f);
           atualizarLivro.setPrecoVenda(50.0f);
           atualizarLivro.setPrecoOferta(35.0f);
           atualizarLivro.setQtdEstoque(500);
           atualizarLivro.setDigital(false);
           atualizarLivro.setOferta(false);
           BancoDados bancoA = new BancoDados();
           LivroDAO AlDao = new LivroDAO(bancoA);
           AutorDAO AaDao = new AutorDAO(bancoA);
           EditoraDAO AeDao = new EditoraDAO(bancoA);
           AaDao.inserir(a);
           a = AaDao.buscar(a);
           AeDao.inserir(e);
           e = AeDao.buscar(e);
           atualizarLivro.setAutor(a);
           atualizarLivro.setEditora(e);
           
           AlDao.inserir(atualizarLivro);
           livros = (ArrayList<Livro>) AlDao.listar();
           autores = (ArrayList<Autor>) AaDao.listar();
           editoras = (ArrayList<Editora>) AeDao.listar();
           Assert.assertEquals(true,novoLivro.getQtdEstoque());
       }
       
           @Test
           public void removerContato(Autor a, Editora e,  ArrayList<Livro> livros, ArrayList <Editora> editoras, ArrayList<Autor> autores) throws NegocioException, BancoException, SQLException{  
        	   Livro novoLivro = new Livro();
        	   novoLivro.setAutor(a);
        	   novoLivro.setEditora(e);
        	   novoLivro.setIsbn("1234567890123");
        	   novoLivro.setTitulo("A Classe Insecta");
        	   novoLivro.setResumo("Aqui vai o resumo...");
        	   novoLivro.setSumario("Aqui vai o sumário...");
        	   novoLivro.setAnoPublicacao(1982);
        	   novoLivro.setCategoria(Livro.CategoriaLivro.CIENCIAS_BIO);
        	   novoLivro.setMargemLucro(25.0f);
        	   novoLivro.setPrecoCusto(25.0f);
        	   novoLivro.setPrecoVenda(50.0f);
        	   novoLivro.setPrecoOferta(35.0f);
        	   novoLivro.setQtdEstoque(500);
        	   novoLivro.setDigital(false);
        	   novoLivro.setOferta(false);
        	   
               BancoDados banco = new BancoDados();
               LivroDAO lDao = new LivroDAO(banco);
               AutorDAO aDao = new AutorDAO(banco);
               EditoraDAO eDao = new EditoraDAO(banco);
               aDao.inserir(a);
               a = aDao.buscar(a);
               eDao.inserir(e);
               e = eDao.buscar(e);
               novoLivro.setAutor(a);
               novoLivro.setEditora(e);
               
               lDao.inserir(novoLivro);

               
               livros = (ArrayList<Livro>) lDao.listar();
               autores = (ArrayList<Autor>) aDao.listar();
               editoras = (ArrayList<Editora>) eDao.listar();
               
               Assert.assertTrue(novoLivro.getQtdEstoque()==1);
               lDao.excluir(novoLivro);
               Assert.assertTrue(novoLivro.getQtdEstoque()==0);
               
       }
}    