package br.uefs.ecomp.jm_c.controller;

import br.uefs.ecomp.jm_c.model.CartaCompras;
import br.uefs.ecomp.jm_c.model.CartaCorreio;
import java.util.ArrayList;


/**
 * Classe Facade, responsável por integrar todos o controllers do model.
 * 
 * @author Camille Jesus
 */
public class Facade {
    
    private ControllerJogador controllerJogador;
    private ControllerCasa controllerCasa;
    private ControllerCarta controllerCarta;

    /** Construtor da classe, inicializa as instâncias dos controllers.
     */
    public Facade() {
        this.controllerJogador = new ControllerJogador();
        this.controllerCasa = new ControllerCasa();
        this.controllerCarta = new ControllerCarta();
    }

    /** Método que retorna controller do jogador.
     * 
     * @return controllerJogador ControllerJogador
     */
    public ControllerJogador getControllerJogador() {
        return this.controllerJogador;
    }

    /** Método que altera o controller do jogador.
     * 
     * @param controllerJogador
     */
    public void setControllerJogador(ControllerJogador controllerJogador) {
        this.controllerJogador = controllerJogador;
    }

    /** Método que retorna o controller de casa.
     * 
     * @return controllerCasa ControllerCasa
     */
    public ControllerCasa getControllerCasa() {
        return this.controllerCasa;
    }

     /** Método que altera o controller de casa.
     * 
     * @param controllerCasa
     */
    public void setControllerCasa(ControllerCasa controllerCasa) {
        this.controllerCasa = controllerCasa;
    }

    /** Método que retorna o controller de carta.
     * 
     * @return controllerCarta ControllerCarta
     */
    public ControllerCarta getControllerCarta() {
        return this.controllerCarta;
    }

     /** Método que altera o controller de carta.
     * 
     * @param controllerCarta
     */
    public void setControllerCarta(ControllerCarta controllerCarta) {
        this.controllerCarta = controllerCarta;
    }
    
    /** Método que retorna um número aleatório de 1 à 6, representando a rolagem
     * do dado (d6).
     * 
     * @return numeroDado int
     */
    public int rolaDado() {
        return (this.controllerJogador.rolaDado());
    }
    
     /** Método que retorna o saldo da conta do jogador.
     * 
     * @return saldo double
     */
    public double retornaSaldo() {
        return (this.controllerJogador.retornaSaldo());
    }
    
    /** Método que retorna a dívida da conta do jogador.
     * 
     * @return divida double
     */
    public double retornaDivida() {
        return (this.controllerJogador.retornaDivida());
    }
    
    public void pegaEmprestimo(double valor) {
        this.controllerJogador.pegaEmprestimo(valor);
    }
    
    public void pagaDivida(double valor) {
        this.controllerJogador.pagaDivida(valor);
    }
    
    /** Método que retorna o valor do Sorte Grande.
     * 
     * @return valor double
     */
    public double retornaSorteGrande() {
        return (this.controllerJogador.retornaSorteGrande());
    }
    
    /** Método que tranfere o valor de Sorte Grande para o saldo do jogador.
     */
    public void ganhaSorteGrande() {
        this.controllerJogador.ganhaSorteGrande();
    }
    
    /** Método de ação para casa Prêmio.
     */
    public void acaoCasaPremio() {
        this.controllerCasa.acaoCasaPremio();
    }
    
    /** Método de ação para casa Bolão de Esportes.
     * 
     * @param participa
     * @param numeroJogadores
     * @param numeroEscolhido
     * @param numeroDado
     */
    public void acaoCasaBolaoEsportes(boolean participa, int numeroJogadores, int numeroEscolhido, int numeroDado) {
        this.controllerCasa.acaoCasaBolaoEsportes(participa, numeroJogadores, numeroEscolhido, numeroDado);
    }
    
    /** Método de ação para casa Praia no Domingo.
     * 
     * @param valor
     */
    public void acaoCasaPraiaDomingo(double valor) {
        this.controllerCasa.acaoCasaPraiaDomingo(valor);
    }
    
    /** Método de ação para casa Ajude a Floresta Amazônica.
     * 
     * @param valor
     */
    public void acaoCasaAjudeFlorestaAmazonica(double valor) {
        this.controllerCasa.acaoCasaAjudeFlorestaAmazonica(valor);
    }
    
