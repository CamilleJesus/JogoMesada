package br.uefs.ecomp.jm_c.controller;

import br.uefs.ecomp.jm_c.connection.TrataJogador;
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
    private TrataJogador trataJogador = new TrataJogador();
    
    /** Construtor da classe, recupera as instâncias de jogador e sorte grande.
     */
    public ControllerJogador() {
        this.jogador = Jogador.getInstance();
        this.sorteGrande = SorteGrande.getInstance();
    }
    
    
    
    /** Método que retorna um número aleatório de 1 à 6, representando a rolagem
     * do dado (d6).
     * 
     * @return numeroDado int
     */
    public int rolaDado() {
        return ((int) ((Math.random() * 6) + 1));
    }
    
    /** Método que retorna o saldo da conta do jogador.
     * 
     * @return saldo double
     */
    public double retornaSaldo() {
        return (this.jogador.getConta().getSaldo());
    }
    
    /** Método que retorna a dívida da conta do jogador.
     * 
     * @return divida double
     */
    public double retornaDivida() {
        return (this.jogador.getConta().getDivida());
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
        this.sorteGrande.setValor(0);
        
        this.trataJogador.enviaString("zeraSorteGrande");
    }
    
    /** Método que retorna o valor do Sorte Grande.
     * 
     * @return valor double
     */
    public double retornaSorteGrande() {
        return (this.sorteGrande.getValor());
    }
    
    /** Método que adiciona uma carta Correio à mão do jogador.
     * 
     * @param carta
     */
    public void pegaCartaCorreio(CartaCorreio carta) {
        this.jogador.adicionaCartaCorreio(carta);
    }   
    
    /** Método que busca uma carta Correio na lista à mão do jogador.
     * 
     * @param tipo
     * @return carta CartaCorreio
     */
    public CartaCorreio buscaCartaCorreio(String tipo) {
        ArrayList<CartaCorreio> cartas = this.listaCartasCorreio();
        
        for (int i = 0; i < cartas.size(); i++) {
            CartaCorreio carta = cartas.get(i);
            
            if (tipo.equals(carta.getTipo())){
                return carta;
            }
        }
        return null;
    }
    
    /** Método que busca uma carta Compras na lista à mão do jogador.
     * 
     * @param descricao
     * @return carta CartaCompras
     */
    public CartaCompras buscaCartaCompras(String descricao) {
        ArrayList<CartaCompras> cartas = this.listaCartasCompras();
        
        for (int i = 0; i < cartas.size(); i++) {
            CartaCompras carta = cartas.get(i);
            
            if (descricao.equals(carta.getDescricao())){
                return carta;
            }
        }
        return null;
    }
    
    /** Método que lista as cartas Correios à mão do jogador.
     * 
     * @return cartas cartasCorreio
     */
    public ArrayList<CartaCorreio> listaCartasCorreio() {
        return (this.jogador.getCartasCorreio());
    }
    
    /** Método que lista as cartas Compras à mão do jogador.
     * 
     * @return cartas cartasCompras
     */
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
    
}