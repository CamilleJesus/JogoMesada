/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.jm_c.view.controller;

import br.uefs.ecomp.jm_c.connection.Conexao;
import br.uefs.ecomp.jm_c.connection.ConexaoCliente;
import br.uefs.ecomp.jm_c.view.TelaConfiguracao;
import br.uefs.ecomp.jm_c.view.TelaLogin;
import br.uefs.ecomp.jm_c.view.TelaEspera;
import br.uefs.ecomp.jm_c.view.TelaJogo;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class TelaConfiguracaoController implements Initializable {

    @FXML
    private TextField txTempo;
    @FXML
    private ToggleGroup cores;
    @FXML
    private Button btEnviar;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void entrarSala(ActionEvent action) throws Exception {
        ConexaoCliente conexao = ConexaoCliente.getInstancia();
        RadioButton rb = (RadioButton) cores.getSelectedToggle();
        String cor = rb.getText();
        String tempo = txTempo.getText();
        
        
        
        int sala = entrarSala(conexao.getNome(), cor, tempo);
        System.out.println("AAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + sala);
        if (sala != -1) {
            System.out.println("AAaaa");
            System.out.println(cor);
            EntraSala tc = new EntraSala(sala);
            new Thread(tc).start();
            
            new TelaEspera().start(new Stage());
            TelaConfiguracao.getStage().close();
        
            
        }
        
        

    }
    
    private int entrarSala(String nome, String cor, String tempo) throws UnknownHostException, IOException {
        Conexao cliente = Conexao.getInstancia();
        if (cliente.conectar()) {
            cliente.enviar("sala");
            cliente.enviar(nome);
            cliente.enviar(InetAddress.getByName("localhost").getHostAddress());
            cliente.enviar("" + ConexaoCliente.getPorta());
            cliente.enviar(cor);
            cliente.enviar(tempo);

            int sala = Integer.parseInt(cliente.receber());
            String resposta = cliente.receber();
            cliente.disconectar();

            if (resposta.equals("1")) {
                return sala;
            } else {

                JOptionPane.showMessageDialog(null, "Cor já escolhida",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return -1;
    }

}
