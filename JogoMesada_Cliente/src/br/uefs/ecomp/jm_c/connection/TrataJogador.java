package br.uefs.ecomp.jm_c.connection;

import java.io.IOException;


/**
 * Classe TrataJogador, responsável por tratar o envio de informações entre os jogadores.
 * 
 * @author Camille Jesus e Felipe Damasceno
 */
public class TrataJogador {
    
    private ConexaoCliente conexaoCliente;
    
    /** Construtor da classe, responsável por recuperar a instância da conexão.
     * 
     */
    public TrataJogador() {
        conexaoCliente = ConexaoCliente.getInstancia();
    }
 
    /** Método que envia um inteiro para todos o jogadores.
     * 
     * @param numero 
     */
    public void enviaInteiro(Integer numero) {
        String envia = numero.toString();
        
        try {
            this.conexaoCliente.envia(envia);
            System.out.println("Enviou");
        } catch (IOException ex) {
            System.out.println("Não enviou");
        }
    }
    
    /** Método que envia um decimal para todos o jogadores.
     * 
     * @param valor
     */
    public void enviaDecimal(Double valor) {
        String envia = valor.toString();
        
        try {
            this.conexaoCliente.envia(envia);
            System.out.println("Enviou");
        } catch (IOException ex) {
            System.out.println("Não enviou");
        }
    }
    
    /** Método que envia uma string para todos o jogadores.
     * 
     * @param requisicao
     */
    public void enviaString(String requisicao) {
        
        try {
            this.conexaoCliente.envia(requisicao);
            System.out.println("Enviou");
        } catch (IOException ex) {
            System.out.println("Não enviou");
        }
    }
    
    /** Método que envia um decimal para um jogador específico, a partir de seu
     * nome.
     * 
     * @param jogador
     * @param valor
     */
    public void enviaJogadorDecimal(String jogador, Double valor) {
        
        try {
            this.conexaoCliente.enviaJogador(jogador, valor.toString());
            System.out.println("Enviou");
        } catch (IOException ex) {
            System.out.println("Não enviou");
        }
    }
    
    /** Método que envia uma string para um jogador específico, a partir de seu
     * nome.
     * 
     * @param jogador
     * @param requisicao
     */
    public void enviaJogadorString(String jogador, String requisicao) {
        
        try {
            this.conexaoCliente.enviaJogador(jogador, requisicao);
            System.out.println("Enviou");
        } catch (IOException ex) {
            System.out.println("Não enviou");
        }
    }
    
}