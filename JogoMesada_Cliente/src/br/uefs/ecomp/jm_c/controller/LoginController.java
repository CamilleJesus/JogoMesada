package br.uefs.ecomp.jm_c.controller;

import br.uefs.ecomp.jm_c.model.Conexao;
import br.uefs.ecomp.jm_c.model.ConexaoCliente;
import br.uefs.ecomp.jm_c.model.EntrarSala;
import br.uefs.ecomp.jm_c.view.Cadastro;
import br.uefs.ecomp.jm_c.view.Login;
import br.uefs.ecomp.jm_c.view.Sala;
import br.uefs.ecomp.jm_c.view.TelaJogo;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Classe que possui as funcoes dos botoes da interface de login.
 *
 * @author felipe
 *
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txNome;
    @FXML
    private PasswordField txSenha;
    @FXML
    private Button btCadastrar;
    @FXML
    private Button btEntrar;

    /**
     * Funcao que executa ao inicializar.
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {

    }

    /**
     * Ao clicar no botao de login verifica informacoes (identificador e senha)
     * e se ela estiver no servidor abri a tela principal, caso contrario o
     * usuario recebe uma mensagem para informar do erro.
     *
     * @param event
     *
     */
    @FXML
    private void logar(ActionEvent event) {
        try {
            String nome = txNome.getText();
            String senha = txSenha.getText();

            if (verificarCampos(nome, senha)) {

                Conexao cliente = Conexao.getInstancia();
                if (cliente.conectar()) {
                    cliente.enviar("entrar");
                    cliente.enviar(nome);
                    cliente.enviar(senha);

                    String resposta = cliente.receber();
                    cliente.disconectar();

                    if (resposta.equals("1")) {

                        new Sala().start(new Stage());
                        Login.getStage().close();

                        

                        EntrarSala tc = new EntrarSala(nome);
                        new Thread(tc).start();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário ou senha errada",
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Verifica se os campos da interface estao em branco.
     *
     * @param nome
     * @param senha
     * @return true se campos nao estao em branco e false se esta em branco
     */
    private boolean verificarCampos(String identificador, String senha) {
        if (!identificador.equals("") && !senha.equals("")) {

            return true;//tudo correto
        } else {
            JOptionPane.showMessageDialog(null, "Um ou mais campos em branco",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;//tem erro
    }

    
    /**
     * Chama a tela de cadastro e fecha a tela atual.
     *
     * @param event
     *
     */
    @FXML
    private void cadastrar(ActionEvent event) {
        try {
            new Cadastro().start(new Stage());
            Login.getStage().close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao mudar de tela",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

}
