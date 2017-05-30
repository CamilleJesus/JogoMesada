package br.uefs.ecomp.jm_c.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


/**
 * Classe que inicializa a interface a tela de cadastro do cliente.
 * 
 * @author felipe
 *
 */
public class TelaCadastro extends Application{

	private static Stage stage;
	/**
	 * 
	 * Cria tela e a mostra.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		TelaCadastro.stage = stage;
		Parent parent = FXMLLoader.
				load(getClass().getResource("TelaCadastro.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Tela de Cadastro");
		stage.show();
		
		
	}
	/**
	 * Retorna o Stage da interface.
	 * @return Stage
	 */
	public static Stage getStage() {
		return stage;
	}
	/**
	 * Inicializa a tela de cadastro.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
