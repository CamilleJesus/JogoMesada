package br.uefs.ecomp.jm_c.view;

import br.uefs.ecomp.jm_c.controller.Facade;
import br.uefs.ecomp.jm_c.model.CartaCompras;
import br.uefs.ecomp.jm_c.model.CartaCorreio;
import br.uefs.ecomp.jm_c.connection.ConexaoCliente;
import br.uefs.ecomp.jm_c.model.Peao;
import br.uefs.ecomp.jm_c.model.Usuario;

import java.io.IOException;

import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author Camille Jesus
 */
public class TelaJogoController implements Initializable {

    @FXML
    private Pane pane23;
    @FXML
    private Pane pane22;
    @FXML
    private Pane pane25;
    @FXML
    private Pane pane24;
    @FXML
    private TextField fieldDado;
    @FXML
    private Text textSex;
    @FXML
    private Pane pane26;
    @FXML
    private TitledPane titledCorreio;
    @FXML
    private TextArea areaCorreio;
    @FXML
    private ComboBox<String> comboJogadores;
    @FXML
    private Label labelDivida;
    @FXML
    private Pane paneUp;
    @FXML
    private Pane pane21;
    @FXML
    private Pane pane20;
    @FXML
    private ComboBox<String> comboCompras;
    @FXML
    private Text textSeg;
    @FXML
    private Text textSab;
    @FXML
    private Pane pane12;
    @FXML
    private TextField fieldMes;
    @FXML
    private Pane pane11;
    @FXML
    private Pane pane14;
    @FXML
    private Pane pane13;
    @FXML
    private Pane pane16;
    @FXML
    private TitledPane titledCompras;
    @FXML
    private Button buttonEmprestimo;
    @FXML
    private Pane pane15;
    @FXML
    private Text textQui;
    @FXML
    private Label labelSaldo;
    @FXML
    private Text textDom;
    @FXML
    private Circle circle;
    @FXML
    private Circle circle2;
    @FXML
    private ComboBox<String> comboCorreio;
    @FXML
    private Pane paneCompras;
    @FXML
    private Text textQua;
    @FXML
    private Pane pane10;
    @FXML
    private SplitPane splitPane;
    @FXML
    private TextField fieldDivida;
    @FXML
    private TextField fieldSaldo;
    @FXML
    private Pane pane01;
    @FXML
    private Pane pane45;
    @FXML
    private Pane pane00;
    @FXML
    private Pane pane44;
    @FXML
    private Pane pane03;
    @FXML
    private Pane pane02;
    @FXML
    private Pane pane46;
    @FXML
    private Pane pane05;
    @FXML
    private Pane pane04;
    @FXML
    private Pane pane06;
    @FXML
    private Text textTer;
    @FXML
    private Pane pane41;
    @FXML
    private Pane pane40;
    @FXML
    private Button buttonDado;
    @FXML
    private Pane pane43;
    @FXML
    private Pane pane42;
    @FXML
    private Pane paneCorreio;
    @FXML
    private Pane paneDias;
    @FXML
    private TextField fieldSorteGrande;
    @FXML
    private GridPane paneCenter;
    @FXML
    private Pane pane34;
    @FXML
    private Pane pane33;
    @FXML
    private Pane pane36;
    @FXML
    private Pane pane35;
    @FXML
    private TextArea areaCompras;
    @FXML
    private Pane pane30;
    @FXML
    private Pane pane32;
    @FXML
    private Pane pane31;
    @FXML
    private Label labelMes;
    @FXML
    private BorderPane borderJogo;    
    @FXML
    private Button buttonSorteGrande;    
    @FXML
    private Button buttonRealizarAcao;  
    @FXML
    private Button buttonVender;
    
    private Facade facade = new Facade();
    Peao peao = new Peao();
    Peao peao2 = new Peao();
    private int mes = 1;
    private ConexaoCliente conexaoCliente = ConexaoCliente.getInstancia();
    
