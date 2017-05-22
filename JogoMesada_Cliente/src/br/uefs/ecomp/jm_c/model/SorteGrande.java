package br.uefs.ecomp.jm_c.model;


/**
 * Classe Singleton SorteGrande, permite criar apenas uma instância dessa classe,
 * possui um valor.
 * 
 * @author Camille Jesus
 */
public class SorteGrande {
     
    private static SorteGrande sorteGrande;   //Autoreferência
    
    private double valor;
    
    /** Construtor privado da classe, inicializa o atributo valor Sorte Grande
     * inicialmente em zero.
     */
    private SorteGrande() {
        this.valor = 0.0;
    }
    
    /** Método que zera a instância da classe.
     */
    public static void zerarSingleton() {
        sorteGrande = null;
    }
    
    /** Método público estático de acesso único ao objeto.
     *
     * @return SorteGrande sorteGrande
     */
    public static SorteGrande getInstance() {

        if (sorteGrande == null) {
            sorteGrande = new SorteGrande();
        }
        return sorteGrande;
    }

    /** Método que retorna o valor Sorte Grande.
     * 
     * @return valor
     */
    public double getValor() {
        return valor;
    }

    /** Método que altera o valor Sorte Grande.
     * 
     * @param valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    /** Método que aumenta o valor Sorte Grande.
     * 
     * @param valor 
     */
    public void aumentaSorteGrande(double valor) {
        this.valor += valor;
    }
    
    /** Método que diminui o valor Sorte Grande.
     * 
     * @param valor 
     */
    public void diminuiSorteGrande(double valor) {
        this.valor -= valor;
    }
    
}