    /** Método de ação para casa Lanchonete.
     * 
     * @param valor
     */
    public void acaoCasaLanchonete(double valor) {
        this.controllerCasa.acaoCasaLanchonete(valor);
    }
    
    /** Método de ação para casa Compras no Shopping.
     * 
     * @param valor
     */
    public void acaoCasaComprasShopping(double valor) {
        this.controllerCasa.acaoCasaComprasShopping(valor);
    }    
    
    /** Método de ação para casa Concurso de Banda de Rock.
     * 
     * @param numeroDado
     */
    public void acaoCasaConcursoBandaRock(int numeroDado) {
        this.controllerCasa.acaoCasaConcursoBandaRock(numeroDado);
    }
    
    /** Método de ação para casa Feliz Aniversário.
     * 
     * @param numeroJogadores
     * @param jogadorAtual
     */
    public void acaoCasaFelizAniversario(int numeroJogadores, String jogadorAtual) {
        this.controllerCasa.acaoCasaFelizAniversario(numeroJogadores, jogadorAtual);
    }
    
    /** Método de ação para casa Negócio de Ocasião.
     * 
     * @param numeroDado
     */
    public void acaoCasaNegocioOcasiao(int numeroDado) {
        this.controllerCasa.acaoCasaNegocioOcasiao(numeroDado);
    }
    
    /** Método de ação para casa Maratona Beneficente.
     */
    public void acaoCasaMaratonaBeneficente() {
        this.controllerCasa.acaoCasaMaratonaBeneficente();
    }
    
    /** Método de ação para casa Dia da Mesada.
     */
    public void acaoCasaDiaMesada() {
        this.controllerCasa.acaoCasaDiaMesada();
    }
    
    /** Método que escolhe aleatoriamente uma carta Correio e adiciona à mão do jogador.
     */
    public void pegaCartaCorreio() {
        this.controllerJogador.pegaCartaCorreio(this.controllerCarta.escolheCartaCorreio());
    }
    
    /** Método que lista as cartas Correios à mão do jogador.
     * 
     * @return cartas cartasCorreio
     */
    public ArrayList<CartaCorreio> listaCartasCorreios() {
        return (this.controllerJogador.listaCartasCorreio());
    }
    
    /** Método que lista as cartas Compras à mão do jogador.
     * 
     * @return cartas cartasCompras
     */
    public ArrayList<CartaCompras> listaCartasCompras() {
        return (this.controllerJogador.listaCartasCompras());
    }
    
    /** Método que retorna uma carta Compras de sua lista aleatoriamente.
     * 
     * @return cartaCorreio
     */
    public CartaCompras escolheCartaCompras() {
        return (this.controllerCarta.escolheCartaCompras());
    }
    
    /** Método que adiciona uma carta Compras à mão do jogador.
     * 
     * @param carta
     */
    public void pegaCartaCompras(CartaCompras carta) {
        this.controllerJogador.pegaCartaCompras(carta);
    }
    
    /** Método que vende uma carta Compras.
     * 
     * @param carta
     */
    public void vendeCartaCompras(CartaCompras carta) {
        this.controllerJogador.vendeCartaCompras(carta);
    }
    
    /** Método que busca uma carta Correio na lista à mão do jogador.
     * 
     * @param tipo
     * @return carta CartaCorreio
     */
    public CartaCorreio buscaCartaCorreio(String tipo) {
        return (this.controllerJogador.buscaCartaCorreio(tipo));
    }
    
    /** Método que busca uma carta Compras na lista à mão do jogador.
     * 
     * @param descricao
     * @return carta CartaCompras
     */
    public CartaCompras buscaCartaCompras(String tipo) {
        return (this.controllerJogador.buscaCartaCompras(tipo));
    }
    
    /** Método que, a partir do tipo da carta Correio, realiza sua ação específica.
     * 
     * @param jogadorAtual
     * @param jogadorEscolhido
     * @param carta
     */
    public void acaoCartaCorreio(String jogadorAtual, String jogadorEscolhido, CartaCorreio carta) {
        this.controllerCarta.acaoCartaCorreio(jogadorAtual, jogadorEscolhido, carta);
    }
    
    /** Método de ação para carta Compras.
     * 
     * @param carta
     */
    public void acaoCartaCompras(CartaCompras carta) {
        this.controllerCarta.acaoCartaCompras(carta);
    }
    
}