    public void clicaEmprestimo(ActionEvent event) {
        this.facade.pegaEmprestimo(Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor:", "Empréstimo", JOptionPane.QUESTION_MESSAGE)));
        this.atualizaSaldo();
        this.atualizaDivida();
    }
    
    public void clicaDado(ActionEvent event) {
        Integer sorteio = this.facade.rolaDado();
        this.fieldDado.setText(sorteio.toString());        
        this.movePeao(this.peao, sorteio)  ;          
        this.acaoCasa(this.peao.getColuna(), this.peao.getLinha());
        //this.envia(sorteio);
    }
    
    public void envia(Integer sorteio) {
        String envia = sorteio.toString();
        
        try {
            this.conexaoCliente.enviar(envia);
            System.out.println("Enviou");
        } catch (IOException ex) {
            System.out.println("Não enviou");
        }
    }
    
    public void clicaComboCorreio(ActionEvent event) {
        
        if (comboCorreio.isFocusTraversable()) {
            ArrayList<CartaCorreio> cartas = this.facade.listaCartasCorreios();
        
            for (int i = 0; i < cartas.size(); i++) {
                CartaCorreio carta = cartas.get(i);
                String tipo = carta.getTipo();

                if (tipo.equals(comboCorreio.getValue())) {
                    
                    if (tipo.equals("Cobrança Monstro")) {
                        double valor = carta.getValor();
                        double juros = valor * 0.1;
                        this.areaCorreio.setText(carta.getDescricao() + "\n\nValor: R$ " + valor + "\nJuros  R$ " + juros);
                    } else if (tipo.equals("Vá para Frente Agora")) {
                        this.areaCorreio.setText(carta.getDescricao());
                    }else {
                        this.areaCorreio.setText(carta.getDescricao() + "\n\nR$ " + carta.getValor());
                    }
                    
                }
            }
        }        
    }
    
    public void clicaComboCompras(ActionEvent event) {
        
        if (comboCompras.isFocusTraversable()) {  
            ArrayList<CartaCompras> cartas = this.facade.listaCartasCompras();
        
            for (int i = 0; i < cartas.size(); i++) {
                CartaCompras carta = cartas.get(i);

                if (carta.getDescricao().equals(this.comboCompras.getValue())) {
                    this.areaCompras.setText("Compra: R$ " + carta.getValorCompra() + "\n\nRevenda: R$ " + carta.getValorRevenda());
                }
            }
        }        
    }
    
    public void clicaSorteGrande(ActionEvent event) {
        
        if (this.fieldDado.getText().equals("6")) {
            this.facade.ganhaSorteGrande();
            this.atualizaSaldo();
            this.atualizaSorteGrande();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Sorte Grande");
            alert.setHeaderText(null);
            alert.setContentText("Você granhou todo o dinheiro do Sorte Grande!");
            alert.show();
        } else {
            JOptionPane.showMessageDialog(null, "Você não tirou 6 no dado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void clicaRealizarAcao(ActionEvent event) {
        int coluna = this.peao.getColuna();
        int linha = this.peao.getLinha();
        String tipo = this.comboCorreio.getValue();
        
        if (tipo != null) {
            
            if (((coluna == 1) && (linha == 0)) ||
                    ((coluna == 3) && (linha == 0)) ||
                    ((coluna == 5) && (linha == 0)) ||
                    ((coluna == 4) && (linha == 1)) ||
                    ((coluna == 2) && (linha == 2)) ||
                    ((coluna == 5) && (linha == 2)) ||
                    ((coluna == 1) && (linha == 3)) ||
                    ((coluna == 3) && (linha == 3))) {

                if (tipo.equals("Pague a um Vizinho Agora")) {
                    this.pagueVizinhoAgora();
                } else if (tipo.equals("Dinheiro Extra")) {
                    this.dinheiroExtra();
                } else if (tipo.equals("Vá para Frente Agora")) {
                    this.vaFrenteAgora();
                }
                this.realizaAcao(tipo);
            } else if ((coluna == 3) && (linha == 4)) {

                if ((tipo.equals("Contas")) || (tipo.equals("Cobrança Monstro"))) {
                    this.realizaAcao(tipo);
                }
            }
        }        
    }
    
    public void realizaAcao(String tipo) {
        this.facade.acaoCartaCorreio(true, this.facade.buscaCartaCorreio(tipo));
        this.atualizaSaldo();
        this.atualizaDivida();
        this.atualizaSorteGrande();
        this.atualizaCartasCorreio();
    }
    
    public void pagueVizinhoAgora() {
        //Substituir por lista de nicknames dos jogadores:
        ChoiceDialog<String> dialogo = new ChoiceDialog<>(null, "Camille Jesus", "Felipe Damasceno");
        dialogo.setTitle("Carta Pague um Vizinho Agora");
        dialogo.setHeaderText(null);
        dialogo.setContentText("Escolha o jogador:");
        String jogador = dialogo.showAndWait().get();
        System.out.println(jogador);
    }
    
    public void dinheiroExtra() {
        //Substituir por lista de nicknames dos jogadores:
        ChoiceDialog<String> dialogo = new ChoiceDialog<>(null, "Camille Jesus", "Felipe Damasceno");
        dialogo.setTitle("Carta Dinheiro Extra");
        dialogo.setHeaderText(null);
        dialogo.setContentText("Escolha o jogador:");
        String jogador = dialogo.showAndWait().get();
    }
    
    public void vaFrenteAgora() {
        ChoiceDialog<String> dialogo = new ChoiceDialog<>(null, "Compras e Entretenimento", "Achou um Comprador");
        dialogo.setTitle("Carta Vá para Frente Agora");
        dialogo.setHeaderText(null);
        dialogo.setContentText("Escolha a casa:");       
        int coluna = this.peao.getColuna();
        int linha = this.peao.getLinha();
        
        switch (dialogo.showAndWait().get()) {
            case "Compras e Entretenimento":

                if (((coluna == 1) && (linha == 0)) ||
                        ((coluna == 1) && (linha == 3))){
                    this.movePeao(this.peao, 3);
                } else if (((coluna == 3) && (linha == 0)) ||
                        ((coluna == 4) && (linha == 1)) ||
                        ((coluna == 3) && (linha == 3))) {
                    this.movePeao(this.peao, 1);
                } else if ((coluna == 5) && (linha == 0)) {
                    this.movePeao(this.peao, 7);
                } else if ((coluna == 2) && (linha == 2)) {
                    this.movePeao(this.peao, 9);
                } else if ((coluna == 5) && (linha == 2)) {
                    this.movePeao(this.peao, 6);
                }              
                break;
            case "Achou um Comprador":

                if ((coluna == 1) && (linha == 0)){
                    this.movePeao(this.peao, 8);
                } else if (((coluna == 3) && (linha == 0)) ||
                        ((coluna == 4) && (linha == 1))) {
                    this.movePeao(this.peao, 6);
                } else if (((coluna == 5) && (linha == 0)) ||
                        ((coluna == 5) && (linha == 2))) {
                    this.movePeao(this.peao, 4);
                } else if (((coluna == 2) && (linha == 2)) ||
                        (((coluna == 1) && (linha == 3)))){
                    this.movePeao(this.peao, 1);
                } else if ((coluna == 3) && (linha == 3)) {
                    this.movePeao(this.peao, 2);
                }
                break;
        }
        this.acaoCasa(this.peao.getColuna(), this.peao.getLinha());
    }
    
    public void clicaVender(ActionEvent event) {
        int coluna = this.peao.getColuna();
        int linha = this.peao.getLinha();
        String descricao = this.comboCompras.getValue();
        
        if (descricao != null) {
            
            if (((coluna == 2) && (linha == 1)) ||
                    ((coluna == 3) && (linha == 2)) ||
                    ((coluna == 2) && (linha == 3)) ||
                    ((coluna == 5) && (linha == 3)) ||
                    ((coluna == 1) && (linha == 4))) {
                this.facade.vendeCartaCompras(this.facade.buscaCartaCompras(descricao));
                this.atualizaSaldo();
                this.atualizaDivida();
                this.atualizaCartasCompras();
            }
        }
    }
    
    public void movePeao(Peao peao, int quantidade) {
        peao.aumentaQuantidade(quantidade);
        this.atualizaMes();
        int casa = peao.getQuantidade();
        
        if (casa <= 6) {
            peao.setLinha(0);
            peao.setColuna(casa);
        } else if (casa <= 13) {
            peao.setLinha(1);
            peao.setColuna(casa - 7);
        } else if (casa <= 20) {
            peao.setLinha(2);
            peao.setColuna(casa - 14);
        } else if (casa <= 27) {
            peao.setLinha(3);
            peao.setColuna(casa - 21);
        } else if (casa < 31) {
            peao.setLinha(4);
            peao.setColuna(casa - 28);
        } else if (casa >= 31) {
            peao.setLinha(4);
            peao.setColuna(3);
            peao.setQuantidade(0);
            this.mes++;
        }
        this.paneCenter.getChildren().remove(peao.getCirculo());
        this.paneCenter.add(peao.getCirculo(), peao.getColuna(), peao.getLinha());
    }
    
    public void movePeao(int quantidade) {
        System.out.println("move peão 2");
        peao2.aumentaQuantidade(quantidade);
        this.atualizaMes();
        int casa = peao2.getQuantidade();
        
        if (casa <= 6) {
            peao2.setLinha(0);
            peao2.setColuna(casa);
        } else if (casa <= 13) {
            peao2.setLinha(1);
            peao2.setColuna(casa - 7);
        } else if (casa <= 20) {
            peao2.setLinha(2);
            peao2.setColuna(casa - 14);
        } else if (casa <= 27) {
            peao2.setLinha(3);
            peao2.setColuna(casa - 21);
        } else if (casa < 31) {
            peao2.setLinha(4);
            peao2.setColuna(casa - 28);
        } else if (casa >= 31) {
            peao2.setLinha(4);
            peao2.setColuna(3);
            peao2.setQuantidade(0);
        }
        this.paneCenter.getChildren().remove(circle2);
        this.paneCenter.add(circle2, peao2.getColuna(), peao2.getLinha());     
    }
    
    public void atualizaMes() {        
        this.fieldMes.setText(Integer.toString(mes));
    }
    
    public void acaoCasa(int coluna, int linha) {
        
        if ((coluna == 1) && (linha == 0)) {
            this.pegaCartasCorreio(1);
            this.atualizaCartasCorreio();
            this.informaCartaCorreio(1);
        } else if ((coluna == 2) && (linha == 0)) {
            this.facade.acaoCasaPremio();
            this.atualizaSaldo();
        } else if ((coluna == 3) && (linha == 0)) {
            this.pegaCartasCorreio(3);
            this.atualizaCartasCorreio();
            this.informaCartaCorreio(3);
        } else if ((coluna == 4) && (linha == 0)) {
            this.informaCartaCompras();
            this.atualizaCartasCompras();
        } else if ((coluna == 5) && (linha == 0)) {
            this.pegaCartasCorreio(2);
            this.atualizaCartasCorreio();
            this.informaCartaCorreio(2);
        } else if ((coluna == 6) && (linha == 0)) {
            int numeroEscolhido = this.informaBolaoEsportes();
            int numeroDado = this.rolaDado();
            this.informaNumeroDado(numeroDado);
            this.facade.acaoCasaBolaoEsportes(true, 6, numeroEscolhido, numeroDado);   //Substituir 6 pelo número de jogadores na partida
            this.atualizaSaldo();
        } else if ((coluna == 0) && (linha ==1)) {
            this.facade.acaoCasaPraiaDomingo(100);   //Valor arbitrário, não consta nas regras
            this.atualizaSaldo();
            this.atualizaDivida();
            this.atualizaSorteGrande();
        } else if ((coluna == 1) && (linha == 1)) {
            int numeroDado = this.rolaDado();   //Implementar rolar dado
            this.informaNumeroDado(numeroDado);
            this.facade.acaoCasaConcursoBandaRock(numeroDado);
            this.atualizaSaldo();
        } else if ((coluna == 2) && (linha == 1)) {
            this.informaCasaAchouComprador();
        } else if ((coluna == 3) && (linha == 1)) {
            this.facade.acaoCasaFelizAniversario(true, 6);   //Substituir 6 pelo número de jogadores na partida
            this.atualizaSaldo();
        } else if ((coluna == 4) && (linha == 1)) {
            this.pegaCartasCorreio(1);
            this.atualizaCartasCorreio();
            this.informaCartaCorreio(1);
        } else if ((coluna == 5) && (linha == 1)) {
            this.informaCartaCompras();
            this.atualizaCartasCompras();
        } else if ((coluna == 6) && (linha == 1)) {
            int numeroEscolhido = this.informaBolaoEsportes();
            int numeroDado = this.rolaDado();
            this.informaNumeroDado(numeroDado);
            this.facade.acaoCasaBolaoEsportes(true, 6, numeroEscolhido, numeroDado);   //Substituir 6 pelo número de jogadores na partida
            this.atualizaSaldo();
        } else if ((coluna == 0) && (linha == 2)) {
            this.facade.acaoCasaAjudeFlorestaAmazonica(200);   //Valor arbitrário, não consta nas regras
            this.atualizaSaldo();
            this.atualizaDivida();
            this.atualizaSorteGrande();
        } else if ((coluna == 1) && (linha == 2)) {
            this.informaCartaCompras();
            this.atualizaCartasCompras();
        } else if ((coluna == 2) && (linha == 2)) {
            this.pegaCartasCorreio(3);
            this.atualizaCartasCorreio();
            this.informaCartaCorreio(3);
        } else if ((coluna == 3) && (linha == 2)) {
            this.informaCasaAchouComprador();
        } else if ((coluna == 4) && (linha == 2)) {
            this.facade.acaoCasaLanchonete(300);   //Valor arbitrário, não consta nas regras
            this.atualizaSaldo();
            this.atualizaDivida();
            this.atualizaSorteGrande();
        } else if ((coluna == 5) && (linha == 2)) {
            this.pegaCartasCorreio(1);
            this.atualizaCartasCorreio();
            this.informaCartaCorreio(1);
        } else if ((coluna == 6) && (linha == 2)) {
            int numeroEscolhido = this.informaBolaoEsportes();
            int numeroDado = this.rolaDado();
            this.informaNumeroDado(numeroDado);
            this.facade.acaoCasaBolaoEsportes(true, 6, numeroEscolhido, numeroDado);   //Substituir 6 pelo número de jogadores na partida
            this.atualizaSaldo();
        } else if ((coluna == 0) && (linha == 3)) {
            int numeroDado = ((int) ((Math.random() * 6) + 1));   //Implementar rolar dado
            System.out.println(numeroDado);
            this.facade.acaoCasaNegocioOcasiao(numeroDado);
            this.facade.pegaCartaCompras(this.facade.escolheCartaCompras());            
            this.informaCartaCompras();
        } else if ((coluna == 1) && (linha == 3)) {
            this.pegaCartasCorreio(1);
            this.atualizaCartasCorreio();
            this.informaCartaCorreio(1);
        } else if ((coluna == 2) && (linha == 3)) {
            this.informaCasaAchouComprador();
        } else if ((coluna == 3) && (linha == 3)) {
            this.pegaCartasCorreio(2);
            this.atualizaCartasCorreio();
            this.informaCartaCorreio(2);
        } else if ((coluna == 4) && (linha == 3)) {
            this.informaCartaCompras();
            this.atualizaCartasCompras();
        } else if ((coluna == 5) && (linha == 3)) {
            this.informaCasaAchouComprador();
        } else if ((coluna == 6) && (linha == 3)) {
            int numeroEscolhido = this.informaBolaoEsportes();
            int numeroDado = this.rolaDado();
            this.informaNumeroDado(numeroDado);
            this.facade.acaoCasaBolaoEsportes(true, 6, numeroEscolhido, numeroDado);   //Substituir 6 pelo número de jogadores na partida
            this.atualizaSaldo();
        } else if ((coluna == 0) && (linha == 4)) {
            this.facade.acaoCasaComprasShopping(400);   //Valor arbitrário, não consta nas regras
            this.atualizaSaldo();
            this.atualizaDivida();
            this.atualizaSorteGrande();
        } else if ((coluna == 1) && (linha == 4)) {
            this.informaCasaAchouComprador();
        } else if ((coluna == 2) && (linha == 4)) {
            this.facade.acaoCasaMaratonaBeneficente(true, 0);   //Faz nada
        } else if ((coluna == 3) && (linha == 4)) {
            
        }        
    }
    
    public int rolaDado() {
        return ((int) ((Math.random() * 6) + 1));
    }
    
    public void pegaCartasCorreio(int quantidade) {
        
        for (int i = 0; i < quantidade; i++) {
            this.facade.pegaCartaCorreio();
        }
    }
    
    public void atualizaCartasCorreio() {                    
        this.comboCorreio.getItems().clear();
        this.areaCorreio.setText("");
        ArrayList<CartaCorreio> cartas = this.facade.listaCartasCorreios();            
        
        for (int i = 0; i < cartas.size(); i++) {
            this.comboCorreio.getItems().add(cartas.get(i).getTipo());                
        }
    }
    
    public void atualizaCartasCompras() {                    
        this.comboCompras.getItems().clear();
        this.areaCompras.setText("");
        ArrayList<CartaCompras> cartas = this.facade.listaCartasCompras();            

        for (int i = 0; i < cartas.size(); i++) {
            this.comboCompras.getItems().add(cartas.get(i).getDescricao());                
        }
    }
    
    public void informaCartaCorreio(int quantidade) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Casa Correio");
        alert.setHeaderText(null);
        alert.setContentText("Você recebeu " + quantidade + " carta(s) Correio!");
        alert.show();
    }
    
    public void informaCartaCompras() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Casa Compras e Entretenimento");
        CartaCompras cartaAux = this.facade.escolheCartaCompras();
        alert.setHeaderText(cartaAux.getDescricao() + "\nCompra: R$ " + cartaAux.getValorCompra() + "\nRevenda: R$ " + cartaAux.getValorRevenda());
        alert.setContentText("Deseja comprar o item descrito?");
        alert.getButtonTypes().setAll(new ButtonType("Comprar"), new ButtonType("Empréstimo"), new ButtonType("Cancel", ButtonData.CANCEL_CLOSE));
        ButtonType escolha = alert.showAndWait().get();
        
        if (escolha != alert.getButtonTypes().get(2)) {
            this.facade.pegaCartaCompras(cartaAux);
            
            if (escolha == alert.getButtonTypes().get(0)) {
                this.facade.acaoCartaCompras(cartaAux);                 
            } else if (escolha == alert.getButtonTypes().get(1)) {
                this.facade.pegaEmprestimo(cartaAux.getValorCompra());
                this.facade.acaoCartaCompras(cartaAux);
            }
            this.atualizaSaldo();
            this.atualizaDivida();
        }        
    }
    
    public int informaBolaoEsportes() {
        ChoiceDialog<String> dialogo = new ChoiceDialog<>(null, "1", "2", "3", "4", "5", "6");
        dialogo.setTitle("Casa Bolão de Esportes");
        dialogo.setHeaderText(null);
        dialogo.setContentText("Escolha um número:");
        return (Integer.parseInt(dialogo.showAndWait().get()));
    }
    
    public void informaNumeroDado(int numeroDado) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Rolagem de Dado");
        alert.setHeaderText(null);
        alert.setContentText("Número sorteado: " + numeroDado + ".");
        alert.show();
    }
    
