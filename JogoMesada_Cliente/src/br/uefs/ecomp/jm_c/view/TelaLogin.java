package br.uefs.ecomp.jm_c.view;


import br.uefs.ecomp.jm_c.connection.Conexao;
import br.uefs.ecomp.jm_c.connection.ConexaoCliente;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Classe que inicializa a interface a tela do login. Inicializando com ele a
 * classe Conexao e o ip do servidor.
 *
 * @author felipe
 *
 */
public class TelaLogin extends Application {

    private static Stage stage;

    /**
     * Cria a tela e a mostra.
     */
    @Override
    public void start(Stage stage) throws Exception {
        TelaLogin.stage = stage;
        Parent parent = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Jogo da Mesada");
        stage.show();

    }

    /**
     * Retorna o Stage da interface.
     *
     * @return Stage
     */
    public static Stage getStage() {
        return stage;
    }

    public void escolherPorta() throws IOException {

    }

    /**
     * Função principal que inicializa a classe conexão, recebe ip do servidor e
     * inicializa a interface de login.
     *
     * @param args
     * @throws UnknownHostException
     * @throws IOException
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        Conexao.singleton();
        ConexaoCliente.singleton();
        String porta = JOptionPane.showInputDialog("Digite porta do servidor");
        if (!porta.equals("")) {
            ConexaoCliente.setPorta(Integer.parseInt(porta));
            ConexaoCliente.getInstancia().conecta();
            
        }

        String ip = JOptionPane.showInputDialog("Digite ip do servidor");
        if (!ip.equals("")) {
            Conexao.setIp(ip);

            launch(args);

        }

    }
}
