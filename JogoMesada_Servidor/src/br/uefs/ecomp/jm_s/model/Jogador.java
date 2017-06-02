package br.uefs.ecomp.jm_s.model;

import java.io.Serializable;
import java.net.InetAddress;
/**
 * Classe que armazena informacoes da conta do jogador
 * @author felipe e Camille
 *
 */
public class Jogador implements Serializable{
	private String nome;
	private InetAddress ip;

        private int porta;
        private int ordem;
        private String cor;
	/**
         * inicializa variaveis
         * @param nome
         * @param ip
         * @param porta do servidor udp
         * @param ordem em que vai jogar na partida
         * @param cor do pino
         */
	public Jogador (String nome, InetAddress ip, int porta, int ordem, String cor){
		this.nome = nome;
                this.ip = ip;
                this.porta = porta;
                this.ordem = ordem;
                this.cor = cor;
	}
        /**
         * Retorna cor do pino
         * @return cor do pino
         */
        public String getCor(){
            return cor;
        }
	
	/**
	 * Retorna nome do jogador
	 * @return nome 
	 */
	public String getNome(){
		return nome;
	}
        
        /**
         * retorna ordem que o jogador vai jogar
         * @return ordem
         */
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
	 * Retorna porta do servidor udp
	 * @return ip
	 */
	public int getPorta(){
		return porta;
	}
	
}
