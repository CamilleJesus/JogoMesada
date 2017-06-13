package br.uefs.ecomp.jm_c.controller;

import br.uefs.ecomp.jm_c.connection.TrataJogador;
import br.uefs.ecomp.jm_c.model.Jogador;
import br.uefs.ecomp.jm_c.model.SorteGrande;


/**
 * A classe ControllerCasa, como o nome sugere, é o controlador de casas, responsável
 * pelas ações de cada casa do tabuleiro.
 * 
 * @author Camille Jesus e Felipe Damasceno
 */
public class ControllerCasa {
    
    private Jogador jogador;
    private SorteGrande sorteGrande;
    private TrataJogador trataJogador = new TrataJogador();

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
     * 
     * @param participa
     * @param numeroJogadores
     * @param numeroEscolhido
     * @param numeroDado
     */
    public void acaoCasaBolaoEsportes(boolean participa, int numeroJogadores, int numeroEscolhido, int numeroDado) {
        
        if (participa == true) {
            double valor = 1000 + (100 * numeroJogadores);   //Número de jogadores que escolheram participar, exceto ele
            
            if (numeroEscolhido == numeroDado) {
                this.jogador.getConta().aumentaSaldo(valor);
            } else {
                this.jogador.getConta().diminuiSaldo(100);
            }
        }
    }
    
    /** Método de ação para casa Praia no Domingo.
     * 
     * @param valor
     */
    public void acaoCasaPraiaDomingo(double valor) {
        double saldo = this.jogador.getConta().getSaldo();
        
        if (saldo < valor) {
            this.jogador.pegaEmprestimo(valor - saldo);
        }
        this.jogador.getConta().diminuiSaldo(valor);
        this.sorteGrande.aumentaSorteGrande(valor);
        
        this.trataJogador.enviaString("aumentaSorteGrande");
        this.trataJogador.enviaDecimal(valor);
    }
    
    /** Método de ação para casa Ajude a Floresta Amazônica.
     * 
     * @param valor
     */
    public void acaoCasaAjudeFlorestaAmazonica(double valor) {
        double saldo = this.jogador.getConta().getSaldo();
        
        if (saldo < valor) {
            this.jogador.pegaEmprestimo(valor - saldo);
        }
        this.jogador.getConta().diminuiSaldo(valor);
        this.sorteGrande.aumentaSorteGrande(valor);
        
        this.trataJogador.enviaString("aumentaSorteGrande");
        this.trataJogador.enviaDecimal(valor);
    }
    
    /** Método de ação para casa Lanchonete.
     * 
     * @param valor
     */
    public void acaoCasaLanchonete(double valor) {
        double saldo = this.jogador.getConta().getSaldo();
        
        if (saldo < valor) {
            this.jogador.pegaEmprestimo(valor - saldo);
        }
        this.jogador.getConta().diminuiSaldo(valor);
        this.sorteGrande.aumentaSorteGrande(valor);
        
        this.trataJogador.enviaString("aumentaSorteGrande");
        this.trataJogador.enviaDecimal(valor);
    }
    
    /** Método de ação para casa Compras no Shopping.
     * 
     * @param valor
     */
    public void acaoCasaComprasShopping(double valor) {
        double saldo = this.jogador.getConta().getSaldo();
        
        if (saldo < valor) {
            this.jogador.pegaEmprestimo(valor - saldo);
        }
        this.jogador.getConta().diminuiSaldo(valor);
        this.sorteGrande.aumentaSorteGrande(valor);
        
        this.trataJogador.enviaString("aumentaSorteGrande");
        this.trataJogador.enviaDecimal(valor);
    }
    
    /** Método de ação para casa Concurso de Banda de Rock.
     * 
     * @param numeroDado
     */
    public void acaoCasaConcursoBandaRock(int numeroDado) {
        
        if (numeroDado == 3) {
            this.jogador.getConta().aumentaSaldo(1000);            
        }
    }
    
    /** Método de ação para casa Feliz Aniversário.
     * 
     * @param numeroJogadores
     * @param jogadorAtual
     */
    public void acaoCasaFelizAniversario(int numeroJogadores, String jogadorAtual) {        
        this.jogador.getConta().aumentaSaldo(numeroJogadores * 100.0);
            
        this.trataJogador.enviaString("felizAniversario");
        this.trataJogador.enviaString(jogadorAtual);
    }
    
    /** Método de ação para casa Negócio de Ocasião.
     * 
     * @param numeroDado
     */
    public void acaoCasaNegocioOcasiao(int numeroDado) {
        this.jogador.getConta().diminuiSaldo(numeroDado * 100.0);
    }
    
    /** Método de ação para casa Maratona Beneficente.
     */
    public void acaoCasaMaratonaBeneficente() {                                
        this.trataJogador.enviaString("maratonaBeneficente");
    }
    
    /** Método de ação para casa Dia da Mesada.
     */
    public void acaoCasaDiaMesada() {
        this.jogador.getConta().aumentaSaldo(3500.0);
        this.jogador.getConta().setDivida(this.jogador.getConta().getDivida() * 1.1);        
    }
       
}