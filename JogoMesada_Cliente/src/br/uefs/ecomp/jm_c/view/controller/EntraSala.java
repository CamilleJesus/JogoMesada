package br.uefs.ecomp.jm_c.view.controller;

import br.uefs.ecomp.jm_c.connection.Conexao;
import br.uefs.ecomp.jm_c.connection.ConexaoCliente;
import br.uefs.ecomp.jm_c.view.TelaEspera;
import br.uefs.ecomp.jm_c.view.TelaJogo;
import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Classe que permite um jogador entrar em uma sala.
 * @author felipe
 */
public class EntraSala implements Runnable{

    private int sala;
    /**
     * Inicializa variaveis
     * @param sala - numero da sala
     */
    public EntraSala(int sala) {
        this.sala = sala;
    }
    /**
     * Espera o tempo de espera acabar, conecta os jogadores da sala e inicia o jogo.
     */
    public void run() {

        
            
        try {
            //espera tempo de espera acabar e conecta os jogadores da sala.
            conectarJogadores(this.sala);
            
            // inicia o jogo
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new TelaJogo().start(new Stage());
                            TelaEspera.getStage().close();
                    } catch (Exception ex) {
                        Logger.getLogger(EntraSala.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
        } catch (IOException ex) {
            Logger.getLogger(EntraSala.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
        

    }
    /**
     * Espera tempo de espera acabar e conecta os jogadores da sala.
     * @param sala
     * @throws IOException 
     */
    private void conectarJogadores(int sala) throws IOException {
        // espera o tempo de espera da sala acabar
        esperarTempo(sala);
        Conexao cliente = Conexao.getInstancia();
        ConexaoCliente conexao = ConexaoCliente.getInstancia(); 
        if (cliente.conectar()) {
            // conecta os jogadores em p2p
            cliente.enviar("conectar");
            cliente.enviar("" + sala);
            //tempo de duracao da partida
            int tempoPartida = Integer.parseInt(cliente.receber());
            conexao.setTempoPartida(tempoPartida);
            int tam = Integer.parseInt(cliente.receber());
            // pega as informacao dois jogadores
            for (int i = 0; i < tam; i++) {

                String ip = cliente.receber();
                String porta = cliente.receber();
                String ordem = cliente.receber();
                String nome = cliente.receber();
                String cor = cliente.receber();
                // se o jogador nao eh dono dessa maquina
                if (Integer.parseInt(porta) != conexao.getPorta()) {
                    // adiciona adversario na conexao p2p
                    conexao.addAdversario(InetAddress.getByName(ip), Integer.parseInt(porta), Integer.parseInt(ordem), nome, cor);

                }else{// se eh o dono da maquina
                    //adiciona suas informacoes
                    conexao.setOrdem(Integer.parseInt(ordem));
                    conexao.setCor(cor);
                }
            }
            
            
        }
        
        cliente.disconectar();
        

    }
    /**
     * Espera tempo de espera da sala acabar
     * @param sala
     * @throws IOException 
     */
    public void esperarTempo(int sala) throws IOException {
        Conexao cliente = Conexao.getInstancia();

        String resposta = "false";
        // enquanto tempo nao acabou
        while (resposta.equals("false")) {
            if (cliente.conectar()) {
                // pergunta ao servidor se o tempo acabou
                cliente.enviar("tempo");
                cliente.enviar("" + sala);
                resposta = cliente.receber();
                
                cliente.disconectar();
            }
        }
    }
}
