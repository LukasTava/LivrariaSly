package Slytherin.excecao;

/**
 * Classe de exceção de negócio
 * @author Lukas e Rayssa
 */
public class NegocioException extends java.io.IOException {
    /**
     * Cria uma nova exceção de negócio, definindo a mensagem
     * @param mensagem Mensagem de erro
     */
    public NegocioException(String mensagem) {
        super(mensagem);
    }
    
}
