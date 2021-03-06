package br.uefs.ecomp.jm_c.controller;

import br.uefs.ecomp.jm_c.connection.TrataJogador;
import br.uefs.ecomp.jm_c.model.CartaCompras;
import br.uefs.ecomp.jm_c.model.CartaCorreio;
import br.uefs.ecomp.jm_c.model.Jogador;
import br.uefs.ecomp.jm_c.model.SorteGrande;

import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 * A classe ControllerCarta, como o nome sugere, é o controlador de cartas,
 * responsável pela criação delas das categorias e tipos específicos e por
 * realizar a ação de cada uma.
 * 
 * @author Camille Jesus e Felipe Damasceno
 */
public class ControllerCarta {
 
    private ArrayList<CartaCorreio> cartasCorreio;
    private ArrayList<CartaCompras> cartasCompras;
    
    private Jogador jogador;
    private SorteGrande sorteGrande;
    private TrataJogador trataJogador;
    
    /** Construtor da classe, inicializa as listas de cartas (Correio e Compras)
     * e recupera as instâncias de jogador e sorte grande.
     */
    public ControllerCarta() {
        this.cartasCorreio = new ArrayList<>();
        this.cartasCompras = new ArrayList<>();
        this.jogador = Jogador.getInstance();
        this.sorteGrande = SorteGrande.getInstance();
        trataJogador = new TrataJogador();
        this.criaBaralho();
    }
    
    /** Método de criação de todas as cartas do jogo.
     *     
     */
    public final void criaBaralho() {
        this.criaCartasDinheiroExtra();
        this.criaCartasConta();
        this.criaCartasPagueVizinhoAgora();
        this.criaCartasDoacoes();
        this.criaCartasCobrancaMosntro();
        this.criaCartasVaParaFrenteAgora();
        this.criaCartasCompras();
    }
    
    /** Método de criação de cartas Correio, com seus respectivos tipo "Contas",
     * descrição e valor.
     */
    private void criaCartasConta() {
        CartaCorreio cartaConta1 = new CartaCorreio("Contas", "Mensalidade do Spotify Premium", 100.0);
        CartaCorreio cartaConta2 = new CartaCorreio("Contas", "Conta do World of Warcraft", 100.0);
        CartaCorreio cartaConta3 = new CartaCorreio("Contas", "Cordas da Guitarra", 100.0);

        cartasCorreio.add(cartaConta1);
        cartasCorreio.add(cartaConta2);
        cartasCorreio.add(cartaConta3);
    }
    
    /** Método de criação de cartas Correio, com seus respectivos tipo "Pague a um
     * Vizinho Agora", descrição e valor.
     */
    private void criaCartasPagueVizinhoAgora() {
        CartaCorreio cartaPagueVizinhoAgora1 = new CartaCorreio("Pague a um Vizinho Agora", "Pagamento de Fiança", 500.0);
        CartaCorreio cartaPagueVizinhoAgora2 = new CartaCorreio("Pague a um Vizinho Agora", "Racha do Churrasco", 500.0);
        CartaCorreio cartaPagueVizinhoAgora3 = new CartaCorreio("Pague a um Vizinho Agora", "Aluguel de Garagem", 500.0);

        cartasCorreio.add(cartaPagueVizinhoAgora1);
        cartasCorreio.add(cartaPagueVizinhoAgora2);
        cartasCorreio.add(cartaPagueVizinhoAgora3);
    }
    
    /** Método de criação de cartas Correio, com seus respectivos tipo "Dinheiro
     * Extra", descrição e valor.
     */
    private void criaCartasDinheiroExtra() {
        CartaCorreio cartaDinheiroExtra1 = new CartaCorreio("Dinheiro Extra", "Venda de Doces", 200.0);
        CartaCorreio cartaDinheiroExtra2 = new CartaCorreio("Dinheiro Extra", "Entrega de Jornal", 200.0);

        cartasCorreio.add(cartaDinheiroExtra1);
        cartasCorreio.add(cartaDinheiroExtra2);
    }
    
    /** Método de criação de cartas Correio, com seus respectivos tipo "Doações",
     * descrição e valor.
     */
    private void criaCartasDoacoes() {
        CartaCorreio cartaDoacoes1 = new CartaCorreio("Doações", "Sopão para Mendigos", 300.0);
        CartaCorreio cartaDoacoes2 = new CartaCorreio("Doações", "Contribuição para Orfanato", 300.0);

        cartasCorreio.add(cartaDoacoes1);
        cartasCorreio.add(cartaDoacoes2);
    }
    
