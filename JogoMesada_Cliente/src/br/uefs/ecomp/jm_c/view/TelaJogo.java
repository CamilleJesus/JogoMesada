package br.uefs.ecomp.jm_c.view;

import br.uefs.ecomp.jm_c.connection.ConexaoCliente;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 * Classe (Java Principal) TelaLogin, responsável pela tela de login do sistema
 * Banco Cooperativo.
 * 
 * @author Camille Jesus
 */
public class TelaJogo extends Application {
    private ConexaoCliente conexaoCliente = ConexaoCliente.getInstancia();
    private static Stage stage;
    /** Método que carrega a tela e inicializa a cena (frame).
     * 
     * @param stage
     * @throws java.lang.Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        TelaJogo.stage = stage;
        //Chama o arquivo FXML correpondente:
        Parent root = FXMLLoader.load(getClass().getResource("TelaJogo.fxml"));      
        Scene scene = new Scene(root);
        stage.setTitle("Jogo da Mesada   <" + this.conexaoCliente.getNickname()+ ">");   //Renomeia o frame
        stage.setScene(scene);
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

    /** Método que inicia o programa.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}