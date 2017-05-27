/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.jm_c.model;

import java.net.InetAddress;

/**
 *
 * @author felipe
 */
public class Usuario {
    
    private InetAddress ip;
    private Integer porta;
    private static int ordem;
    
    public Usuario(InetAddress ip, Integer porta, int ordem) {
        this.ip = ip;
        this.porta = porta;
        this.ordem = ordem;
    }

    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    public static int getOrdem() {
        return Usuario.ordem;
    }

    public static void setOrdem(int ordem) {
        Usuario.ordem = ordem;
    }
    
}