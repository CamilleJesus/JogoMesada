package br.uefs.ecomp.jm_c.view.controller;

import br.uefs.ecomp.jm_c.connection.ConexaoCliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class TelaEsperaController implements Initializable {

    @FXML
    private TitledPane titledEspera;

    @FXML
    private ProgressIndicator progresso;

    @FXML
    private Text textBemVindo;

    @FXML
    private Label nome;

    @FXML
    private AnchorPane pane;

    @FXML
    private Text textFrase;
    
    private ConexaoCliente conexaoCliente = ConexaoCliente.getInstancia();
    
    public void atualizaNome() {
        this.nome.setText(this.conexaoCliente.getNome() + "!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        this.atualizaNome();
    }

}