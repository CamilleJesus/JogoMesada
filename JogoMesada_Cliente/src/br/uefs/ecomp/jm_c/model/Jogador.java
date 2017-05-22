package br.uefs.ecomp.jm_c.model;

import java.util.ArrayList;


/**
 * Classe Singleton Jogador, permite criar apenas um jogador, possui um nickname,
 * uma senha, uma conta associada e duas listas de cartas, Correio e Compras.
 * 
 * @author Camille Jesus
 */
public class Jogador {    
    
    private static Jogador jogador;   //Autoreferência
    
    private String nickname;
    private String senha;
    private Conta conta;
    private ArrayList<CartaCorreio> cartasCorreio;
    private ArrayList<CartaCompras> cartasCompras;
    
    /** Construtor privado da classe, inicializa o atributo conta e as listas de
     * cartas (Correio e Compras).
     */
    private Jogador() {
        this.conta = new Conta();
        this.cartasCorreio = new ArrayList<>();
        this.cartasCompras = new ArrayList<>();
    }   
    
    /** Método que zera a instância da classe.
     */
    public static void zerarSingleton() {
        jogador = null;
    }
    
    /** Método público estático de acesso único ao objeto.
     *
     * @return Jogador jogador
     */
    public static Jogador getInstance() {

        if (jogador == null) {
            jogador = new Jogador();
        }
        return jogador;
    }
    
    /** Método que retorna o nickname do jogador.
     * 
     * @return nickname
     */
    public String getNickname() {
        return this.nickname;
    }
    
    /** Método que altera o nickname do jogador.
     * 
     * @param nickname 
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    /** Método que retorna a senha do jogador.
     * 
     * @return senha
     */
    public String getSenha() {
        return this.senha;
    }
    
    /** Método que altera a senha do jogador.
     * 
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /** Método que retorna a conta associada ao jogador.
     * 
     * @return conta
     */
    public Conta getConta() {
        return this.conta;
    }

    /** Método que altera a conta associada ao jogador.
     * 
     * @param conta
     */
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    /** Método que realiza o empréstimo, ou seja, aumenta o saldo e aumenta a dívida
     * (da conta) do jogador.
     *
     * @param valor
     */
    public void pegaEmprestimo(double valor) {
        this.conta.aumentaSaldo(valor);
        this.conta.aumentaDivida(valor);
    }
    
    /** Método que realiza o pagamento do empréstimo, ou seja, diminui o saldo e
     * diminui a dívida (da conta) do jogador.
     *
     * @param valor
     */
    public void pagaDivida(double valor) {
        this.conta.diminuiSaldo(valor);
        this.conta.diminuiDivida(valor);
    }

    /** Método que retorna a lista de cartas Correio do jogador.
     * 
     * @return cartasCorreio
     */
    public ArrayList<CartaCorreio> getCartasCorreio() {
        return this.cartasCorreio;
    }

    /** Método que altera a lista de cartas Correio do jogador.
     * 
     * @param cartasCorreio
     */
    public void setCartasCorreio(ArrayList<CartaCorreio> cartasCorreio) {
        this.cartasCorreio = cartasCorreio;
    }

    /** Método que retorna a lista de cartas Compras do jogador.
     * 
     * @return cartaCompras
     */
    public ArrayList<CartaCompras> getCartasCompras() {
        return this.cartasCompras;
    }

    /** Método que altera a lista de cartas Compras do jogador.
     * 
     * @param cartasCompras
     */
    public void setCartasCompras(ArrayList<CartaCompras> cartasCompras) {
        this.cartasCompras = cartasCompras;
    }
    
    /** Método que adiciona uma carta Correio à lista de cartas Correio do jogador.
     *
     * @param carta
     */
    public void adicionaCartaCorreio(CartaCorreio carta) {
        this.cartasCorreio.add(carta);
    }
    
    /** Método que remove uma carta Correio da lista de cartas Correio do jogador.
     *
     * @param carta
     */
    public void removeCartaCorreio(CartaCorreio carta) {
        this.cartasCorreio.remove(carta);
    }
    
    /** Método que adiciona uma carta Compras à lista de cartas Compras do jogador.
     *
     * @param carta
     */
    public void adicionaCartaCompras(CartaCompras carta) {
        this.cartasCompras.add(carta);
    }
    
    /** Método que remove uma carta Compras da lista de cartas Compras do jogador.
     *
     * @param carta
     */
    public void removeCartaCompras(CartaCompras carta) {
        this.cartasCompras.remove(carta);
    }
    
    /** Método que verifica se dois jogadores são iguais retornando um valor booleano,
     * onde true significa que o objeto é igual e false que o objeto é diferente.
     * 
     * @param obj
     * @return true ou false
     */
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