package Slytherin.teste;

import Slytherin.entidade.Cliente;
import Slytherin.entidade.Conta;
import Slytherin.entidade.Endereco;
import java.util.logging.Level;
import java.util.logging.Logger;
import Slytherin.excecao.BancoException;
import Slytherin.excecao.FormatacaoIncorretaException;
import Slytherin.excecao.NegocioException;

/**
 * Classe de teste de conta
 * @author ILukas e Rayssa
 */
public class TesteConta {
    public static void main(String[] args) {
        Endereco e = new Endereco();
        /*
        //Definição do endereço
        try {
            e.setLogradouro("Rua Martinez");
            e.setNumero("223");
            e.setComplemento("Apt. 27");
            e.setCep("01223-998");
            e.setBairro("Andrade");
            e.setCidade("São Roque");
            e.setEstado("RJ");
            e.setReferencia("Uma quadra antes do estádio");
        } catch (FormatacaoIncorretaException ex) {
            Logger.getLogger(TesteEndereco.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        //Define cliente
        Cliente c = new Cliente();
        try {
            c.setEmail("compadre.bastos@email.com");
            c.setSenha("well123456");
        } catch (FormatacaoIncorretaException ex) {
            Logger.getLogger(TesteConta.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        try {
            Conta.logar(c);
            System.out.println(Conta.getCliente().getNome() + " " + Conta.getCliente().getSobrenome());
            System.out.println(Conta.getDataHoraEntrada());
        } catch (NegocioException | BancoException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
