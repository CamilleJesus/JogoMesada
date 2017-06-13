package br.uefs.ecomp.jm_s.view;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import br.uefs.ecomp.jm_s.model.Jogador;

/**
 * Classe que trata dos multi-clientes. Ela possue as funcoes para cada acao que
 * o cliente pode tomar no servidor central do jogo.
 *
 * @author felipe e Camille
 *
 */
public class TrataCliente implements Runnable {

    private Scanner entrada;
    private PrintStream saida;
    private Servidor servidor;

    /**
     * Inicializados da classe. Recebe o servidor e as entradas e saidas para
     * comunicacao com cliente
     *
     * @param in
     * @param out
     * @param servidor
     */
    public TrataCliente(InputStream in, OutputStream out, Servidor servidor) {
        this.entrada = new Scanner(in);
        this.saida = new PrintStream(out);
        this.servidor = servidor;
    }

    /**
     * Metodo que eh executado quando a classe inicia. Pedi uma acao do cliente
     * para chamar a funcao apropriada para ela. Depois fecha a conexao com
     * cliente.
     */
    public void run() {
        try {
            String acao = entrada.nextLine();
            if (acao.equals("cadastrar")) {
                cadastrar();
            } else if (acao.equals("entrar")) {
                entrar();
            } else if (acao.equals("fechar")) {
                servidor.fechar();
            } else if (acao.equals("sala")) {
                entrarSala();
            } else if (acao.equals("tempo")) {
                tempo();//tempo de espera acabou?
            } else if (acao.equals("conectar")) {
                //envia informacao dos jogadores da sala para criar o p2p
                conectarJogadores(); 
            }else if (acao.equals("vencedor")){
                String nome = entrada.nextLine();
                double saldo = Double.parseDouble(entrada.nextLine());
                System.out.println(saldo);
                String classificacao = servidor.getVencedor(nome, saldo);
                System.out.println("ói eu");
                saida.println(classificacao);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entrada.close();
            saida.close();
        }
    }
    /**
     * Envia informacao dos jogadores da sala para criar o p2p
     */
    private void conectarJogadores() {
        // recebe numero da sala
        String sala = entrada.nextLine();
        ArrayList<Jogador> jogadores = servidor.getSala(Integer.parseInt(sala));
        String tempoDePartida = servidor.getTempoJogo(Integer.parseInt(sala));
        saida.println(tempoDePartida);
        // envia quantidade de jogadores na sala
        saida.println(jogadores.size());
        // envia informacao dos jogadores
        for (Jogador cliente : jogadores) {
            saida.println(cliente.getIp().getHostAddress());
            saida.println(cliente.getPorta());
            // envia ordem em que o jogador joga
            saida.println("" + cliente.getOrdem());
            saida.println(cliente.getNome());
            // envia cor do pino no jogo
            saida.println(cliente.getCor());

        }
    }
    /**
     * Envia ao jogador se o tempo de espera para o jogo comecar acabou ou nao
     */
    public void tempo() {
        String sala = entrada.nextLine();

        if (servidor.salaPronta(Integer.parseInt(sala))) {
            saida.println("true");
        } else {
            saida.println("false");
        }
    }
    /**
     * Recebe informacao do usuario e coloca ele em uma sala de espera.
     * @throws UnknownHostException 
     */
    public void entrarSala() throws UnknownHostException {
        String nome = entrada.nextLine();
        String ip = entrada.nextLine();
        String porta = entrada.nextLine();
        String cor = entrada.nextLine();
        String tempo = entrada.nextLine();
        // adiciona o jogador em uma sala e recebe o numero da sala que o jogador esta
        int sala = servidor.addSala(nome, ip, porta, cor, tempo);
        // jogador nao foi adicionado a sala devido a erro
        if (sala != - 1) {
            // informa usuario do erro
            saida.println("" + sala);
            saida.println("1");// deu erro
        } else {
            // usuario em sala e retorna numero da sala para o usuario
            saida.println("" + sala);
            saida.println("0");// funcionou
        }
    }

    /**
     * Salva servidor em arquivo.
     *
     * @throws IOException
     */
    private void salvar() throws IOException {
        FileOutputStream arquivoGrav = new FileOutputStream("servidor.ser");
        ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);

        objGravar.writeObject(servidor);
        objGravar.flush();
        objGravar.close();

        arquivoGrav.flush();
        arquivoGrav.close();

    }

    /**
     * Loga em uma conta se informacoes estiver correta
     */
    private void entrar() {
        String nome = entrada.nextLine();
        String senha = entrada.nextLine();
        String confirmarSenha = servidor.getSenha(nome);

        if (confirmarSenha != null) {// existe senha
            // senha esta correta
            if (senha.equals(confirmarSenha)) {
                saida.println("1");// tudo correto

            }

        }
        saida.println("0");// teve erro

    }

    /**
     * Cadastra um cliente ao banco
     *
     * @throws IOException
     */
    private void cadastrar() throws IOException {
        String nome = entrada.nextLine();
        String senha = entrada.nextLine();
        if (!servidor.contemCliente(nome)) {
            servidor.addCliente(nome, senha);
            saida.println("1");// tudo correto
            salvar();
        } else {
            saida.println("0");//nome ja existe
        }

    }
}