    /** Método de criação de cartas Correio, com seus respectivos tipo "Cobrança
     * Monstro", descrição e valor.
     */
    private void criaCartasCobrancaMosntro() {
        CartaCorreio cartaDoacoes1 = new CartaCorreio("Cobrança Monstro", "Notebook Novo", 2000.0);
        CartaCorreio cartaDoacoes2 = new CartaCorreio("Cobrança Monstro", "Reforma da Casa", 2000.0);

        cartasCorreio.add(cartaDoacoes1);
        cartasCorreio.add(cartaDoacoes2);
    }
    
    /** Método de criação de cartas Correio, com seus respectivos tipo "Vá para
     * Frente Agora", descrição e valor.
     */
    private void criaCartasVaParaFrenteAgora() {
        CartaCorreio cartaVaParaFrente1 = new CartaCorreio("Vá para Frente Agora", "Vá para a próxima casa\n'Compras e Entretenimento'\nou 'Achou um Comprador'.", 0.0);
        CartaCorreio cartaVaParaFrente2 = new CartaCorreio("Vá para Frente Agora", "Vá para a próxima casa\n'Compras e Entretenimento'\nou 'Achou um Comprador'.", 0.0);

        cartasCorreio.add(cartaVaParaFrente1);
        cartasCorreio.add(cartaVaParaFrente2);
    }
    
    /** Método que retorna uma carta Correio de sua lista aleatoriamente.
     * 
     * @return cartaCorreio
     */
    public CartaCorreio escolheCartaCorreio() {
        return (this.cartasCorreio.get((int) (Math.random() * 14)));
    }
    
    /** Método que, a partir do tipo da carta Correio, realiza sua ação específica.
     * 
     * @param jogadorAtual
     * @param jogadorEscolhido
     * @param carta
     */
    public void acaoCartaCorreio(String jogadorAtual, String jogadorEscolhido, CartaCorreio carta) {
        
        switch (carta.getTipo()) {
            case "Contas":
                this.acaoCartaContas(carta);
                break;
            case "Pague a um Vizinho Agora":
                this.acaoCartaPagueVizinhoAgora(jogadorAtual, jogadorEscolhido, carta);
                break;
            case "Dinheiro Extra":
                this.acaoCartaDinheiroExtra(jogadorAtual, jogadorEscolhido, carta);
                break;
            case "Doações":
                this.acaoCartaDoacoes(carta);
                break;
            case "Cobrança Monstro":
                this.acaoCartaCobrancaMonstro(carta);
                break;
            case "Vá para Frente Agora":
                this.acaoCartaVaFrenteAgora(carta);
                break;
        }
    }
    
    public void saldoInsuficiente() {
        JOptionPane.showMessageDialog(null, "Saldo insuficiente!", "Alerta", JOptionPane.ERROR_MESSAGE);
    }
    
    /** Método específico de ação para carta Correio do tipo Contas.
     * 
     * @param carta
     */
    public void acaoCartaContas(CartaCorreio carta) {
        double valor = carta.getValor();
        
        if (this.jogador.getConta().getSaldo() >= valor) {
            this.jogador.getConta().diminuiSaldo(valor);
            this.jogador.removeCartaCorreio(carta);
        } else {
            this.saldoInsuficiente();
        }
    }   
    
    /** Método específico de ação para carta Correio do tipo Pague a um Vizinho Agora.
     * 
     * @param jogadorAtual
     * @param jogadorEscolhido
     * @param carta
     */
    public void acaoCartaPagueVizinhoAgora(String jogadorAtual, String jogadorEscolhido, CartaCorreio carta) {
        double valor = carta.getValor();
        double saldo = this.jogador.getConta().getSaldo();

        if (saldo < valor) {
            this.jogador.pegaEmprestimo(valor - saldo);
        }
        this.jogador.getConta().diminuiSaldo(valor);
        this.jogador.removeCartaCorreio(carta);
        
        this.trataJogador.enviaJogadorString(jogadorEscolhido, "pagueVizinho");
        this.trataJogador.enviaJogadorString(jogadorEscolhido, jogadorAtual);
        this.trataJogador.enviaJogadorDecimal(jogadorEscolhido, valor);
    }
    
    /** Método específico de ação para carta Correio do tipo Dinheiro Extra.
     * 
     * @param jogadorAtual
     * @param jogadorEscolhido
     * @param carta
     */
    public void acaoCartaDinheiroExtra(String jogadorAtual, String jogadorEscolhido, CartaCorreio carta) {
        double valor = carta.getValor();
        
        this.trataJogador.enviaJogadorString(jogadorEscolhido, "dinheiroExtra");
        this.trataJogador.enviaJogadorString(jogadorEscolhido, jogadorAtual);
        this.trataJogador.enviaJogadorDecimal(jogadorEscolhido, valor);
        
        this.jogador.getConta().aumentaSaldo(valor);
        this.jogador.removeCartaCorreio(carta);                
    }
    
