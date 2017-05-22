package br.uefs.ecomp.jm_c.model;


/**
 * Classe CartaCorreio, permite criar uma carta da categoria Correio, possui um
 * tipo (há seis tipos de cartas dessa categoria), uma descrição e um valor.
 * 
 * @author Camille Jesus
 */
public class CartaCorreio {
        
    private String tipoCarta; 
    private String descricao;
    private double valor;

    /** Construtor da classe, inicializa os atributos da classe com os valores
     * recebidos por parâmetro.
     * 
     * @param tipoCarta
     * @param descricao
     * @param valor
     */
    public CartaCorreio(String tipoCarta, String descricao, double valor) {
        this.tipoCarta = tipoCarta;
        this.descricao = descricao;
        this.valor = valor;
    }

    /** Método que retorna o tipo da carta.
     * 
     * @return tipoCarta
     */
    public String getTipoCarta() {
        return tipoCarta;
    }

    /** Método que altera o tipo da carta.
     * 
     * @param tipoCarta
     */
    public void setTipoCarta(String tipoCarta) {
        this.tipoCarta = tipoCarta;
    }

    /** Método que retorna a descrição da carta.
     * 
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /** Método que altera a descrição da carta.
     * 
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /** Método que retorna o valor da carta.
     * 
     * @return valor
     */
    public double getValor() {
        return valor;
    }

    /** Método que altera o valor da carta.
     * 
     * @param valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
}