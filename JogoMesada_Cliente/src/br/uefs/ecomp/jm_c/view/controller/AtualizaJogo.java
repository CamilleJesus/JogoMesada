/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.jm_c.view.controller;

import br.uefs.ecomp.jm_c.view.TelaJogoController;
import br.uefs.ecomp.jm_c.connection.ConexaoCliente;
import br.uefs.ecomp.jm_c.view.TelaEspera;
import br.uefs.ecomp.jm_c.view.TelaJogo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 *
 * @author Rafaela
 */
public class AtualizaJogo implements Runnable {

    private TelaJogoController jogo;
    public AtualizaJogo(TelaJogoController jogo){
        this.jogo = jogo;
    }
    
    @Override
    public void run() {
        System.out.println("entrou run AtualizaJogo");
        ConexaoCliente conexao = ConexaoCliente.getInstancia();
        
        while (true) {
            final String sorteio;
            final String ordem;
            
            try {
                ordem = conexao.receber();
                sorteio = conexao.receber();
                System.out.println("recebe");

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("entrou run2 AtualizaJogo");
                        jogo.movePeao(Integer.parseInt(ordem), Integer.parseInt(sorteio));
                    }
                });
            } catch (IOException ex) {
                Logger.getLogger(AtualizaJogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
    
}
