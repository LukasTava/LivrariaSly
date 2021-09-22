package Slytherin.DAO;

import Slytherin.excecao.BancoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de conexão com banco de dados
 * @author Lukas e Rayssa
 */
public class BancoDados {
    /**
     * Conexão do banco
     */
    private Connection conexao;
    /**
     * Nome do driver MySQL do JDBC
     */
    private final String driver = "com.mysql.jdbc.Driver";
    /**
     * Caminho do BD da livraria
     */
    private final String caminho = "jdbc:mysql://localhost:3306/livraria";
    /**
     * Usuário
     */
    private final String usuario = "root";
    /**
     * Senha
     */
    private final String senha = "-FQJh2Xk";
    
    /**
     * Abre a conexão com o banco de dados e retorna-a
     * @return Conexão do banco de dados
     * @throws BancoException Caso encontre algum erro em conectar com o banco
     */
    public Connection abrirConexao() throws BancoException {
        try {
            //Ligação com o driver
            Class.forName(driver);
            //Caminho do banco
            conexao = DriverManager.getConnection(caminho, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            //Joga exceção caso não tenha conseguido se conectar
            throw new BancoException("Não foi possível conectar ao banco de dados.");
        }
        //Retorna a conexão, caso tenha sido sucesso
        return conexao;
    }
    /**
     * Fecha a conexão com o banco de dados
     * @throws BancoException Caso encontre algum erro em fechar o banco
     */
    public void fecharConexao() throws BancoException {
        try {
            conexao.close();
        } catch(SQLException ex) {
            //Joga uma exceção, caso não tenha conseguido fechar
            throw new BancoException("Não foi possível fechar o banco de dados.");
        }
    }
}
