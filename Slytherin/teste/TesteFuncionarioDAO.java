package Slytherin.teste;

import java.util.logging.Level;
import java.util.logging.Logger;
import Slytherin.DAO.BancoDados;
import Slytherin.DAO.FuncionarioDAO;
import Slytherin.entidade.Funcionario;
import Slytherin.excecao.BancoException;

/**
 * Classe de teste de DAO de Funcionário
 * @author Lukas e Rayssa
 */
public class TesteFuncionarioDAO {
    public static void main(String[] args) {
        Funcionario f = new Funcionario();
        f.setLogin("hitler");
        f.setNome("Amaraldo Rômulo");
        f.setSenha("212312");
        
        FuncionarioDAO fDao = new FuncionarioDAO(new BancoDados());
        try {
            fDao.inserir(f);
            f = fDao.buscar(f);
            
            System.out.println(f.getID());
        } catch (BancoException ex) {
            Logger.getLogger(TesteFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
