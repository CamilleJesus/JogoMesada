package br.uefs.ecomp.jm_c.model;


/**
 *
 * @author Camille Jesus
 */
public class CartaCompras {
         
    private String descricao;
    private double valorCompra;
    private double valorRevenda;

    public CartaCompras(String descricao, double valorCompra, double valorRevenda) {
        this.descricao = descricao;
        this.valorCompra = valorCompra;
        this.valorRevenda = valorRevenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorRevenda() {
        return valorRevenda;
    }

    public void setValorRevenda(double valorRevenda) {
        this.valorRevenda = valorRevenda;
    }
    
}