package br.uefs.ecomp.jm_c.view;

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
public class TelaLogin extends Application {
    
    /** Método que carrega a tela e inicializa a cena (frame).
     * 
     * @param stage
     * @throws java.lang.Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        //Chama o arquivo FXML correpondente:
        Parent root = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));      
        Scene scene = new Scene(root);
        stage.setTitle("Jogo da Mesada");   //Renomeia o frame
        stage.setScene(scene);
        stage.show();
    }

    /** Método que inicia o programa.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}