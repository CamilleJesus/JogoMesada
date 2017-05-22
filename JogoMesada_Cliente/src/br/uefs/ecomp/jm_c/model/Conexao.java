package br.uefs.ecomp.jm_c.model;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;


/**
 * Classe que inicializa a conexao com o servidor e se comunica com ele enviando e recebendo Strings.
 * 
 * @author felipe
 *
 */
public class Conexao {
	
	private Socket socket;
	private Scanner entrada;
	private PrintStream saida; 
	private static Conexao Conexao;
	private static String ip;// ip do servidor
	
   
	/**
	 * Inicializa a classe.
	 * 
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void singleton() throws UnknownHostException, IOException{
		Conexao = new Conexao();
	}
	/**
	 * Retorna a instancia da classe.
	 * @return Conexao
	 */
	public static Conexao getInstancia(){
		return Conexao; 
	}
        /**
         * Altera o valor do ip do servidor.
         * @param ip
         */
	public static void setIp(String ip){
		Conexao.ip = ip;
	}
	/**
	 * Conecta com o servidor.
	 * 
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	
    public boolean conectar() {
    	try{
	    	socket = new Socket(ip, 12346);
	        
	        entrada = new Scanner(socket.getInputStream());
	        saida = new PrintStream(socket.getOutputStream());
	        return true; // sucesso
    	}catch (Exception e){
    		JOptionPane.showMessageDialog(null, "Erro ao conectar o servidor", 
					"Erro", JOptionPane.ERROR_MESSAGE);
    		return false; // deu erro
    	}

    }
   
    /**
     * Envia uma String para o servidor.
     * @param s
     */
    public void enviar(String s){
    	saida.println(s);
    }
    
    
    /**
     * Recebe String do servidor e a retorna.
     * @return String
     */
    public String receber(){
    	return entrada.nextLine();
    }
    /**
     * Disconecta do servidor.
     * @throws IOException
     */
    public void disconectar() throws IOException{
    	saida.close();
    	entrada.close();
    	socket.close();

    }
    
    
}


