package br.uefs.ecomp.jm_c.connection;

import br.uefs.ecomp.jm_c.model.Adversario;
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
    private static int porta;// porta do servidor udp
    private ArrayList<Adversario> saidas;
    private static String nome;
    private int ordem; //ordem do jogador no jogo
    private String cor; // cor do pino
    private int tempoPartida;
    
    /**
     * Inicializa a classe.
     *
     * @throws UnknownHostException
     * @throws IOException
     */
    public static void singleton() throws UnknownHostException, IOException {
        Conexao = new ConexaoCliente();
    }
  
    
    /**
     * muda ordem do jogador na partida
     * @param ordem 
     */
    public void setOrdem(int ordem){
        this.ordem = ordem;
    }
    /**
     * retorna ordem do jogador na partida
     * @return 
     */
    public int getOrdem() {
        return ordem;
    }
    /**
     * retorna nome do jogador.
     * @return nome
     */
   public String getNome(){
       return nome;
   }
   /**
    * retorna com do pino.
    * @return cor
    */
    public String getCor() {
        return cor;
    }
    /**
     * Adiciona as informacoes dos adversarios da partida para jogador poder
     * se comunicar com eles.
     * @param ip
     * @param porta
     * @param ordem
     * @param nome
     * @param cor 
     */
    public void addAdversario(InetAddress ip, int porta, int ordem, String nome, String cor){
        saidas.add(new Adversario(ip, porta, ordem, nome, cor));
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
    
    public int getTempoPartida () {
        return this.tempoPartida;
    }
    
    /**
     * muda tempo da partida
     * @param tempoPartida 
     */
    public void setTempoPartida(int tempoPartida){
        this.tempoPartida = tempoPartida;
       
    }
    
    /**
     * retorna os adversarios da partida
     * @return saidas
     */
    public ArrayList<Adversario> getSaidas() {
        return saidas;
    }
    /**
     * muda os adversarios da partida
     * @param saidas 
     */
    public void setSaidas(ArrayList<Adversario> saidas) {
        this.saidas = saidas;
    }
    
    public int getNumeroJogadores() {
        return (saidas.size());
    }

    /**
     * Conecta com o servidor.
     *
     * @throws UnknownHostException
     * @throws IOException
     */
    public boolean conectar() {
        saidas = new ArrayList<Adversario>();
        
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
    /**
     * muda nome do jogador
     * @param nome 
     */
    public static void setNome(String nome){
        ConexaoCliente.nome = nome;
    }
    
    public ArrayList getNomeJogadores() {
        ArrayList nomes =  new ArrayList();
                
        for (int i = 0; i < saidas.size(); i++) {
            nomes.add(saidas.get(i).getNome());
        }
        return nomes;
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
        for (Adversario jogador : saidas) {
            
            DatagramPacket pkg = new DatagramPacket(msg, msg.length, jogador.getIp(), jogador.getPorta());
            //envia pacote
            ds.send(pkg);

        }
        ds.close ();
    }
    
    public void enviarJogador(String nome, String s) throws SocketException, IOException {
        DatagramSocket ds = new DatagramSocket();
        //envia mensagem para as portas dos outros usuarios
        byte[] msg = s.getBytes();
        
        for (Adversario jogador : saidas) {
            
            if (nome.equals(jogador.getNome())) {
                DatagramPacket pkg = new DatagramPacket(msg, msg.length, jogador.getIp(), jogador.getPorta());
                //envia pacote
                ds.send(pkg);
            }
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
        //recebe mensagem, transforma em string e retorna
        
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
    /**
     * muda valor do cor do pino
     * @param cor 
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

}
