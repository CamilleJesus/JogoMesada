package br.uefs.ecomp.jm_c.model;

import java.util.ArrayList;


/**
 *
 * @author Camille Jesus
 */
public class Jogador {
    
    private String nickname;
    private String senha;
    private Conta conta;
    private ArrayList<CartaCorreio> cartasCorreio;
    private ArrayList<CartaCompras> cartasCompras;
    private static Jogador jogador;
    
    private Jogador() {
        this.conta = new Conta();
        this.cartasCorreio = new ArrayList<>();
        this.cartasCompras = new ArrayList<>();
    }
    
    public String getNickname() {
        return nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public ArrayList<CartaCorreio> getCartasCorreio() {
        return cartasCorreio;
    }

    public void setCartasCorreio(ArrayList<CartaCorreio> cartasCorreio) {
        this.cartasCorreio = cartasCorreio;
    }

    public ArrayList<CartaCompras> getCartasCompras() {
        return cartasCompras;
    }

    public void setCartasCompras(ArrayList<CartaCompras> cartasCompras) {
        this.cartasCompras = cartasCompras;
    }
    
    public static void zerarSingleton() {
        jogador = null;
    }
    
    public static Jogador getInstance() {

        if (jogador == null) {
            jogador = new Jogador();
        }
        return jogador;
    }
    
    public void adicionaCartaCorreio(CartaCorreio carta) {
        this.cartasCorreio.add(carta);
    }
    
    public void removeCartaCorreio(CartaCorreio carta) {
        this.cartasCorreio.remove(carta);
    }
    
    public void adicionaCartaCompras(CartaCompras carta) {
        this.cartasCompras.add(carta);
    }
    
    public void removeCartaCompras(CartaCompras carta) {
        this.cartasCompras.remove(carta);
    }
    
    public void pegaEmprestimo(double valor) {
        this.conta.aumentaSaldo(valor);
        this.conta.aumentaDivida(valor);
    }
    
    public void pagaDivida(double valor) {
        this.conta.diminuiSaldo(valor);
        this.conta.diminuiDivida(valor);
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (obj instanceof Jogador) {
            
            if (this.nickname.equals(((Jogador) obj).getNickname())) {
                return true;
            }
        }
        return false;
    }
    
}