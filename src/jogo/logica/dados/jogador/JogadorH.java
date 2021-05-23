package jogo.logica.dados.jogador;

import java.io.Serializable;

public class JogadorH implements Jogador, Serializable {
    String nome;
    String ficha;
    private int colJogada;
    private int jogadas;
    private int creditos;
    private int respostas;
    private int minijogo;
    private int special;

    long start;
    long stop;
    long time;

    public JogadorH(String username, String ficha){
        nome = username;
        this.ficha = ficha;
        jogadas = 0;
        creditos = 5;
        respostas = 0;
        minijogo = 0;
        special = 1;
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
    public int randomCol() {
        return 0;
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
    public void incrementaRespostas() {
        respostas++;
    }

    @Override
    public int getRespostas() {
        return respostas;
    }

    @Override
    public int getMinijogo() {
        return minijogo;
    }

    @Override
    public void mudaMinijogo() {
        if(minijogo == 0){
            minijogo = 1;
        }
        else{
            minijogo = 0;
        }
    }

    @Override
    public void incrementaEspecial() {
        special++;
    }

    @Override
    public int getEspecial() {
        return special;
    }

    @Override
    public void resetRespostas() {
        respostas = 0;
    }

    @Override
    public void startClock() {
        start = System.currentTimeMillis();
    }

    @Override
    public void stopClock() {
        stop = System.currentTimeMillis();
    }

    @Override
    public int getTempo() {
        return (int) (stop - start) / 1000;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(colJogada >= 0 && colJogada <= 6) {
            sb.append("Jogador " + nome + " jogou na coluna " + (colJogada + 1) + ".\n");
        }
        sb.append("Tem " + creditos + " créditos e faltam " + (4-jogadas) + " jogadas para o minijogo.\n");
        return sb.toString();
    }
}
