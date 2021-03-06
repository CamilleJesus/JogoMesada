package br.uefs.ecomp.jm_c.view;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Classe que inicializa a interface a tela da sala de espera.
 * 
 * @author felipe
 *
 */
public class TelaConfiguracao extends Application{

	private static Stage stage;

    
	/**
	 * 
	 * Cria tela e a mostra.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		TelaConfiguracao.stage = stage;
		Parent parent = FXMLLoader.
				load(getClass().getResource("TelaConfiguracao.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Jogo da Mesada");
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

