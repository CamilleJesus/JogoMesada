package br.uefs.ecomp.jm_s.view;

import br.uefs.ecomp.jm_s.model.Jogador;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;



/**
 * Classe que armazena informacoes do banco e as manipula.
 *
 * @author felipe e Camille
 *
 */
public class Servidor implements Serializable {

    private HashMap<String, String> clientes;//<nome, senha>
    //<numero da sala, Cliente>
    private transient HashMap<Integer, ArrayList<Jogador>> salas;
    //sala aberta para novos jogadores
    private transient ArrayList<Jogador> sala;
    //numero da sala que esta aberta a novos jogadores
    private transient int numSala;
    //<numero da sala, tempo de espera acabou? jogo iniciado?>
    private transient HashMap<Integer, Boolean> tempoInicioJogo;
    private transient ServerSocket serverSocket;
    //cores escolhidas pelos usuarios da nova sala (sala não iniciada)
    private transient LinkedList<String> cores;
    // <numero da sala, por quanto tempo o jogo vai ser jogado>
    private transient HashMap<Integer, String> salaTempoDeJogo;

    /**
     * Inicializa variaveis
     */
    public Servidor() {
        clientes = new HashMap<String, String>();
        salas = new HashMap<Integer, ArrayList<Jogador>>();
        sala = new ArrayList<Jogador>();
        tempoInicioJogo = new HashMap<Integer, Boolean>();
        cores = new LinkedList<String>();
        salaTempoDeJogo = new HashMap<Integer, String>();
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

            // cria uma classe para tratar cada novo cliente em uma nova thread
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
    /**
     * Cria nova sala quando tempo de espera termina
     * 
     * @param sala 
     */
    public void tempoAcabou(int sala){
        //Se sala ainda esta aberta
        if (numSala == sala){
            //guarda a sala
            salas.put(numSala, this.sala);
            //abri nova sala
            this.sala = new ArrayList();
    
            numSala += 1;
            //nova sala, novas cores
            cores = new LinkedList<String>();
        }
        // terminado tempo então sala iniciada
        tempoInicioJogo.put(sala, true);
        
        
    }
    /**
     * retorna se o tempo de espera acabou
     * @param sala
     * @return se tempo de espera acabou
     */
    public boolean salaPronta(int sala){
        return tempoInicioJogo.get(sala);
    }
    /**
     * retorna a sala dado o numero dela
     * @param sala
     * @return sala
     */
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
     * Adiciona cliente a uma sala de espera.
     * 
     * @param nome
     * @param ip
     * @param porta do servidor udp
     * @param cor do pino
     * @param tempoDeJogo
     * @return numero da sala
     * @throws UnknownHostException 
     */
    public int addSala(String nome, String ip, String porta, String cor, String tempoDeJogo) throws UnknownHostException {
        //se nao tem ninguem na sala
        if (sala.size() == 0){
            //inicializa o tempo com false dizendo que nao terminou e a sala nao sera iniciada ainda
            tempoInicioJogo.put(numSala, false);
        }
        //cor ja escolhida
        if (cores.contains(cor)){
            // retorna -1 para representar que isso nao pode
            return -1;
        }
        
        cores.add(cor);
        sala.add(new Jogador(nome, InetAddress.getByName(ip), Integer.parseInt(porta), this.sala.size(), cor));
        // pega tempo de jogo da sala aberta
        String t = salaTempoDeJogo.get(numSala);
        // se tem algum tempo
        if (t != null){
            
            int tempoAtual = Integer.parseInt(t);
            int tempo = Integer.parseInt(tempoDeJogo);
            //se tempo dado pelo novo jogador da sala for menor que o dado pelos outros 
            //jogadores da sala entao o tempo da sala sera o escolhido pelo novo jogador
            if (tempo < tempoAtual){
                
                salaTempoDeJogo.put(numSala, tempoDeJogo);
            } 
        // se nao tem nenhum tempo adicionado 
        }else{
            salaTempoDeJogo.put(numSala, tempoDeJogo);
        }
        
        // se sala ta cheia
        if (sala.size() == 6) {
            // guarda sala
            salas.put(numSala, sala);
            //cria nova sala aberta
            sala = new ArrayList();
            numSala += 1;
            // nova sala, nenhuma cor escolhida
            cores = new LinkedList<String>();
            // retorna sala do ultimo jogador
            return numSala - 1;
            
        }
        // se sala tem dois jogadores
        if (sala.size() == 2) {
            // inicia cronometro para tempo de espera antes do jogo inicializar
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