    /** Método específico de ação para carta Correio do tipo Doações.
     * 
     * @param carta
     */
    public void acaoCartaDoacoes(CartaCorreio carta) {
        double valor = carta.getValor();
        
        if (this.jogador.getConta().getSaldo() >= valor) {
            this.jogador.getConta().diminuiSaldo(valor);
            this.jogador.removeCartaCorreio(carta);
        } else {
            this.saldoInsuficiente();
            return;
        }
        this.sorteGrande.aumentaSorteGrande(valor);
        
        this.trataJogador.enviaString("aumentaSorteGrande");
        this.trataJogador.enviaDecimal(valor);
    }
    
    /** Método específico de ação para carta Correio do tipo Cobrança Monstro.
     * 
     * @param carta
     */
    public void acaoCartaCobrancaMonstro(CartaCorreio carta) {
        double valor = carta.getValor() * 1.1;
        
        if (this.jogador.getConta().getSaldo() >= valor) {
            this.jogador.getConta().diminuiSaldo(valor);
            this.jogador.removeCartaCorreio(carta);
        } else {
            this.saldoInsuficiente();
        }
    }
    
    /** Método específico de ação para carta Correio do tipo Vá para Frente Agora.
     * 
     * @param carta
     */
    public void acaoCartaVaFrenteAgora(CartaCorreio carta) {
        this.jogador.removeCartaCorreio(carta);
    }
    
    /** Método de criação de cartas Compras, com sua descrição, valor de compra
     * e valor de revenda.
     */
    public void criaCartasCompras() {
        CartaCompras cartaCompras1  = new CartaCompras("SmartPhone", 1500.0, 2000.0);
        CartaCompras cartaCompras2  = new CartaCompras("SmartTV", 2000.0, 2500.0);
        CartaCompras cartaCompras3  = new CartaCompras("PS4", 1000.0, 1400.0);
        CartaCompras cartaCompras4  = new CartaCompras("Joystick", 200, 400);
        CartaCompras cartaCompras5  = new CartaCompras("Game", 200, 300);
        CartaCompras cartaCompras6  = new CartaCompras("Aeromodelo", 2000, 3000);
        CartaCompras cartaCompras7  = new CartaCompras("Bola de Basquete", 100, 400);
        CartaCompras cartaCompras8  = new CartaCompras("Miniatura da Millenium Falcon", 200, 500);
        CartaCompras cartaCompras9  = new CartaCompras("Darth Vader em Tamanho Real", 1500, 2500);
        CartaCompras cartaCompras10 = new CartaCompras("O Um Anel em Ouro", 800, 1000);
        CartaCompras cartaCompras11 = new CartaCompras("Máscara do Jason", 50, 550);
        CartaCompras cartaCompras12 = new CartaCompras("Katana", 2500, 3500);
        CartaCompras cartaCompras13 = new CartaCompras("Violão", 500, 1300);
        CartaCompras cartaCompras14 = new CartaCompras("Guitarra", 700, 1500);

        cartasCompras.add(cartaCompras1);
        cartasCompras.add(cartaCompras2);
        cartasCompras.add(cartaCompras3);
        cartasCompras.add(cartaCompras4);
        cartasCompras.add(cartaCompras5);
        cartasCompras.add(cartaCompras6);
        cartasCompras.add(cartaCompras7);
        cartasCompras.add(cartaCompras8);
        cartasCompras.add(cartaCompras9);
        cartasCompras.add(cartaCompras10);
        cartasCompras.add(cartaCompras11);
        cartasCompras.add(cartaCompras12);
        cartasCompras.add(cartaCompras13);
        cartasCompras.add(cartaCompras14);
    }
    
    /** Método que retorna uma carta Compras de sua lista aleatoriamente.
     * 
     * @return cartaCorreio
     */
    public CartaCompras escolheCartaCompras() {
        return (this.cartasCompras.get((int) (Math.random() * 14)));
    }
    
    /** Método de ação para carta Compras.
     * 
     * @param carta
     */
    public void acaoCartaCompras(CartaCompras carta) {
        double valor = carta.getValorCompra();
        
        if (this.jogador.getConta().getSaldo() >= valor) {
            this.jogador.getConta().diminuiSaldo(valor);
        } else {
            this.saldoInsuficiente();
        }
    }
    
}