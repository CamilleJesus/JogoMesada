package br.uefs.ecomp.jm_c.controller;

import br.uefs.ecomp.jm_c.model.CartaCompras;
import br.uefs.ecomp.jm_c.model.CartaCorreio;
import br.uefs.ecomp.jm_c.model.Jogador;
import br.uefs.ecomp.jm_c.model.SorteGrande;
import java.util.ArrayList;


/**
 * A classe ControllerCasa, como o nome sugere, é o controlador de casas, responsável
 * pelas ações de cada casa do tabuleiro.
 * 
 * @author Camille Jesus
 */
public class ControllerJogador {

    private Jogador jogador;
    private SorteGrande sorteGrande;
    
    /** Construtor da classe, recupera as instâncias de jogador e sorte grande.
     */
    public ControllerJogador() {
        this.jogador = Jogador.getInstance();
        this.sorteGrande = SorteGrande.getInstance();
    }
    
    /** Método que chama o método pegar empréstimo, ou seja, aumenta o saldo e
     * aumenta a dívida (da conta) do jogador.
     *
     * @param valor
     */
    public void pegaEmprestimo(double valor) {
        this.jogador.pegaEmprestimo(valor);
    }
    
    /** Método que chama o método pagar dívida, ou seja, aumenta o saldo e
     * aumenta a dívida (da conta) do jogador.
     *
     * @param valor
     */
    public void pagaDivida(double valor) {
        this.jogador.pagaDivida(valor);
    }
    
    /** Método que tranfere o valor de Sorte Grande para o saldo do jogador.
     */
    public void ganhaSorteGrande() {
        this.jogador.getConta().aumentaSaldo(sorteGrande.getValor());
        this.sorteGrande.setValor(0.0);
    }
    
    /** Método que adiciona uma carta Correio à mão do jogador.
     * 
     * @param carta
     */
    public void pegaCartaCorreio(CartaCorreio carta) {
        this.jogador.adicionaCartaCorreio(carta);
    }
    
    public ArrayList<CartaCorreio> listaCartasCorreio() {
        return (this.jogador.getCartasCorreio());
    }
    
    public ArrayList<CartaCompras> listaCartasCompras() {
        return (this.jogador.getCartasCompras());
    }
    
    /** Método que adiciona uma carta Compras à mão do jogador.
     * 
     * @param carta
     */
    public void pegaCartaCompras(CartaCompras carta) {
        this.jogador.adicionaCartaCompras(carta);
    }
    
    /** Método que vende uma carta Compras.
     * 
     * @param carta
     */
    public void vendeCartaCompras(CartaCompras carta) {
        this.jogador.getConta().aumentaSaldo(carta.getValorRevenda());
        this.jogador.getCartasCompras().remove(carta);
    }
    
    /** Método que retorna um número aleatório de 1 à 6, representando a rolagem
     * do dado (d6).
     * 
     * @return numeroDado
     */
    public int rolaDado() {
        return ((int) ((Math.random() * 6) + 1));
    }
    
    public double retornaSaldo() {
        return (this.jogador.getConta().getSaldo());
    }
    
    public double retornaDivida() {
        return (this.jogador.getConta().getDivida());
    }
    
    public double retornaSorteGrande() {
        return (this.sorteGrande.getValor());
    }
    
}