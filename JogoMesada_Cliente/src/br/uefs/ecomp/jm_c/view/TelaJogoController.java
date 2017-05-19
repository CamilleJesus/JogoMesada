package br.uefs.ecomp.jm_c.view;

import br.uefs.ecomp.jm_c.controller.ControllerPartida;
import java.net.URL;
import java.util.ArrayList;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
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
    private BorderPane telaJogo;

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
    private ListView<?> listCorreio;

    @FXML
    private Circle circleRoxo;

    @FXML
    private TitledPane paneCompras;

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
    private TitledPane paneCorreio;

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
    private Pane pane30;

    @FXML
    private Pane pane32;

    @FXML
    private Pane pane31;

    @FXML
    private Label labelMes;

    @FXML
    private ListView<?> listCompras;
    private ControllerPartida controllerPartida;
    private int quantidade;
    private int mes = 1;
    
    public void carregaJogadores() {
        
    }
    
    public void atualizaSaldo() {
        this.fieldSaldo.setText("R$ " + controllerPartida.getJogador().getConta().getSaldo());
    }
    
    public void atualizaDivida() {
        this.fieldDivida.setText("R$ " + controllerPartida.getJogador().getConta().getDivida());
    }
    
    public void clicarEmprestimo(ActionEvent event) {
        double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor:", "Empréstimo", JOptionPane.QUESTION_MESSAGE));
    }
    
    public int clicarDado(ActionEvent event) {
        int sorteio = ((int) (Math.random() * (7 - 1) + 1));
        fieldDado.setText(Integer.toString(sorteio));
        this.moverPeao(sorteio);
        return sorteio;
    }
    
    public void moverPeao(int casas) {
        quantidade += casas;
        int coluna = 0;
        int linha = 0;
        this.mudarMes();
        
        if (quantidade <= 6) {
            linha = 0;
            coluna = quantidade;
        } else if (quantidade <= 13) {
            linha = 1;
            coluna = (quantidade - 7);
        } else if (quantidade <= 20) {
            linha = 2;
            coluna = (quantidade - 14);
        } else if (quantidade <= 27) {
            linha = 3;
            coluna = (quantidade - 21);
        } else if (quantidade < 31) {
            linha = 4;
            coluna = (quantidade - 28);
        } else if (quantidade >= 31) {
            linha = 4;
            coluna = 3;
            quantidade = 0;
            mes++;
        }
        paneCenter.getChildren().remove(circleRoxo);
        paneCenter.add(circleRoxo, coluna, linha);     
    }
    
    public void mudarMes() {        
        fieldMes.setText(Integer.toString(mes));
    }
    
    public void casas(int coluna, int linha) {
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.carregaImagens();
        
        //this.atualizaSaldo();
        //this.atualizaDivida();
        
        circleRoxo.setVisible(true);
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
    
}