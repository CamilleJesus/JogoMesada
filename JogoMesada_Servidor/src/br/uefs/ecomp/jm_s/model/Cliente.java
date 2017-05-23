package br.uefs.ecomp.jm_s.model;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.List;
/**
 * Classe que armazena informacoes da conta do cliente
 * @author felipe
 *
 */
public class Cliente implements Serializable{
	private String nome;
	private InetAddress ip;
	private int porta;
        private int ordem;
	
	public Cliente (String nome, InetAddress ip, int porta, int ordem){
		this.nome = nome;
                this.ip = ip;
                this.porta = porta;
                this.ordem = ordem;
	}
	
	/**
	 * Retorna nome
	 * @return nome 
	 */
	public String getNome(){
		return nome;
	}
        
        
        public int getOrdem(){
		return ordem;
	}
	/**
	 * Retorna ip
	 * @return ip
	 */
	public InetAddress getIp(){
		return ip;
	}
        
        /**
	 * Retorna porta
	 * @return ip
	 */
	public int getPorta(){
		return porta;
	}
	
}
