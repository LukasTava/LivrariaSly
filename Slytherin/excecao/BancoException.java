package Slytherin.excecao;

/**
 * Classe de exceção de banco
 * @author Lukas e Rayssa
 */
public class BancoException extends java.io.IOException {
    /**
     * Cria uma nova exceção de banco, definindo a mensagem
     * @param mensagem mensagem de erro
     */
    public BancoException(String mensagem) {
        super(mensagem);
    }
}
