package br.uefs.ecomp.jm_c.view;

import br.uefs.ecomp.jm_c.controller.Facade;
import br.uefs.ecomp.jm_c.model.CartaCompras;
import br.uefs.ecomp.jm_c.model.CartaCorreio;
import br.uefs.ecomp.jm_c.model.Peao;

import java.net.URL;
import java.util.ArrayList;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
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
    private ComboBox<?> comboPlayers;

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
    
    private Facade facade = new Facade();
    Peao peao = new Peao();
    private int mes = 1;
    
    public void clicaEmprestimo(ActionEvent event) {
        double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor:", "Empréstimo", JOptionPane.QUESTION_MESSAGE));
        this.facade.pegaEmprestimo(valor);
        this.atualizaSaldo();
        this.atualizaDivida();
    }
    
    public int clicaDado(ActionEvent event) {
        int sorteio = this.facade.rolaDado();
        this.fieldDado.setText(Integer.toString(sorteio));
        this.movePeao(this.peao, this.circle, sorteio);
        this.acaoCasa(this.peao.getColuna(), this.peao.getLinha());
        return sorteio;
    }
    
    public void clicaComboCorreio(ActionEvent event) {
        
        if (comboCorreio.isFocusTraversable()) {
            ArrayList<CartaCorreio> cartas = this.facade.listaCartasCorreios();
        
            for (int i = 0; i < cartas.size(); i++) {
                CartaCorreio carta = cartas.get(i);

                if (carta.getTipoCarta().equals(comboCorreio.getValue())) {
                    areaCorreio.setText(carta.getDescricao() + "\n\nR$ " + carta.getValor());
                }
            }
        }        
    }
    
    public void clicaComboCompras(ActionEvent event) {
        
        if (comboCompras.isFocusTraversable()) {  
            ArrayList<CartaCompras> cartas = this.facade.listaCartasCompras();
        
            for (int i = 0; i < cartas.size(); i++) {
                CartaCompras carta = cartas.get(i);

                if (carta.getDescricao().equals(comboCompras.getValue())) {
                    areaCompras.setText("Compra: R$" + carta.getValorCompra() + "\n\nRevenda: R$" + carta.getValorRevenda());
                }
            }
        }        
    }
    
    public void clicaSorteGrande(ActionEvent event) {
        
        if (fieldDado.getText().equals("6")) {
            System.out.println("oi");
            this.facade.ganhaSorteGrande();
            this.atualizaSaldo();
            this.atualizaSorteGrande();
        }
    }
    
    public void movePeao(Peao peao, Circle circle, int quantidade) {
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
        this.paneCenter.getChildren().remove(circle);
        this.paneCenter.add(circle, peao.getColuna(), peao.getLinha());     
    }
    
    public void atualizaMes() {        
        this.fieldMes.setText(Integer.toString(mes));
    }
    
    public void acaoCasa(int coluna, int linha) {
        
        if ((coluna == 1) && (linha == 0)) {
            this.pegaCartasCorreio(1);
            this.atualizaCartasCorreio();
            this.atualizaSaldo();
            this.atualizaDivida();
        } else if ((coluna == 2) && (linha == 0)) {
            this.facade.acaoCasaPremio();
            this.atualizaSaldo();
        } else if ((coluna == 3) && (linha == 0)) {
            this.pegaCartasCorreio(3);
            this.atualizaCartasCorreio();
            this.atualizaSaldo();
            this.atualizaDivida();
        } else if ((coluna == 4) && (linha == 0)) {
            this.facade.pegaCartaCompras();
            this.atualizaCartasCompras();
            this.atualizaSaldo();
            this.atualizaDivida();
        } else if ((coluna == 5) && (linha == 0)) {
            this.pegaCartasCorreio(2);
            this.atualizaCartasCorreio();
            this.atualizaSaldo();
            this.atualizaDivida();
        } else if ((coluna == 6) && (linha == 0)) {
            int numeroEscolhido = 1;   //Substituir 1 pelo número escolhido pelo jogador
            int numeroDado = ((int) ((Math.random() * 6) + 1));   //Implementar rolar dado
            System.out.println(numeroDado);
            this.facade.acaoCasaBolaoEsportes(true, 6, numeroEscolhido, numeroDado);   //Substituir 6 pelo número de jogadores na partida
            this.atualizaSaldo();
        } else if ((coluna == 0) && (linha ==1)) {
            this.facade.acaoCasaPraiaDomingo(100);   //Valor arbitrário, não consta nas regras
            this.atualizaSaldo();
            this.atualizaDivida();
            this.atualizaSorteGrande();
        } else if ((coluna == 1) && (linha == 1)) {
            int numeroDado = ((int) ((Math.random() * 6) + 1));   //Implementar rolar dado
            System.out.println(numeroDado);
            this.facade.acaoCasaConcursoBandaRock(numeroDado);
            this.atualizaSaldo();
        } else if ((coluna == 2) && (linha == 1)) {
            
        } else if ((coluna == 3) && (linha == 1)) {
            this.facade.acaoCasaFelizAniversario(true, 6);   //Substituir 6 pelo número de jogadores na partida
        } else if ((coluna == 4) && (linha == 1)) {
            this.pegaCartasCorreio(1);
            this.atualizaCartasCorreio();
            this.atualizaSaldo();
            this.atualizaDivida();
        } else if ((coluna == 5) && (linha == 1)) {
            this.facade.pegaCartaCompras();
            this.atualizaCartasCompras();
            this.atualizaSaldo();
            this.atualizaDivida();
        } else if ((coluna == 6) && (linha == 1)) {
            int numeroEscolhido = 1;   //Substituir 1 pelo número escolhido pelo jogador
            int numeroDado = ((int) ((Math.random() * 6) + 1));   //Implementar rolar dado
            System.out.println(numeroDado);
            this.facade.acaoCasaBolaoEsportes(true, 6, numeroEscolhido, numeroDado);   //Substituir 6 pelo número de jogadores na partida
            this.atualizaSaldo();
        } else if ((coluna == 0) && (linha == 2)) {
            this.facade.acaoCasaAjudeFlorestaAmazonica(200);   //Valor arbitrário, não consta nas regras
            this.atualizaSaldo();
            this.atualizaDivida();
            this.atualizaSorteGrande();
        } else if ((coluna == 1) && (linha == 2)) {
            this.facade.pegaCartaCompras();
            this.atualizaCartasCompras();
            this.atualizaSaldo();
            this.atualizaDivida();
        } else if ((coluna == 2) && (linha == 2)) {
            this.pegaCartasCorreio(3);
            this.atualizaCartasCorreio();
        } else if ((coluna == 3) && (linha == 2)) {
            
        } else if ((coluna == 4) && (linha == 2)) {
            this.facade.acaoCasaLanchonete(300);   //Valor arbitrário, não consta nas regras
            this.atualizaSaldo();
            this.atualizaDivida();
            this.atualizaSorteGrande();
        } else if ((coluna == 5) && (linha == 2)) {
            this.pegaCartasCorreio(1);
            this.atualizaCartasCorreio();
            this.atualizaSaldo();
            this.atualizaDivida();
        } else if ((coluna == 6) && (linha == 2)) {
            int numeroEscolhido = 1;   //Substituir 1 pelo número escolhido pelo jogador
            int numeroDado = ((int) ((Math.random() * 6) + 1));   //Implementar rolar dado
            System.out.println(numeroDado);
            this.facade.acaoCasaBolaoEsportes(true, 6, numeroEscolhido, numeroDado);   //Substituir 6 pelo número de jogadores na partida
            this.atualizaSaldo();
        } else if ((coluna == 0) && (linha == 3)) {
            int numeroDado = ((int) ((Math.random() * 6) + 1));   //Implementar rolar dado
            System.out.println(numeroDado);
            this.facade.acaoCasaNegocioOcasiao(numeroDado);
            this.facade.pegaCartaCompras();
        } else if ((coluna == 1) && (linha == 3)) {
            this.pegaCartasCorreio(1);
            this.atualizaCartasCorreio();
            this.atualizaSaldo();
            this.atualizaDivida();
        } else if ((coluna == 2) && (linha == 3)) {
            
        } else if ((coluna == 3) && (linha == 3)) {
            this.pegaCartasCorreio(2);
            this.atualizaCartasCorreio();
            this.atualizaSaldo();
            this.atualizaDivida();
        } else if ((coluna == 4) && (linha == 3)) {
            this.facade.pegaCartaCompras();
            this.atualizaCartasCompras();
            this.atualizaSaldo();
            this.atualizaDivida();
        } else if ((coluna == 5) && (linha == 3)) {
            
        } else if ((coluna == 6) && (linha == 3)) {
            int numeroEscolhido = 1;   //Substituir 1 pelo número escolhido pelo jogador
            int numeroDado = ((int) ((Math.random() * 6) + 1));   //Implementar rolar dado
            System.out.println(numeroDado);
            this.facade.acaoCasaBolaoEsportes(true, 6, numeroEscolhido, numeroDado);   //Substituir 6 pelo número de jogadores na partida
            this.atualizaSaldo();
        } else if ((coluna == 0) && (linha == 4)) {
            this.facade.acaoCasaComprasShopping(400);   //Valor arbitrário, não consta nas regras
            this.atualizaSaldo();
            this.atualizaDivida();
            this.atualizaSorteGrande();
        } else if ((coluna == 1) && (linha == 4)) {
            
        } else if ((coluna == 2) && (linha == 4)) {
            this.facade.acaoCasaMaratonaBeneficente(true, 0);   //Faz nada
        } else if ((coluna == 3) && (linha == 4)) {
            
        }        
    }
    
    public void pegaCartasCorreio(int quantidade) {
        
        for (int i = 0; i < quantidade; i++) {
            this.facade.pegaCartaCorreio();
        }
    }
    
    public void atualizaCartasCorreio() {                    
            comboCorreio.getItems().clear();            
            ArrayList<CartaCorreio> cartas = this.facade.listaCartasCorreios();            
            
            for (int i = 0; i < cartas.size(); i++) {
                comboCorreio.getItems().add(cartas.get(i).getTipoCarta());                
            }
    }
    
    public void atualizaCartasCompras() {                    
            comboCompras.getItems().clear();            
            ArrayList<CartaCompras> cartas = this.facade.listaCartasCompras();            
            
            for (int i = 0; i < cartas.size(); i++) {
                comboCompras.getItems().add(cartas.get(i).getDescricao());                
            }
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
        
        circle.setVisible(true);
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