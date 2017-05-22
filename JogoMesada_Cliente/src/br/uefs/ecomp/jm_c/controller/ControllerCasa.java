package br.uefs.ecomp.jm_c.controller;

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
public class ControllerCasa {
    
    private Jogador jogador;
    private SorteGrande sorteGrande;

    /** Construtor da classe, recupera as instâncias de jogador e sorte grande.
     */
    public ControllerCasa() {
        this.jogador = Jogador.getInstance();
        this.sorteGrande = SorteGrande.getInstance();
    }
    
    /** Método de ação para casa Prêmio.
     */
    public void acaoCasaPremio() {
        this.jogador.getConta().aumentaSaldo(5000.0);
    }
    
    /** Método de ação para casa Bolão de Esportes.
     */
    public void acaoCasaBolaoEsportes() {
        
    }
    
    /** Método de ação para casa Praia no Domingo.
     * 
     * @param valor
     */
    public void acaoCasaPraiaDomingo(double valor) {
        this.jogador.getConta().diminuiSaldo(valor);
        this.sorteGrande.aumentaSorteGrande(valor);
    }
    
    /** Método de ação para casa Ajude a Floresta Amazônica.
     * 
     * @param valor
     */
    public void acaoCasaAjudeFlorestaAmazonica(double valor) {
        this.jogador.getConta().diminuiSaldo(valor);
        this.sorteGrande.aumentaSorteGrande(valor);
    }
    
    /** Método de ação para casa Lanchonete.
     * 
     * @param valor
     */
    public void acaoCasaLanchonete(double valor) {
        this.jogador.getConta().diminuiSaldo(valor);
        this.sorteGrande.aumentaSorteGrande(valor);
    }
    
    /** Método de ação para casa Compras no Shopping.
     * 
     * @param valor
     */
    public void acaoCasaComprasShopping(double valor) {
        this.jogador.getConta().diminuiSaldo(valor);
        this.sorteGrande.aumentaSorteGrande(valor);
    }
    
    /** Método de ação para casa Concurso de Banda de Rock.
     */
    public void acaoCasaConcursoBandaRock() {
        
    }
    
    /** Método de ação para casa Feliz Aniversário.
     * 
     * @param tirouCarta
     * @param jogadores
     */
    public void acaoCasaFelizAniversario(boolean tirouCarta, int jogadores) {
        
        if (tirouCarta == true) {
            this.jogador.getConta().aumentaSaldo(jogadores * 100.0);            
        } else if (tirouCarta == false) {
            this.jogador.getConta().diminuiSaldo(100);
        }
    }
    
    /** Método de ação para casa Negócio de Ocasião.
     * 
     * @return numeroDado
     */
    public int acaoCasaNegocioOcasiao() {
        int numeroDado = ((int) ((Math.random() * 6) + 1));
        this.jogador.getConta().diminuiSaldo(numeroDado * 100.0);
        return numeroDado;
    }
    
    /** Método de ação para casa Maratona Beneficente.
     * 
     * @param estaCasa
     * @return numeroDado
     */
    public int acaoCasaMaratonaBeneficente(boolean estaCasa) {
                        
        if (estaCasa == false) {
            int numeroDado = ((int) ((Math.random() * 6) + 1));
            double valor = (numeroDado * 100.0);
            this.jogador.getConta().diminuiSaldo(valor);
            this.sorteGrande.aumentaSorteGrande(valor);
            return numeroDado;
        }
        return 0;
    }
    
    /** Método de ação para casa Dia da Mesada.
     */
    public void acaoCasaDiaMesada() {
        this.jogador.getConta().aumentaSaldo(3500.0);
        double divida = this.jogador.getConta().getDivida();
        double juros = divida * 0.1;
        double novaDivida = divida + juros;
        this.jogador.getConta().setDivida(novaDivida);
        
        if (this.jogador.getConta().getSaldo() > novaDivida) {
            this.jogador.pagaDivida(novaDivida);
        } else {
            this.jogador.pagaDivida(juros);
        }
        
        ArrayList<CartaCorreio> cartasContas = this.jogador.getCartasCorreio();
        double valor = 0.0;
        
        for (int i = 0; i < cartasContas.size(); i++) {
            CartaCorreio carta = cartasContas.get(i);
            if (carta.getTipoCarta().equals("Contas")) {
                valor += carta.getValor();                
            }
        }
        
        this.jogador.getConta().diminuiSaldo(valor);
    }
       
}