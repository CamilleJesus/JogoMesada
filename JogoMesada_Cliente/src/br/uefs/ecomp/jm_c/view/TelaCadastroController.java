package br.uefs.ecomp.jm_c.view;

//import br.uefs.ecomp.bc_c.connection.Comunicacao;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

import javax.swing.JOptionPane;


/**
 * Classe (controladora) TelaCadastroController, responsável por seu respectivo arquivo
 * FXML. Apresenta os atributos e métodos da sua classe principal correspondente.
 */
public class TelaCadastroController implements Initializable {

    @FXML
    private TitledPane telaCadastro;
    @FXML
    private AnchorPane pane;
    @FXML
    private Label labelNickname;
    @FXML
    private TextField fieldNickname;
    @FXML
    private Label labelSenha;
    @FXML
    private PasswordField fieldSenha;
    @FXML
    private Hyperlink voltar;
    @FXML
    private Button cadastrar;
    //private Comunicacao comunicacao = new Comunicacao();
    
    /** Método que dispara o evento do botão, gerando a tela login, se todos os 
     * campos de dados estiverem preenchidos.
     * @param event
     * @throws java.lang.Exception
     */
    @FXML
    public void clicarCadastrar(ActionEvent event) throws Exception {
        String nickname = fieldNickname.getText();
        String senha = fieldSenha.getText();
        
        //Verifica os campos:
        if ((!nickname.equals("")) && (!senha.equals(""))) {
            //comunicacao.cadastrarCliente(nickname, senha);
            //comunicacao.criarConta();
            //Vincular jogador a conta de alguma forma
            this.telaLogin();   //Chama a tela de login
        } else {
            JOptionPane.showMessageDialog(null, "Campo(s) vazio(s)!", "Alerta!", JOptionPane.WARNING_MESSAGE);
        }
    }

    /** Método que dispara o evento do botão, voltando à tela de login.
     * @param event
     * @throws java.lang.Exception
     */
    @FXML
    public void clicarVoltar(ActionEvent event) throws Exception {
        this.telaLogin();
    }
    
    /** Método que fecha a tela atual e retorna à tela de login.
     * @throws java.lang.Exception
     */
    public void telaLogin() throws Exception {
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.start(new Stage());
        ((Stage) cadastrar.getScene().getWindow()).close();   //Fecha a tela atual
    }

    /** Método que prepara a janela, ocultando o campo CPF/CNPJ enquanto o usuário
     * não clica no botão de escolha do tipo de cliente.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

}