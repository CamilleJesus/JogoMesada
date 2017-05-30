/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.jm_c.view.controller;

import br.uefs.ecomp.jm_c.view.TelaJogoController;
import br.uefs.ecomp.jm_c.connection.ConexaoCliente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        System.out.println("entrou run recebedor");
        ConexaoCliente conexao = ConexaoCliente.getInstancia();
        String sorteio = null;
        try {
            sorteio = conexao.receber();
            System.out.println("recebe");
        } catch (IOException ex) {
            Logger.getLogger(AtualizaJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        jogo.movePeao(Integer.parseInt(sorteio));
    }   
    
}
