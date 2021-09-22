package Slytherin.teste;

import java.util.logging.Level;
import java.util.logging.Logger;
import Slytherin.entidade.Pagamento;
import Slytherin.entidade.Pagamento.TipoPagamento;
import Slytherin.excecao.NegocioException;

/**
 * Classe de teste de pagamento
 * @author Lukas e Rayssa
 */
public class TestePagamento {
    public static void main(String[] args) {
        
        Pagamento p = new Pagamento();
        //Definição de valores
        try {
            p.setForma(TipoPagamento.DEBITO);
            p.setNumParcelas(5);
            p.setParcelaRestante(5);
        } catch (NegocioException ex) {
            Logger.getLogger(TestePagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Exibição
        System.out.println(p.getForma());
        System.out.println(p.getNumParcelas());
        System.out.println(p.getParcelaRestante());
    }
}
