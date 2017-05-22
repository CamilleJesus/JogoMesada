package br.uefs.ecomp.jm_c.controller;

import br.uefs.ecomp.jm_c.model.Conexao;
import br.uefs.ecomp.jm_c.view.Cadastro;
import br.uefs.ecomp.jm_c.view.Login;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * Classe que possui as funcoes dos botoes da interface de cadastro de cliente.
 * 
 * @author felipe
 *
 */
public class CadastroController implements Initializable {
	@FXML
	private TextField txNome;
	@FXML
	private PasswordField txConfirmarSenha;
	@FXML
	private PasswordField txSenha;
	@FXML
	private RadioButton rbFisica;
	@FXML
	private RadioButton rbJuridica;
	@FXML
	private Button btcadastrar;
	@FXML
	private Button btvoltar;
	/**
	 * Funcao que executa ao inicializar.
	 */
	@Override
	public void initialize(URL url, ResourceBundle bundle) {
		
	}
	/**
	 * Volta para a tela de login.
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void voltar(ActionEvent event) throws Exception{
		new Login().start(new Stage());
		Cadastro.getStage().close();
	}
	/**
	 * Cadastra cliente ao banco.
	 * Se informações fornecidas estão da forma correta, 
         * cliente é cadastrado xcom sucesso,
	 * se não o cliente é avisado do erro.
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void cadastrar(ActionEvent event) throws Exception{
		String nome = txNome.getText();
		String senha = txSenha.getText();
		String confirmarSenha = txConfirmarSenha.getText();
		
		if(verificarCampos(nome, senha, confirmarSenha)){
					
			Conexao cliente = Conexao.getInstancia();
			if (cliente.conectar()){
				cliente.enviar("cadastrar");
				cliente.enviar(nome);
				cliente.enviar(senha);
		
				String resposta = cliente.receber();
				cliente.disconectar();
						
				if (resposta.equals("1")){
					
					new Login().start(new Stage());
					Cadastro.getStage().close();
				}else{
                                    JOptionPane.showMessageDialog(null, "Nome já existe, tente outro"
						, "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
					
		}
		
	}
	
	/**
	 * Verifica se os campos da interface nao estao vazios e a
         * comfirmacao da senha iqual a senha.
	 * 
	 * @param nome
	 * @param senha
         * @param confirmarSenha
	 * @return boolean, true para campos corretos e false campos incorretos.
	 */
	private boolean verificarCampos(String nome, String senha, String confirmarSenha){
		if(!nome.equals("") && !senha.equals("") && !confirmarSenha.equals("")){
                    if (senha.equals(confirmarSenha)){
                        return true;// correto
                    }else{
                        JOptionPane.showMessageDialog(null, "A confirmação da senha está diferente da senha.", 
					"Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    
			
		}else{
			JOptionPane.showMessageDialog(null, "Um ou mais campos em branco.", 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		return false;//tem erro
	}
	
	
	
}
