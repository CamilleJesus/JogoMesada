/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.jm_s.model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.uefs.ecomp.jm_s.view.Servidor;

/**
 *
 * @author felipe
 */
public class Cronometro implements Runnable {

    private Servidor servidor;
    private int sala;

    public Cronometro(Servidor servidor, int sala) {
        this.servidor = servidor;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(60000);
            servidor.tempoAcabou(sala);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

}
