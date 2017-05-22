package br.uefs.ecomp.jm_c.model;


/**
 * Classe Conta, permite criar uma conta, possui um valor referente ao saldo e um
 * valor de dívida.
 * 
 * @author Camille Jesus
 */
public class Conta {
    
    private double saldo;
    private double divida;
    
    /** Construtor da classe, inicializa o atributo saldo com o valor padrão inicial
     * e a dívida como inexistente.
     */
    public Conta() {
        this.saldo = 3000.0;
        this.divida = 0;
    }

    /** Método que retorna o saldo da conta.
     * 
     * @return saldo
     */
    public double getSaldo() {
        return this.saldo;
    }

    /** Método que altera o saldo da conta.
     * 
     * @param saldo 
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    /** Método que aumenta o saldo da conta.
     * 
     * @param valor 
     */
    public void aumentaSaldo(double valor) {
        this.saldo += valor;
    }
    
    /** Método que diminui o saldo da conta.
     * 
     * @param valor 
     */
    public void diminuiSaldo(double valor) {
        this.saldo -= valor;
    }

    /** Método que retorna a dívida da conta.
     * 
     * @return divida
     */
    public double getDivida() {
        return this.divida;
    }

    /** Método que altera a dívida da conta.
     * 
     * @param divida 
     */
    public void setDivida(double divida) {
        this.divida = divida;
    }
    
    /** Método que aumenta a dívida da conta.
     * 
     * @param valor 
     */
    public void aumentaDivida(double valor) {
        this.divida += valor;
    }
    
    /** Método que diminui a dívida da conta.
     * 
     * @param valor 
     */
    public void diminuiDivida(double valor) {
        this.divida -= valor;
    }
    
}