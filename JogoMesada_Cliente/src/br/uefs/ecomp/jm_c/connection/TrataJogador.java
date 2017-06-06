package br.uefs.ecomp.jm_c.connection;

import br.uefs.ecomp.jm_c.connection.ConexaoCliente;
import java.io.IOException;


/**
 *
 * @author Camille Jesus
 */
public class TrataJogador {
    
    private ConexaoCliente conexaoCliente;
    
    public TrataJogador() {
        conexaoCliente = ConexaoCliente.getInstancia();
    }
 
    public void enviaInteiro(Integer numero) {
        String envia = numero.toString();
        
        try {
            this.conexaoCliente.enviar(envia);
            System.out.println("Enviou");
        } catch (IOException ex) {
            System.out.println("Não enviou");
        }
    }
    
    public void enviaDecimal(Double valor) {
        String envia = valor.toString();
        
        try {
            this.conexaoCliente.enviar(envia);
            System.out.println("Enviou");
        } catch (IOException ex) {
            System.out.println("Não enviou");
        }
    }
    
    public void enviaString(String requisicao) {
        
        try {
            this.conexaoCliente.enviar(requisicao);
            System.out.println("Enviou");
        } catch (IOException ex) {
            System.out.println("Não enviou");
        }
    }
    
    public void enviaJogadorString(String jogador, String requisicao) {
        
        try {
            this.conexaoCliente.enviarJogador(jogador, requisicao);
            System.out.println("Enviou");
        } catch (IOException ex) {
            System.out.println("Não enviou");
        }
    }
    
    public void enviaJogadorDecimal(String jogador, Double valor) {
        
        try {
            this.conexaoCliente.enviarJogador(jogador, valor.toString());
            System.out.println("Enviou");
        } catch (IOException ex) {
            System.out.println("Não enviou");
        }
    }
    
}