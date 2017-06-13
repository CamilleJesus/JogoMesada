package br.uefs.ecomp.jm_c.model;


/**
 * Classe CartaCorreio, permite criar uma carta da categoria Correio, possui um
 * tipo (há seis tipos de cartas dessa categoria), uma descrição e um valor.
 * 
 * @author Camille Jesus e Felipe Damasceno
 */
public class CartaCorreio {
        
    private String tipo; 
    private String descricao;
    private double valor;

    /** Construtor da classe, inicializa os atributos da classe com os valores
     * recebidos por parâmetro.
     * 
     * @param tipo
     * @param descricao
     * @param valor
     */
    public CartaCorreio(String tipo, String descricao, double valor) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
    }

    /** Método que retorna o tipo da carta.
     * 
     * @return tipoCarta
     */
    public String getTipo() {
        return tipo;
    }

    /** Método que altera o tipo da carta.
     * 
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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