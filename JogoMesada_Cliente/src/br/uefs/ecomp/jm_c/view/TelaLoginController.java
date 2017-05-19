package br.uefs.ecomp.jm_c.view;

//import br.uefs.ecomp.bc_c.connection.Comunicacao;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;

import javax.swing.JOptionPane;


/**
 * Classe (controladora) TelaLoginController, responsável por seu respectivo arquivo
 * FXML. Apresenta os atributos e métodos da sua classe principal correspondente.
 *
 * @author Camille Jesus
 */
public class TelaLoginController implements Initializable {

    @FXML
    private TitledPane telaLogin;
    @FXML
    private Pane pane;    
    @FXML
    private Label labelNickname;    
    @FXML
    private TextField fieldNickname;    
    @FXML
    private Label labelSenha;    
    @FXML
    private PasswordField fieldSenha;    
    @FXML
    private Hyperlink cadastrese;    
    @FXML
    private Button entrar;
    //private Comunicacao comunicacao = new Comunicacao();
    
    /** Método que fecha a tela atual e retorna à tela de login.
     * 
     * @param event
     * @throws java.lang.Exception
     */
    @FXML
    public void clicarCadastrar(ActionEvent event) throws Exception {
        TelaCadastro telaCadastro = new TelaCadastro();
        telaCadastro.start(new Stage());
        ((Stage) cadastrese.getScene().getWindow()).close();   //Fecha a tela atual
    }
    
    /** Método que dispara o evento do botão, gerando a tela de acesso da conta,
     * se todos os campos de dados estiverem preenchidos.
     * 
     * @param event
     * @throws java.lang.Exception
     */
    @FXML
    public void clicarEntrar(ActionEvent event) throws Exception {
        String nickname = fieldNickname.getText();
        String senha = fieldSenha.getText();
        if ((!nickname.equals("")) && (!senha.equals(""))) {
            //String logou = comunicacao.fazerLogin(nickname, senha);
            
            //if (logou.equals("1")) {
                TelaJogo telaJogo = new TelaJogo();
                telaJogo.start(new Stage());
                ((Stage) entrar.getScene().getWindow()).close();   //Fecha a tela atual
            //} else {
            //    JOptionPane.showMessageDialog(null, "Informações inválidas!", "Erro!", JOptionPane.ERROR_MESSAGE);
            //}
        } else {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!", "Alerta!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /** Método que prepara a janela.
     * 
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
}