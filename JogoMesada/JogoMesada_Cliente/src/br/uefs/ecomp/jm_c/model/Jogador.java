package br.uefs.ecomp.jm_c.model;


/**
 *
 * @author Camille Jesus
 */
public class Jogador {
    
    private String nickname;
    private String senha;
    
    public Jogador(String nickname, String senha) {
        this.nickname = nickname;
        this.senha = senha;
    }
    
    public String getNickname() {
        return nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (obj instanceof Jogador) {
            
            if (this.nickname.equals(((Jogador) obj).getNickname())) {
                return true;
            }
        }
        return false;
    }
    
}