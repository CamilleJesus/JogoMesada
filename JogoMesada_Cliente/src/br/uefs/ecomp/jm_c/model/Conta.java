package br.uefs.ecomp.jm_c.model;


/**
 *
 * @author Camille Jesus
 */
public class Conta {
    
    private double saldo;
    private double divida;
    
    public Conta() {
        this.saldo = 3000;
        this.divida = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getDivida() {
        return divida;
    }

    public void setDivida(double divida) {
        this.divida = divida;
    }
    
    public void diaMesada(double valor) {
        
        if ((divida > 0.0) && (valor > 0.0) && (valor <= saldo)) {
            divida *= 1.1;
                            
            if (valor <= divida) {
                saldo -= valor;
                divida -= valor;
            } else if (valor > divida) {
                double aux = valor - divida;
                saldo +=aux;
                divida -= valor;
            }          
        }
    }
    
}