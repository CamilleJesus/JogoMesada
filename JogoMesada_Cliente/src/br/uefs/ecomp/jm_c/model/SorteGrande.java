package br.uefs.ecomp.jm_c.model;


/**
 *
 * @author Camille Jesus
 */
public class SorteGrande {
     
    private double valor;
    private static SorteGrande sorteGrande;
    
    private SorteGrande() {
        this.valor = 0.0;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double sorteGrande) {
        this.valor = valor;
    }
    
    public void aumentaSorteGrande(double valor) {
        this.valor += valor;
    }
    
    public void diminuiSorteGrande(double valor) {
        this.valor -= valor;
    }
    
    public static void zerarSingleton() {
        sorteGrande = null;
    }
    
    public static SorteGrande getInstance() {

        if (sorteGrande == null) {
            sorteGrande = new SorteGrande();
        }
        return sorteGrande;
    }
    
}