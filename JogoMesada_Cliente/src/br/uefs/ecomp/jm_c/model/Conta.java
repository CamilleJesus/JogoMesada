package br.uefs.ecomp.jm_c.model;


/**
 *
 * @author Camille Jesus
 */
public class Conta {
    
    private double saldo;
    private double divida;
    
    public Conta() {
        this.saldo = 3000.0;
        this.divida = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void aumentaSaldo(double valor) {
        this.saldo += valor;
    }
    
    public void diminuiSaldo(double valor) {
        this.saldo -= valor;
    }

    public double getDivida() {
        return divida;
    }

    public void setDivida(double divida) {
        this.divida = divida;
    }
    
    public void aumentaDivida(double valor) {
        this.divida += valor;
    }
    
    public void diminuiDivida(double valor) {
        this.divida -= valor;
    }
    
}