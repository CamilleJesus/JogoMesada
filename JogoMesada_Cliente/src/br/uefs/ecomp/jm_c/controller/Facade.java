package br.uefs.ecomp.jm_c.controller;

import br.uefs.ecomp.jm_c.model.CartaCompras;
import br.uefs.ecomp.jm_c.model.CartaCorreio;


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
    
    public void pegaCartaCompras() {
        this.controllerJogador.pegaCartaCompras(this.controllerCarta.escolheCartaCompras());
    }
    
    public void vendeCartaCompras(CartaCompras carta) {
        this.controllerJogador.vendeCartaCompras(carta);
    }
    
    public int rolaDado() {
        return (this.controllerJogador.rolaDado());
    }
    
    public void acaoCartaCorreio(boolean tirouCarta, CartaCorreio carta) {
        this.controllerCarta.acaoCartaCorreio(tirouCarta, carta);
    }
    
    public void acaoCartaCompras(CartaCompras carta) {
        this.controllerCarta.acaoCartaCompras(carta);
    }
    
    public void acaoCasaPremio() {
        this.controllerCasa.acaoCasaPremio();
    }
    
    public void acaoCasaBolaoEsportes() {
        this.controllerCasa.acaoCasaBolaoEsportes();
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
    
    public void acaoCasaFelizAniversario(boolean tirouCarta, int jogadores) {
        this.controllerCasa.acaoCasaFelizAniversario(tirouCarta, jogadores);
    }
    
    public int acaoCasaNegocioOcasiao() {
        return (this.controllerCasa.acaoCasaNegocioOcasiao());
    }
    
    public int acaoCasaMaratonaBeneficente(boolean estaCasa) {
        return (this.controllerCasa.acaoCasaMaratonaBeneficente(estaCasa));
    }
    
    public void acaoCasaDiaMesada() {
        this.controllerCasa.acaoCasaDiaMesada();
    }
    
}