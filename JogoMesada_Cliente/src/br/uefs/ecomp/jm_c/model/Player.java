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
public class Player {
    private InetAddress ip;
    private int porta;
    private int ordem;
    
    public Player(InetAddress ip, int porta, int ordem){
        this.ip = ip;
        this.porta = porta;
        this.ordem = ordem;
    }
    
    public int getOrdem(){
        return ordem;
    }
    
    public InetAddress getIp(){
        return ip;
    }
    
    public int getPorta(){
        return porta;
    }
}
