package br.uefs.ecomp.jm_c.model;


/**
 *
 * @author Camille Jesus
 */
public class CartaCorreio {
        
    private String tipoCarta; 
    private String descricao;
    private double valor;

    public CartaCorreio(String tipoCarta, String descricao, double valor) {
        this.tipoCarta = tipoCarta;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getTipoCarta() {
        return tipoCarta;
    }

    public void setTipoCarta(String tipoCarta) {
        this.tipoCarta = tipoCarta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}