package jogo.logica.dados;

import java.io.Serializable;

public class JogadorH implements Jogador, Serializable {
    String nome;
    String ficha;
    private int colJogada;
    private int jogadas;
    private int creditos;
    private int special;

    public JogadorH(String username, String ficha){
        nome = username;
        this.ficha = ficha;
        jogadas = 0;
        creditos = 5;
        special = 0;
    }

    @Override
    public int getCol() {
        return colJogada;
    }

    @Override
    public void addCol(int col){
        colJogada = col;
    }

    @Override
    public String getFicha(){
        return ficha;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void incrementaJogadas() {
        if(jogadas == 4){
            jogadas = 0;
        }
        else{
            jogadas++;
        }
    }

    @Override
    public int getJogadas() {
        return jogadas;
    }

    @Override
    public void resetJogadas() {
        jogadas = 0;
    }

    @Override
    public int getCreditos() {
        return creditos;
    }

    @Override
    public void removeCreditos(int creditos) {
        this.creditos = creditos;
        this.creditos--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jogador " + nome + " jogou na coluna " + (colJogada+1) + ".\n");
        sb.append("Tem " + creditos + " créditos e faltam " + (4-jogadas) + " jogadas para o minijogo.\n");
        return sb.toString();
    }
}
