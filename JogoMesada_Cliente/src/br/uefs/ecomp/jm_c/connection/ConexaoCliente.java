package br.uefs.ecomp.jm_c.connection;

import br.uefs.ecomp.jm_c.model.Adversario;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


/**
 * Classe ConexaoCliente, inicializa a conexão com o servidor e se comunica com
 * ele enviando e recebendo strings.
 *
 * @author Camille Jesus e Felipe Damasceno
 *
 */
public class ConexaoCliente {
    
    private static ConexaoCliente Conexao;
    
    DatagramSocket servidor;
    private static int porta;// porta do servidor udp
    private ArrayList<Adversario> saidas;
    private static String nickname;
    private int ordem; //ordem do jogador no jogo
    private String cor; // cor do pino
    private int tempoPartida;
    
    /** Método que inicializa a classe.
     *
     * @throws UnknownHostException
     * @throws IOException
     */
    public static void singleton() throws UnknownHostException, IOException {
        Conexao = new ConexaoCliente();
    }

    /** Método que retorna a instância da classe.
     *
     * @return Conexao ConexaoCliente
     */
    public static ConexaoCliente getInstancia() {
        return Conexao;
    }
    
    /** Métod que retorna os adversários da partida.
     * 
     * @return saidas Adversarios
     */
    public ArrayList<Adversario> getSaidas() {
        return saidas;
    }
    
    /** Método que altera os adversários da partida.
     * 
     * @param saidas 
     */
    public void setSaidas(ArrayList<Adversario> saidas) {
        this.saidas = saidas;
    }
    
    /** Método que retonar o número de adversários na partida.
     * 
     * @return numero int
     */
    public int getNumeroJogadores() {
        return (saidas.size());
    }
    
    /** Método que adiciona as informações dos adversários da partida para o jogador
     * atual estabelecer a comunicação.
     * 
     * @param ip
     * @param porta
     * @param ordem
     * @param nome
     * @param cor 
     */
    public void addAdversario(InetAddress ip, int porta, int ordem, String nome, String cor){
        saidas.add(new Adversario(ip, porta, ordem, nome, cor));
    }
     /** Método que retorna o nome dos jogadores.
      * 
      * @return  nomes ArrayList
      */
    public ArrayList getNomeJogadores() {
        ArrayList nomes =  new ArrayList();
                
        for (int i = 0; i < saidas.size(); i++) {
            nomes.add(saidas.get(i).getNickname());
        }
        return nomes;
    }
    
    /** Método que retorna a porta do servidor UDP atual.
     *
     * @return porta int
     */
    public static int getPorta() {
        return porta;
    }

    /** Método que altera o valor da porta do servidor UDP atual.
     *
     * @param porta
     */
    public static void setPorta(int porta) {
        Conexao.porta = porta;
    }
    
    /** Método que retorna o nickname do jogador atual.
     * 
     * @return nickname String
     */
   public String getNickname(){
       return this.nickname;
   }
   
    /** Método que altera o nickname do jogador atual.
     * 
     * @param nickname
     */
    public static void setNickname(String nickname){
        ConexaoCliente.nickname = nickname;
    }
    
    /** Método que retorna a ordem do jogador atual na partida.
     * 
     * @return ordem int
     */
    public int getOrdem() {
        return this.ordem;
    }  
    
    /** Método que altera a ordem do jogador atual na partida.
     * 
     * @param ordem 
     */
    public void setOrdem(int ordem){
        this.ordem = ordem;
    }
   
   /** Método que retorna a cor do peão escolhida pelo jogador atual.
    * 
    * @return cor String
    */
    public String getCor() {
        return cor;
    }
    
    /** Método que altera a cor do peão escolhida pelo jogador atual.
     * @param cor 
     */
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    /** Método que retorna o tempo da partida.
     * 
     * @return tempoPartida int
     */
    public int getTempoPartida () {
        return this.tempoPartida;
    }
    
    /** Método que altera o tempo da partida.
     * 
     * @param tempoPartida 
     */
    public void setTempoPartida(int tempoPartida){
        this.tempoPartida = tempoPartida;
       
    }

    /** Método que conecta com o servidor UDP.
     * 
     * @return 
     */
    public boolean conecta() {
        saidas = new ArrayList<>();
        
        try {
            //cria porta para escutar algo
            servidor = new DatagramSocket(porta);
            System.out.println("Porta " + porta + " aberta!");
            return true; // sucesso
        } catch (SocketException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar o servidor", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return false; // deu erro
        }
    }

    /** Método que envia uma string para o servidor UDP.
     *
     * @param s
     * @throws java.net.SocketException
     */
    public void envia(String s) throws SocketException, IOException {
        //envia mensagem para as portas dos outros usuarios
        try (DatagramSocket ds = new DatagramSocket()) {
            //envia mensagem para as portas dos outros usuarios
            byte[] msg = s.getBytes();
            
            for (Adversario jogador : saidas) {
                
                DatagramPacket pkg = new DatagramPacket(msg, msg.length, jogador.getIp(), jogador.getPorta());
                //envia pacote
                ds.send(pkg);
                
            }
        }
    }
    
    /** Método que envia uma string para o servidor UDP de um jogador específico,
     * a partir de seu nome.
     * 
     * @param nome
     * @param s
     * @throws SocketException
     * @throws IOException 
     */
    public void enviaJogador(String nome, String s) throws SocketException, IOException {
        //envia mensagem para as portas dos outros usuarios
        try (DatagramSocket ds = new DatagramSocket()) {
            //envia mensagem para as portas dos outros usuarios
            byte[] msg = s.getBytes();
            
            for (Adversario jogador : saidas) {
                
                if (nome.equals(jogador.getNickname())) {
                    DatagramPacket pkg = new DatagramPacket(msg, msg.length, jogador.getIp(), jogador.getPorta());
                    //envia pacote
                    ds.send(pkg);
                }
            }
        }
    }

    /** Método que recebe uma string do servidor UDP e a retorna.
     *
     * @return string
     * @throws java.io.IOException
     */
    public String recebe() throws IOException {
        byte[] msg = new byte[256];
        //cria o pacote para receber a mensagem
        DatagramPacket pkg = new DatagramPacket(msg, msg.length);
        //recebe mensagem, transforma em string e retorna        
        servidor.receive(pkg);
        String resposta = new String(pkg.getData()).trim();       
        return resposta;
        
    }

    /** Método que desconecta do servidor USP.
     *
     * @throws IOException
     */
    public void desconecta() throws IOException {
        servidor.close();
    }

}