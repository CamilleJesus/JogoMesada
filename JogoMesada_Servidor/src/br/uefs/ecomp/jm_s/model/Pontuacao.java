package br.uefs.ecomp.jm_s.model;

/**
 * Classe que armazena as informações das pontuacoes finais dos jogadores
 * @author felipe
 */
public class Pontuacao {
    private String nome;
    private double saldo;
    /**
     * Inicializa variaveis
     * @param nome
     * @param saldo 
     */
    public Pontuacao(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
    }
    /**
     * retorna nome do jogador
     * @return nome
     */
    public String getNome(){
        return nome;
    }
    /**
     * retorna saldo do jogador
     * @return saldo
     */
    public double getSaldo(){
        return saldo;
    }
}
