package br.uefs.ecomp.jm_c.model;

import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Classe que inicializa a conexao com o servidor e se comunica com ele enviando
 * e recebendo Strings.
 *
 * @author felipe
 *
 */
public class ConexaoCliente {

    DatagramSocket servidor;
    private static ConexaoCliente Conexao;
    private static int porta;
    private ArrayList<Player> saidas;

    /**
     * Inicializa a classe.
     *
     * @throws UnknownHostException
     * @throws IOException
     */
    public static void singleton() throws UnknownHostException, IOException {
        Conexao = new ConexaoCliente();
    }
    
   
    
    public void addJogador(InetAddress ip, int porta, int ordem){
        System.out.println("5");
        System.out.println(ip.getHostAddress());
        System.out.println(porta);
        saidas.add(new Player(ip, porta, ordem));
    }

    /**
     * Retorna a instancia da classe.
     *
     * @return Conexao
     */
    public static ConexaoCliente getInstancia() {
        return Conexao;
    }
    
    /**
     * Retorna a instancia da classe.
     *
     * @return Conexao
     */
    public static int getPorta() {
        return porta;
    }

    /**
     * Altera o valor do ip do servidor.
     *
     * @param ip
     */
    public static void setPorta(int porta) {
        Conexao.porta = porta;
    }

    /**
     * Conecta com o servidor.
     *
     * @throws UnknownHostException
     * @throws IOException
     */
    public boolean conectar() {
        saidas = new ArrayList<Player>();
        
        try {
            //cria porta para escutar algo
            servidor = new DatagramSocket(porta);

            System.out.println("Porta " + porta + " aberta!");
            

            return true; // sucesso
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar o servidor",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false; // deu erro
        }

    }

    /**
     * Envia uma String para o servidor.
     *
     * @param s
     */
    public void enviar(String s) throws SocketException, IOException {
        DatagramSocket ds = new DatagramSocket();
        //envia mensagem para as portas dos outros usuarios
        byte[] msg = s.getBytes();
        for (Player jogador : saidas) {
            
            DatagramPacket pkg = new DatagramPacket(msg, msg.length, jogador.getIp(), jogador.getPorta());
            //envia pacote
            ds.send(pkg);

        }
        ds.close ();
    }

    


/**
 * Recebe String do servidor e a retorna.
 *
 * @return String
 */
public String receber() throws IOException {
        byte[] msg = new byte[256];
        //cria o pacote para receber a mensagem
        DatagramPacket pkg = new DatagramPacket(msg, msg.length);
        //recebe mensagem, transforma em string e printa
        
        servidor.receive(pkg);
        String resposta = new String(pkg.getData()).trim();
        
        
        return resposta;
        
    }

    /**
     * Disconecta do servidor.
     *
     * @throws IOException
     */
    public void disconectar() throws IOException {
        servidor.close();

    }

}
