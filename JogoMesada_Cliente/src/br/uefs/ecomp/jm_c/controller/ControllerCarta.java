package br.uefs.ecomp.jm_c.controller;

import br.uefs.ecomp.jm_c.model.CartaCompras;
import br.uefs.ecomp.jm_c.model.CartaCorreio;
import br.uefs.ecomp.jm_c.model.Jogador;
import br.uefs.ecomp.jm_c.model.SorteGrande;

import java.util.ArrayList;


/**
 *
 * @author Camille Jesus
 */
public class ControllerCarta {
 
    private ArrayList<CartaCorreio> cartasCorreio;
    private ArrayList<CartaCompras> cartasCompras;
    private Jogador jogador;
    private SorteGrande sorteGrande;
    
    public ControllerCarta() {
        this.cartasCorreio = new ArrayList<>();
        this.cartasCompras = new ArrayList<>();
        this.jogador = Jogador.getInstance();
        this.sorteGrande = SorteGrande.getInstance();
    }
    
    private void criarCartasConta() {
        CartaCorreio cartaConta1 = new CartaCorreio("Contas", "Mensalidade do Spotify Premium", 50.0);
        CartaCorreio cartaConta2 = new CartaCorreio("Contas", "Conta do World of Warcraft", 100.0);

        cartasCorreio.add(cartaConta1);
        cartasCorreio.add(cartaConta2);
    }
    
    private void criarCartaPagueVizinhoAgora() {
        CartaCorreio cartaPagueVizinhoAgora1 = new CartaCorreio("Pague a um Vizinho Agora", "Pagamento de Fiança", 1000.0);
        CartaCorreio cartaPagueVizinhoAgora2 = new CartaCorreio("Pague a um Vizinho Agora", "Racha do Churrasco", 200.0);

        cartasCorreio.add(cartaPagueVizinhoAgora1);
        cartasCorreio.add(cartaPagueVizinhoAgora2);
    }
    
    private void criarCartaDinheiroExtra() {
        CartaCorreio cartaDinheiroExtra1 = new CartaCorreio("Dinheiro Extra", "Venda de Doces", 200.0);
        CartaCorreio cartaDinheiroExtra2 = new CartaCorreio("Dinheiro Extra", "Entrega de Jornal", 50.0);

        cartasCorreio.add(cartaDinheiroExtra1);
        cartasCorreio.add(cartaDinheiroExtra2);
    }
    
    private void criarCartaDoacoes() {
        CartaCorreio cartaDoacoes1 = new CartaCorreio("Doacoes", "Sopão para Mendigos", 300.0);
        CartaCorreio cartaDoacoes2 = new CartaCorreio("Doacoes", "Contribuição para Orfanato", 500.0);

        cartasCorreio.add(cartaDoacoes1);
        cartasCorreio.add(cartaDoacoes2);
    }
    
    private void criarCartaCobrancaMosntro() {
        CartaCorreio cartaDoacoes1 = new CartaCorreio("Cobranca Monstro", "Notebook Novo", 2000.0);
        CartaCorreio cartaDoacoes2 = new CartaCorreio("Cobranca Monstro", "Reforma da Casa", 3000.0);

        cartasCorreio.add(cartaDoacoes1);
        cartasCorreio.add(cartaDoacoes2);
    }
    
    private void criarCartaVaParaFrenteAgora() {
        CartaCorreio cartaVaParaFrente1 = new CartaCorreio("Va para Frente Agora", "Vá para a próxima casa 'Compras e Entretenimento' ou 'Achou um Comprador'.", 0.0);
        CartaCorreio cartaVaParaFrente2 = new CartaCorreio("Va para Frente Agora", "Vá para a próxima casa 'Compras e Entretenimento' ou 'Achou um Comprador'.", 0.0);

        cartasCorreio.add(cartaVaParaFrente1);
        cartasCorreio.add(cartaVaParaFrente2);
    }
    
    public void criarCartasCompra() {
        CartaCompras cartaCompra1  = new CartaCompras("SmartPhone", 1500.0, 2000.0);
        CartaCompras cartaCompra2  = new CartaCompras("SmartTV", 2000.0, 2500.0);
        CartaCompras cartaCompra3  = new CartaCompras("PS4", 1000.0, 1200.0);
        CartaCompras cartaCompra4  = new CartaCompras("Joystick", 200, 400);
        CartaCompras cartaCompra5  = new CartaCompras("Game", 200, 30);
        CartaCompras cartaCompra6  = new CartaCompras("Aeromodelo", 2000, 3000);
        CartaCompras cartaCompra7  = new CartaCompras("Bola de Basquete", 100, 250);
        CartaCompras cartaCompra8  = new CartaCompras("Miniatura da Millenium Falcon", 250, 400);
        CartaCompras cartaCompra9  = new CartaCompras("Darth Vader em Tamanho Real", 1500, 2500);
        CartaCompras cartaCompra10 = new CartaCompras("O Um Anel em Ouro", 800, 1000);
        CartaCompras cartaCompra11 = new CartaCompras("Máscara do Jason", 50, 150);
        CartaCompras cartaCompra12 = new CartaCompras("Katana", 2500, 3500);

        cartasCompras.add(cartaCompra1);
        cartasCompras.add(cartaCompra2);
        cartasCompras.add(cartaCompra3);
        cartasCompras.add(cartaCompra4);
        cartasCompras.add(cartaCompra5);
        cartasCompras.add(cartaCompra6);
        cartasCompras.add(cartaCompra7);
        cartasCompras.add(cartaCompra8);
        cartasCompras.add(cartaCompra9);
        cartasCompras.add(cartaCompra10);
        cartasCompras.add(cartaCompra11);
        cartasCompras.add(cartaCompra12);
    }
    
    public void cartaContas(CartaCorreio carta) {
        this.jogador.getConta().diminuiSaldo(carta.getValor());
    }
    
    
    
    public void cartaPagueVizinhoAgora(boolean tirouCarta, CartaCorreio carta) {
        double valor = carta.getValor();
        
        if (tirouCarta == true) {
            this.jogador.getConta().diminuiSaldo(valor);
            //jogadorEscolhido.getConta().aumentaSaldo(valor);
        } else if (tirouCarta == false) {
            //jogadorEscolhido.getConta().diminuiSaldo(valor);
            this.jogador.getConta().aumentaSaldo(valor);
        }                
    }
    
    
    
    public void cartaDinheiroExtra(boolean tirouCarta, CartaCorreio carta) {
        double valor = carta.getValor();
        
        if (tirouCarta == true) {
            //jogadorEscolhido.getConta().diminuiSaldo(valor);
            this.jogador.getConta().aumentaSaldo(valor);
        } else if (tirouCarta == false) {
            this.jogador.getConta().diminuiSaldo(valor);
            //jogadorEscolhido.getConta().aumentaSaldo(valor);
        }                
    }
    
    
    
    public void cartaDoacoes(boolean tirouCarta, CartaCorreio carta) {
        double valor = carta.getValor();
        
        if (tirouCarta == true) {
            this.jogador.getConta().diminuiSaldo(valor);
        }
        this.sorteGrande.aumentaSorteGrande(valor);
    }
    
    public void cartaCobrancaMonstro(CartaCorreio carta) {
        this.jogador.getConta().diminuiSaldo(carta.getValor() * 1.1);
    }
    
    public void cartaVaFrenteAgora() {
        
    }
    
    public void cartaCompraEntretenimento(CartaCompras carta) {
        this.jogador.getConta().diminuiSaldo(carta.getValorCompra());
    }
}