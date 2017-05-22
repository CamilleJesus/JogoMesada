package br.uefs.ecomp.jm_c.model;


/**
 *
 * @author Camille Jesus
 */
public class Peao {
    
    private int quantidade;
    private int linha;
    private int coluna;

    public Peao() {
        this.quantidade = 0;
        this.linha = 0;
        this.coluna = 0;
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