    public void informaCasaAchouComprador() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Casa Achou um Comprador");
        alert.setHeaderText(null);
        alert.setContentText("Você achou 1 comprador!");
        alert.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.carregaImagens();
        
        this.atualizaSaldo();
        this.atualizaDivida();
        this.atualizaSorteGrande();
        //this.atualizaJogadores();        
        //Recebedor recebedor = new AtualizaJogo(this);
        //new Thread(recebedor).start();
    }
    
    public void carregaImagens() {
        pane00.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa00.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane01.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa01.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane02.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa02.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane03.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa03.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane04.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa04.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane05.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa05.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane06.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa06.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        
        pane10.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa10.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane11.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa11.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane12.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa12.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane13.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa13.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane14.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa14.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane15.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa15.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane16.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa16.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        
        pane20.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa20.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane21.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa21.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane22.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa22.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane23.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa23.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane24.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa24.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane25.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa25.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane26.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa26.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        
        pane30.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa30.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane31.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa31.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane32.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa32.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane33.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa33.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane34.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa34.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane35.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa35.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane36.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa36.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        
        pane40.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa40.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane41.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa41.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane42.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa42.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane43.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa43.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane44.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa44.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane45.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa45.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
        pane46.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("Casa46.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
    }
    
    public void atualizaJogadores() {
        comboJogadores.getItems().clear();            
        ArrayList<Usuario> usuarios = conexaoCliente.getSaidas();
        
        for (int i = 0; i < usuarios.size(); i++) {
            comboJogadores.getItems().add(usuarios.get(i).getPorta().toString());   //Integrar classe usuário com jogador e mudar porta para nome
        }
    }
    
    public void atualizaSaldo() {
        this.fieldSaldo.setText("R$ " + this.facade.retornaSaldo());
    }
    
    public void atualizaDivida() {
        this.fieldDivida.setText("R$ " + this.facade.retornaDivida());
    }
    
    public void atualizaSorteGrande() {
        this.fieldSorteGrande.setText("R$ " + this.facade.retornaSorteGrande());
    }
    
}