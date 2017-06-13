package br.uefs.ecomp.jm_c.model;


/**
 * Classe CartaCompras, permite criar uma carta da categoria Compras, possui uma
 * descrição, um valor de compra e um valor de revenda.
 * 
 * @author Camille Jesus e Felipe Damasceno
 */
public class CartaCompras {
         
    private String descricao;
    private double valorCompra;
    private double valorRevenda;

    /** Construtor da classe, inicializa os atributos da classe com os valores
     * recebidos por parâmetro.
     * 
     * @param descricao
     * @param valorCompra
     * @param valorRevenda
     */
    public CartaCompras(String descricao, double valorCompra, double valorRevenda) {
        this.descricao = descricao;
        this.valorCompra = valorCompra;
        this.valorRevenda = valorRevenda;
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

    /** Método que retorna o valor de compra da carta.
     * 
     * @return valorCompra
     */
    public double getValorCompra() {
        return valorCompra;
    }

    /** Método que altera o valor de compra da carta.
     * 
     * @param valorCompra
     */
    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    /** Método que retorna o valor de revenda da carta.
     * 
     * @return valorRevenda
     */
    public double getValorRevenda() {
        return valorRevenda;
    }

    /** Método que altera o valor de revenda da carta.
     * 
     * @param valorRevenda
     */
    public void setValorRevenda(double valorRevenda) {
        this.valorRevenda = valorRevenda;
    }
    
}