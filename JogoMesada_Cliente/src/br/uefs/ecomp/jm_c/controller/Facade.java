package br.uefs.ecomp.jm_c.controller;

import br.uefs.ecomp.jm_c.model.CartaCompras;
import br.uefs.ecomp.jm_c.model.CartaCorreio;
import java.util.ArrayList;


/**
 *
 * @author Camille Jesus
 */
public class Facade {
    
    private ControllerJogador controllerJogador;
    private ControllerCasa controllerCasa;
    private ControllerCarta controllerCarta;

    public Facade() {
        this.controllerJogador = new ControllerJogador();
        this.controllerCasa = new ControllerCasa();
        this.controllerCarta = new ControllerCarta();
    }

    public ControllerJogador getControllerJogador() {
        return controllerJogador;
    }

    public void setControllerJogador(ControllerJogador controllerJogador) {
        this.controllerJogador = controllerJogador;
    }

    public ControllerCasa getControllerCasa() {
        return controllerCasa;
    }

    public void setControllerCasa(ControllerCasa controllerCasa) {
        this.controllerCasa = controllerCasa;
    }

    public ControllerCarta getControllerCarta() {
        return controllerCarta;
    }

    public void setControllerCarta(ControllerCarta controllerCarta) {
        this.controllerCarta = controllerCarta;
    }
    
    public double retornaSaldo() {
        return (this.controllerJogador.retornaSaldo());
    }
    
    public double retornaDivida() {
        return (this.controllerJogador.retornaDivida());
    }
    
    public double retornaSorteGrande() {
        return (this.controllerJogador.retornaSorteGrande());
    }
    
    public void pegaEmprestimo(double valor) {
        this.controllerJogador.pegaEmprestimo(valor);
    }
    
    public void pagaDivida(double valor) {
        this.controllerJogador.pagaDivida(valor);
    }
    
    public void ganhaSorteGrande() {
        this.controllerJogador.ganhaSorteGrande();
    }
    
    public void pegaCartaCorreio() {
        this.controllerJogador.pegaCartaCorreio(this.controllerCarta.escolheCartaCorreio());
    }
    
    public ArrayList<CartaCorreio> listaCartasCorreios() {
        return (this.controllerJogador.listaCartasCorreio());
    }
    
    public ArrayList<CartaCompras> listaCartasCompras() {
        return (this.controllerJogador.listaCartasCompras());
    }
    
    public CartaCompras escolheCartaCompras() {
        return (this.controllerCarta.escolheCartaCompras());
    }
    
    public void pegaCartaCompras(CartaCompras carta) {
        this.controllerJogador.pegaCartaCompras(carta);
    }
    
    public void vendeCartaCompras(CartaCompras carta) {
        this.controllerJogador.vendeCartaCompras(carta);
    }
    
    public int rolaDado() {
        return (this.controllerJogador.rolaDado());
    }
    
    public CartaCorreio buscaCartaCorreio(String tipo) {
        return (this.controllerJogador.buscaCartaCorreio(tipo));
    }
    
    public CartaCompras buscaCartaCompras(String tipo) {
        return (this.controllerJogador.buscaCartaCompras(tipo));
    }
    
    public void acaoCartaCorreio(String jogadorAtual, String jogadorEscolhido, CartaCorreio carta) {
        this.controllerCarta.acaoCartaCorreio(jogadorAtual, jogadorEscolhido, carta);
    }
    
    public void acaoCartaCompras(CartaCompras carta) {
        this.controllerCarta.acaoCartaCompras(carta);
    }
    
    public void acaoCasaPremio() {
        this.controllerCasa.acaoCasaPremio();
    }
    
    public void acaoCasaBolaoEsportes(boolean participa, int numeroJogadores, int numeroEscolhido, int numeroDado) {
        this.controllerCasa.acaoCasaBolaoEsportes(participa, numeroJogadores, numeroEscolhido, numeroDado);
    }
    
    public void acaoCasaPraiaDomingo(double valor) {
        this.controllerCasa.acaoCasaPraiaDomingo(valor);
    }
    
    public void acaoCasaAjudeFlorestaAmazonica(double valor) {
        this.controllerCasa.acaoCasaAjudeFlorestaAmazonica(valor);
    }
    
    public void acaoCasaLanchonete(double valor) {
        this.controllerCasa.acaoCasaLanchonete(valor);
    }
    
    public void acaoCasaComprasShopping(double valor) {
        this.controllerCasa.acaoCasaComprasShopping(valor);
    }    
    
    public void acaoCasaConcursoBandaRock(int numeroDado) {
        this.controllerCasa.acaoCasaConcursoBandaRock(numeroDado);
    }
    
    public void acaoCasaFelizAniversario(int numeroJogadores, String jogadorAtual) {
        this.controllerCasa.acaoCasaFelizAniversario(numeroJogadores, jogadorAtual);
    }
    
    public void acaoCasaNegocioOcasiao(int numeroDado) {
        this.controllerCasa.acaoCasaNegocioOcasiao(numeroDado);
    }
    
    public void acaoCasaMaratonaBeneficente() {
        this.controllerCasa.acaoCasaMaratonaBeneficente();
    }
    
    public void acaoCasaDiaMesada() {
        this.controllerCasa.acaoCasaDiaMesada();
    }
    
}