package Slytherin.excecao;

/**
 * Classe de exceção de formatação incorreta de dado
 * @author Lukas e Rayssa
 */
public class FormatacaoIncorretaException extends java.io.IOException {
    /**
     * Cria uma nova exceção de formatação incorreta, definindo a mensagem
     * @param mensagem Mensagem de erro
     */
    public FormatacaoIncorretaException(String mensagem) {
        super(mensagem);
    }
}
