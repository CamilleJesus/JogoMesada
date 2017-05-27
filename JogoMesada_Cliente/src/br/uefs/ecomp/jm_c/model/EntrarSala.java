/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.jm_c.model;

import br.uefs.ecomp.jm_c.view.Inicio;
import br.uefs.ecomp.jm_c.view.Login;
import br.uefs.ecomp.jm_c.view.Sala;
import br.uefs.ecomp.jm_c.view.TelaJogo;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class EntrarSala implements Runnable{

    private int sala;

    public EntrarSala(int sala) {
        this.sala = sala;
    }

    public void run() {

        
            System.out.println("oi");
        try {
            conectarJogadores(this.sala);
            System.out.println("oi");
            
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new TelaJogo().start(new Stage());
                            Sala.getStage().close();
                    } catch (Exception ex) {
                        Logger.getLogger(EntrarSala.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
        } catch (IOException ex) {
            Logger.getLogger(EntrarSala.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
        

    }

    

    private void conectarJogadores(int sala) throws IOException {
        esperarTempo(sala);
        Conexao cliente = Conexao.getInstancia();
        ConexaoCliente conexao = ConexaoCliente.getInstancia();
        if (cliente.conectar()) {
            cliente.enviar("conectar");
            cliente.enviar("" + sala);
            int tam = Integer.parseInt(cliente.receber());
            System.out.println(tam);
            for (int i = 0; i < tam; i++) {

                String ip = cliente.receber();
                String porta = cliente.receber();
                String ordem = cliente.receber();
                if (Integer.parseInt(porta) != conexao.getPorta()) {
                    System.out.println(ip);
                    System.out.println(porta);
                    conexao.addJogador(InetAddress.getByName(ip), Integer.parseInt(porta), Integer.parseInt(ordem));

                }
            }
        }
        /**
         * Por tela do jogo aqui
         */
        cliente.disconectar();

    }

    public void esperarTempo(int sala) throws IOException {
        Conexao cliente = Conexao.getInstancia();

        String resposta = "false";
        while (resposta.equals("false")) {
            if (cliente.conectar()) {

                cliente.enviar("tempo");
                cliente.enviar("" + sala);
                resposta = cliente.receber();
                
                cliente.disconectar();
            }
        }
    }
}
