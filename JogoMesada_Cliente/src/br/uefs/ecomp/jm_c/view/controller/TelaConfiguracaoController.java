package br.uefs.ecomp.jm_c.view.controller;

import br.uefs.ecomp.jm_c.connection.Conexao;
import br.uefs.ecomp.jm_c.connection.ConexaoCliente;
import br.uefs.ecomp.jm_c.view.TelaConfiguracao;
import br.uefs.ecomp.jm_c.view.TelaEspera;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * Classe que controla as funcoes da telaConfiguracao. Pega as informacoes sobre
 * cor do pino do jogador e por quanto tempo ele quer que o jogo aconteca.
 * @author felipe
 */
public class TelaConfiguracaoController implements Initializable {

     @FXML
    private Button iniciar;

    @FXML
    private RadioButton radioRoxo;

    @FXML
    private Label labelDuracao;

    @FXML
    private RadioButton radioAzul;

    @FXML
    private TitledPane titledConfiguracao;

    @FXML
    private RadioButton radioRosa;

    @FXML
    private RadioButton radioVermelho;

    @FXML
    private TextField fieldDuracao;

    @FXML
    private Label labelMes;

    @FXML
    private RadioButton radioVerde;

    @FXML
    private ToggleGroup cores;

    @FXML
    private RadioButton radioAmarelo;

    @FXML
    private AnchorPane pane;

    @FXML
    private Separator separador;

   /**
    * Inicializa a classe
    * @param url
    * @param rb 
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    /**
     * Pega a cor do pino do jogador e o tempo que ele quer que o jogo aconteca
     * e entra em uma sala.
     * @param action
     * @throws Exception 
     */
    @FXML
    public void clicaIniciar(ActionEvent action) throws Exception {
        ConexaoCliente conexao = ConexaoCliente.getInstancia();
        RadioButton rb = (RadioButton) cores.getSelectedToggle();
        String cor = rb.getText();
        String tempo = fieldDuracao.getText();
        
        
        
        int sala = entrarSala(conexao.getNickname(), cor, tempo);
        // se nao aconteceu nenhum erro
        if (sala != -1) {
           // entra na sala
            EntraSala tc = new EntraSala(sala);
            new Thread(tc).start();
            // fecha tela
            new TelaEspera().start(new Stage());
            TelaConfiguracao.getStage().close();
        
            
        }
        
        

    }
    /**
     * Adiciona o jogador em uma sala para esperar o jogo comecar.
     * @param nome
     * @param cor
     * @param tempo
     * @return
     * @throws UnknownHostException
     * @throws IOException 
     */
    private int entrarSala(String nome, String cor, String tempo) throws UnknownHostException, IOException {
        Conexao cliente = Conexao.getInstancia();
        if (cliente.conecta()) {
            // solicita entrar em uma sala
            cliente.envia("sala");
            cliente.envia(nome);
            cliente.envia(InetAddress.getByName("localhost").getHostAddress());
            cliente.envia("" + ConexaoCliente.getPorta());
            cliente.envia(cor);// cor do pino
            cliente.envia(tempo);//por quanto tempo ele quer que o jogo oconteca
            // recebe em qual sala esta
            int sala = Integer.parseInt(cliente.recebe());
            // servidor responde se tudo ocorreu corretamente
            String resposta = cliente.recebe();
            cliente.desconecta();
            // se tudo deu certo 
            if (resposta.equals("1")) {
                return sala;
            } else {// se algo deu errado

                JOptionPane.showMessageDialog(null, "Cor já escolhida!",
                        "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
        // se algo deu errado
        return -1;
    }

}
