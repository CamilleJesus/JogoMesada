package br.uefs.ecomp.jm_c.model;


/**
 * Classe Peao, permite criar os pinos do jogadores na partida e guarda informações
 * referentes a sua localização no tabuleiro.
 * 
 * @author Camille Jesus e Felipe Damasceno
 */
public class Peao {
        
    private int id;
    private int quantidade;
    private int linha;
    private int coluna;

    /** Construtor da classe, inicializa os atributos da classe como 0.
     */
    public Peao() {
        this.id = 0;
        this.quantidade = 0;
        this.linha = 0;
        this.coluna = 0;
    }

    /** Método que retorna o Id do peão.
     * 
     * @return ip int
     */
    public int getId() {
        return this.id;
    }

    /** Método que altera o Id do peão.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /** Método que retorna a quantidade que o peão andou.
     * 
     * @return quantidade int
     */
    public int getQuantidade() {
        return this.quantidade;
    }

    /** Método que altera a quantidade que o peão andou.
     * 
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    /** Método que atualiza a quantidade que o peão andou.
     * 
     * @param valor
     */
    public void aumentaQuantidade(int valor) {
        this.quantidade += valor;
    }

    /** Método que retorna a linha do tabuleiro em que peão está.
     * 
     * @return linha int
     */
    public int getLinha() {
        return this.linha;
    }

    /** Método que altera a linha do tabuleiro em que peão está.
     * 
     * @param linha
     */
    public void setLinha(int linha) {
        this.linha = linha;
    }

    /** Método que retorna a coluna do tabuleiro em que peão está.
     * 
     * @return coluna int
     */
    public int getColuna() {
        return this.coluna;
    }

    /** Método que altera a coluna do tabuleiro em que peão está.
     * 
     * @param coluna
     */
    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    
}