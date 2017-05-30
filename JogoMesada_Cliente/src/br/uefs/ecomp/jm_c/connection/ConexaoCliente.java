package br.uefs.ecomp.jm_c.connection;

import br.uefs.ecomp.jm_c.model.Usuario;
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
    private ArrayList<Usuario> saidas;
    private static String nome;
    private int ordem;
    private String cor;
    
    /**
     * Inicializa a classe.
     *
     * @throws UnknownHostException
     * @throws IOException
     */
    public static void singleton() throws UnknownHostException, IOException {
        Conexao = new ConexaoCliente();
    }
    
    
    public void setOrdem(int ordem){
        this.ordem = ordem;
    }

    public int getOrdem() {
        return ordem;
    }
    
   public String getNome(){
       return nome;
   }

    public String getCor() {
        return cor;
    }
    
    public void addJogador(InetAddress ip, int porta, int ordem, String nome, String cor){
        System.out.println("5");
        System.out.println(ip.getHostAddress());
        System.out.println(porta);
        saidas.add(new Usuario(ip, porta, ordem, nome, cor));
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

    public ArrayList<Usuario> getSaidas() {
        return saidas;
    }

    public void setSaidas(ArrayList<Usuario> saidas) {
        this.saidas = saidas;
    }

    /**
     * Conecta com o servidor.
     *
     * @throws UnknownHostException
     * @throws IOException
     */
    public boolean conectar() {
        saidas = new ArrayList<Usuario>();
        
        try {
            //cria porta para escutar algo
            servidor = new DatagramSocket(porta);

            System.out.println("Porta " + porta + " aberta!");
            

            return true; // sucesso
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar o servidor",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false; // deu erro
        }

    }
    
    public static void setNome(String nome){
        ConexaoCliente.nome = nome;
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
        for (Usuario jogador : saidas) {
            
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

    public void setCor(String cor) {
        this.cor = cor;
    }

}
