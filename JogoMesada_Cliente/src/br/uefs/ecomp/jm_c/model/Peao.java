package br.uefs.ecomp.jm_c.model;

import javafx.scene.shape.Circle;


/**
 *
 * @author Camille Jesus
 */
public class Peao {
    
    private int id;
    private Circle circulo;
    private int quantidade;
    private int linha;
    private int coluna;

    public Peao() {
        this.circulo = new Circle();
        this.quantidade = 0;
        this.linha = 0;
        this.coluna = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Circle getCirculo() {
        return circulo;
    }

    public void setCirculo(Circle circulo) {
        this.circulo = circulo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void aumentaQuantidade(int valor) {
        this.quantidade += valor;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    
}