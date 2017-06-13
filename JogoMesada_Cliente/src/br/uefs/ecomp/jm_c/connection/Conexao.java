package br.uefs.ecomp.jm_c.connection;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;


/**
 * Classe Conexao, inicializa a conexão com o servidor e se comunica com ele enviando
 * e recebendo strings.
 * 
 * @author Camille Jesus e Felipe Damasceno
 */
public class Conexao {
    
    private static Conexao Conexao;

    private Socket socket;
    private Scanner entrada;
    private PrintStream saida;
    private static String ip;// ip do servidor	

    /** Método que inicializa a classe.
     * 
     * @throws UnknownHostException
     * @throws IOException
     */
    public static void singleton() throws UnknownHostException, IOException{
        Conexao = new Conexao();
    }

    /**Método que retorna a instância da classe.
     * 
     * @return Conexao
     */
    public static Conexao getInstancia(){
        return Conexao; 
    }

    /** Método que altera o valor do ip do servidor.
     * 
     * @param ip
     */
    public static void setIp(String ip){
            Conexao.ip = ip;
    }

    /** Método que conecta com o servidor.
     * 
     * @return true or false
     */	
    public boolean conecta() {
        
    	try{
            socket = new Socket(ip, 12346);

            entrada = new Scanner(socket.getInputStream());
            saida = new PrintStream(socket.getOutputStream());
            return true; // sucesso
    	} catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao conectar o servidor", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false; // deu erro
    	}
    }
   
    /** Método que envia uma string para o servidor.
     * 
     * @param s
     */
    public void envia(String s){
    	saida.println(s);
    }    
    
    /** Método que recebe uma string do servidor e a retorna.
     * 
     * @return String
     */
    public String recebe(){
    	return entrada.nextLine();
    }
    
    /** Método que desconecta do servidor.
     * 
     * @throws IOException
     */
    public void desconecta() throws IOException{
    	saida.close();
    	entrada.close();
    	socket.close();
    }    
    
}