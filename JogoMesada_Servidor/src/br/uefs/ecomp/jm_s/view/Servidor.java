package br.uefs.ecomp.jm_s.view;

import br.uefs.ecomp.jm_s.model.Cliente;
import br.uefs.ecomp.jm_s.model.Cronometro;
import br.uefs.ecomp.jm_s.model.TrataCliente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



/**
 * Classe que armazena informacoes do banco e as manipula.
 *
 * @author felipe
 *
 */
public class Servidor implements Serializable {

    private HashMap<String, String> clientes;//<nome, senha>
    //<numero da sala, Cliente>
    private transient HashMap<Integer, ArrayList<Cliente>> salas;
    //sala<Cliente>
    private transient ArrayList<Cliente> sala;
    private transient int numSala;
    private transient HashMap<Integer, Boolean> tempo;
    private transient ServerSocket serverSocket;
    private transient LinkedList<String> cores;
    private transient HashMap<Integer, String> salaTempo;

    /**
     * Inicializa variaveis
     */
    public Servidor() {
        clientes = new HashMap<String, String>();
        salas = new HashMap<Integer, ArrayList<Cliente>>();
        sala = new ArrayList<Cliente>();
        tempo = new HashMap<Integer, Boolean>();
        cores = new LinkedList<String>();
        salaTempo = new HashMap<Integer, String>();
        numSala = 0;
    }

    /**
     * Abri porta do servidor e permite que mais de um cliente a acesse.
     */
    public void executa() throws IOException {

        serverSocket = new ServerSocket(12346);

        while (true) {
            // aceita um cliente
            Socket cliente = serverSocket.accept();

            // cria tratador de cliente numa nova thread
            TrataCliente tc = new TrataCliente(cliente.getInputStream(), cliente.getOutputStream(), this);
            new Thread(tc).start();
        }

    }
    

    /**
     * Fecha servidor. Nao permite que os clientes se conectem mais com ele.
     *
     * @throws IOException
     */
    public void fechar() throws IOException {
        serverSocket.close();
        System.exit(0);
    }

    /**
     * Retorna senha de acordo com seu nome
     *
     * @param nome
     * @return cliente
     */
    public String getSenha(String nome) {
        return clientes.get(nome);

    }
    
    public void tempoAcabou(int sala){
        if (numSala == sala){
            salas.put(numSala, this.sala);
            this.sala = new ArrayList();
            numSala += 1;
        }
        tempo.put(sala, true);
        boolean atual = tempo.get(sala);
        atual = true;
        cores = new LinkedList<String>();
        
    }
    
    public boolean salaPronta(int sala){
        return tempo.get(sala);
    }
    
    public ArrayList getSala(int sala){
        return salas.get(sala);
    }

    /**
     * Adiciona cliente no servidor
     *
     * @param identificador
     * @param cliente
     */
    public void addCliente(String nome, String senha) {
        clientes.put(nome, senha);
    }

    /**
     * Adiciona cliente a uma sala
     *
     * @param identificador
     * @param cliente
     */
    public int addSala(String nome, String ip, String porta, String cor, String temp) throws UnknownHostException {
        if (sala.size() == 0){
            tempo.put(numSala, false);
        }
        if (cores.contains(cor)){
            return -1;
        }
        cores.add(cor);
        sala.add(new Cliente(nome, InetAddress.getByName(ip), Integer.parseInt(porta), this.sala.size(), cor));
        String t = salaTempo.get(numSala);
        if (t != null){
            int time = Integer.parseInt(t);
            int time2 = Integer.parseInt(temp);
            if (time2 < time){
                System.out.println(temp);
                salaTempo.put(numSala, temp);
            } 
        }else{
            salaTempo.put(numSala, temp);
        }
        
        
        if (sala.size() == 6) {
            salas.put(numSala, sala);
            sala = new ArrayList();
            numSala += 1;
            cores = new LinkedList<String>();
            return numSala - 1;
            
        }
        if (sala.size() == 2) {
            Cronometro cronometro = new Cronometro(this, numSala);
            new Thread(cronometro).start();
        }
        return numSala;
    }

    
    /**
     * Carrega informações do servidor que foram salvas.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void carregar() throws IOException, ClassNotFoundException {
        File f = new File("servidor.ser");
        if (f.exists()) {
            FileInputStream fin = new FileInputStream("servidor.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            Servidor servidor = (Servidor) ois.readObject();
            setClientes(servidor.getClientes());

            ois.close();
        }

    }

    /**
     * Verfica se nome do cliente existe no servidor ou nao
     *
     * @param nome
     * @return boolean
     */
    public boolean contemCliente(String nome) {
        return clientes.containsKey(nome);
    }

    /**
     * Retorna os clientes
     *
     * @return clientes
     */
    public HashMap<String, String> getClientes() {
        return this.clientes;
    }

    /**
     * Muda o valor dos clientes
     *
     * @param clientes
     */
    public void setClientes(HashMap<String, String> clientes) {
        this.clientes = clientes;
    }

    /**
     * Inicia servidor
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        try {
            servidor.carregar();
            servidor.executa();
            servidor.fechar();
            //servidor deu algum erro durante execucao
        } catch (IOException e) {
            e.printStackTrace();
            //classe não encontrada, servidor nao roda
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
