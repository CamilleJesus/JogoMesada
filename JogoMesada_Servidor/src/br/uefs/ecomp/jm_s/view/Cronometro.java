package br.uefs.ecomp.jm_s.view;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que cronometro o tempo para iniciar o jogo em uma sala
 * @author felipe e Camille
 */
public class Cronometro implements Runnable {
    
    private Servidor servidor;
    private int sala;
    /**
     * Inicializa variaveis.
     * @param servidor
     * @param sala - numero da sala que esta sendo cronometrado.
     */
    public Cronometro(Servidor servidor, int sala) {
        this.servidor = servidor;
        this.sala = sala;
    }
    /**
     * Espera vinte segundos e informa ao servidor que o tempo de espera da sala
     * acabou.
     */
    @Override
    public void run() {

        try {
            Thread.sleep(20000);
            servidor.tempoAcabou(sala);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

}
