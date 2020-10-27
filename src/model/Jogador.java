package model;

public class Jogador {
    
    private String nome;
    private char simbolo;
    private boolean vez;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public Jogador(String nome, char simbolo) {
        this(nome);
        this.simbolo = simbolo;
        this.vez = false;
    }

    public String getNome() {
        return nome;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setVez(boolean vez) {
        this.vez = vez;
    }

    public boolean getVez(){
        return vez;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Jogador other = (Jogador) obj;
        
        return this.nome == other.nome;
    }
}
