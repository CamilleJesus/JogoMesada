package br.uefs.ecomp.jm_c.controller;

import br.uefs.ecomp.jm_c.model.CartaCompras;
import br.uefs.ecomp.jm_c.model.Jogador;
import br.uefs.ecomp.jm_c.model.SorteGrande;

import java.util.ArrayList;


/**
 *
 * @author Camille Jesus
 */
public class ControllerPartida {
    
    private Jogador jogadorAtual;
    private SorteGrande sorteGrande;
    private ArrayList<Jogador> jogadores;

    public ControllerPartida(String nickname, String senha) {
        this.jogadorAtual = Jogador.getInstance();
        this.sorteGrande = SorteGrande.getInstance();
        this.jogadores = new ArrayList<>();
    }

    public Jogador getJogador() {
        return jogadorAtual;
    }

    public void setJogador(Jogador jogador) {
        this.jogadorAtual = jogador;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
    
    public void adicionaJogador(Jogador jogador) {
        this.jogadores.add(jogador);
    }
    
    public void removeJogador(Jogador jogador) {
        this.jogadores.remove(jogador);
    }
    
    public void casaAchouComprador(CartaCompras carta) {
        this.jogadorAtual.getConta().aumentaSaldo(carta.getValorRevenda());
    }
    
    public void casaPremio() {
        this.jogadorAtual.getConta().aumentaSaldo(5000.0);
    }
    
    public void casaBolaoEsportes() {
        
    }
    
    public void casaPraiaDomingo(double valor) {
        this.jogadorAtual.getConta().diminuiSaldo(valor);
        this.sorteGrande.aumentaSorteGrande(valor);
    }
    
    public void casaAjudeFlorestaAmazonica(double valor) {
        this.jogadorAtual.getConta().diminuiSaldo(valor);
        this.sorteGrande.aumentaSorteGrande(valor);
    }
    
    public void casaLanchonete(double valor) {
        this.jogadorAtual.getConta().diminuiSaldo(valor);
        this.sorteGrande.aumentaSorteGrande(valor);
    }
    
    public void casaComprasShopping(double valor) {
        this.jogadorAtual.getConta().diminuiSaldo(valor);
        this.sorteGrande.aumentaSorteGrande(valor);
    }
    
    public void casaConcursoBandaRock() {
        
    }
    
    public void casaFelizAniversario(boolean tirouCarta, int jogadores) {
        
        if (tirouCarta == true) {
            this.jogadorAtual.getConta().aumentaSaldo(jogadores * 100.0);            
        } else if (tirouCarta == false) {
            this.jogadorAtual.getConta().diminuiSaldo(100);
        }
    }
    
    public void casaVendese() {
        int numeroDado = 1;
        this.jogadorAtual.getConta().diminuiSaldo(numeroDado * 100.0);
    }
    
    public void casaMaratonaBeneficente(boolean tirouCarta) {
                
        if (tirouCarta == false) {
            int numeroDado = 1;
            double valor = (numeroDado * 100.0);
            this.jogadorAtual.getConta().diminuiSaldo(valor);
            this.sorteGrande.aumentaSorteGrande(valor);
        }
    }
    
    public void casaSorteGrande() {
        
    }
    
    /*
    public void casaDiaMesada() {
        this.jogadorAtual.getConta().aumentaSaldo(3500.0);
        double divida = this.jogadorAtual.getConta().getDivida();
        double juros = divida * 0.1;
        double novaDivida = divida + juros;
        this.jogadorAtual.getConta().setDivida(novaDivida);
        
        if (this.jogadorAtual.getConta().getSaldo() > novaDivida) {
            this.jogadorAtual.pagaDivida(novaDivida);
        } else {
            this.jogadorAtual.pagaDivida(juros);
        }
        
        //ArrayList<CartaCorreio> cartasContas = this.jogadorAtual.getCartasContasViradas();
        double valor = 0.0;
        
        for (int i = 0; i < cartasContas.size(); i++) {
            valor += cartasContas.get(i).getValor();
        }
        
        this.jogadorAtual.getConta().diminuiSaldo(valor);
    }
    */
       
}