package br.uefs.ecomp.jm_c.model;

import java.net.InetAddress;

/**
 * Classe que guarda as informacoes dos outros jogadores da partida
 * 
 * @author felipe e Camille
 */
public class Adversario {
    
    private InetAddress ip;
    private Integer porta;
    private int ordem;
    private String nome;
    private String cor;
    /**
     * Inicializa as variaveis
     * @param ip
     * @param porta
     * @param ordem do jogador na partida
     * @param nome
     * @param cor do pino
     */
    public Adversario(InetAddress ip, Integer porta, int ordem, String nome, String cor) {
        this.ip = ip;
        this.porta = porta;
        this.ordem = ordem;
        this.cor = cor;
        this.nome = nome;
    }
    /**
     * retorna o ip do adversario.
     * @return ip
     */
    public InetAddress getIp() {
        return ip;
    }
    /**
     * muda valor do ip do jogador
     * @param ip 
     */
    public void setIp(InetAddress ip) {
        this.ip = ip;
    }
    /**
     * retorna porta do servidor udp
     * @return porta
     */
    public Integer getPorta() {
        return porta;
    }
    /**
     * muda valor da porta do servidor udp
     * @param porta 
     */
    public void setPorta(Integer porta) {
        this.porta = porta;
    }
    /**
     * retorna ordem do jogador na partida
     * @return ordem
     */
    public int getOrdem() {

        return this.ordem;

    }
    /**
     * muda valor da ordem do jogador na partida
     * @param ordem 
     */
    public void setOrdem(int ordem) {
        this.ordem = ordem;

    }
    /**
     * retorna nome
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * muda nome do jogador
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * retorna cor do pino
     * @return cor
     */
    public String getCor() {
        return cor;
    }
    /**
     * muda cor do pino
     * @param cor 
     */
    public void setCor(String cor) {
        this.cor = cor;

    }
    
}