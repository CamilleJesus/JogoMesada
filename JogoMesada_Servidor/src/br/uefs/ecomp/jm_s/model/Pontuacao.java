/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.jm_s.model;

/**
 *
 * @author felipe
 */
public class Pontuacao {
    private String nome;
    private double saldo;
    
    public Pontuacao(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public double getSaldo(){
        return saldo;
    }
}
