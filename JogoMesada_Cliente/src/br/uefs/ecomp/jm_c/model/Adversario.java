package br.uefs.ecomp.jm_c.model;

import java.net.InetAddress;


/**
 * Classe Adversário, guarda as informações dos outros jogadores da partida.
 * 
 * @author Camille Jesus e Felipe Damasceno
 */
public class Adversario {
    
    private InetAddress ip;
    private Integer porta;
    private int ordem;
    private String nickname;
    private String cor;
    
    /** Construtor da classe, inicializa os atributos da classe com os valores
     * recebidos por parâmetro.
     * 
     * @param ip
     * @param porta
     * @param ordem do jogador na partida
     * @param nickname
     * @param cor do pino
     */
    public Adversario(InetAddress ip, Integer porta, int ordem, String nickname, String cor) {
        this.ip = ip;
        this.porta = porta;
        this.ordem = ordem;
        this.nickname = nickname;
        this.cor = cor;
    }
    
    /** Método que retorna o IP do adversário.
     * 
     * @return ip InetAddress
     */
    public InetAddress getIp() {
        return this.ip;
    }
    
    /** Método que altera o IP do adversário.
     * 
     * @param ip 
     */
    public void setIp(InetAddress ip) {
        this.ip = ip;
    }
    
    /** Método que retorna a porta do servidor UDP.
     * 
     * @return porta Interger
     */
    public Integer getPorta() {
        return this.porta;
    }
    
    /** Método que altera a porta do servidor UDP.
     * 
     * @param porta
     */
    public void setPorta(Integer porta) {
        this.porta = porta;
    }
    
    /** Método que retorna a ordem do jogador na partida.
     * 
     * @return ordem int
     */
    public int getOrdem() {

        return this.ordem;

    }
    
    /** Método que altera a ordem do jogador na partida.
     * 
     * @param ordem
     */
    public void setOrdem(int ordem) {
        this.ordem = ordem;

    }
    
    /** Método que retorna o nickname do jogador.
     * 
     * @return porta Interger
     */
    public String getNickname() {
        return this.nickname;
    }
    
    /** Método que altera o nickname do jogador.
     * 
     * @param nickname
     */
    public void setNome(String nickname) {
        this.nickname = nickname;
    }
    
    /** Método que retorna a cor do peão do jogador.
     * 
     * @return porta Interger
     */
    public String getCor() {
        return this.cor;
    }
    
    /** Método que altera a cor do peão do jogador.
     * 
     * @param cor
     */
    public void setCor(String cor) {
        this.cor = cor;

    }
    
}