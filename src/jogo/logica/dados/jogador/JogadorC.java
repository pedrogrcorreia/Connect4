package jogo.logica.dados.jogador;

import java.io.Serializable;

public class JogadorC implements Jogador, Serializable {
    private String nome;
    private String ficha;
    private int colJogada;
    static private int id;

    public JogadorC(String ficha){
        if(id == 0) {
            nome = "Alexa";
        }
        else{
            nome = "Siri";
        }
        id++;
        this.ficha = ficha;
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
    public void addCol(int col) {
        colJogada = col;
    }

    @Override
    public int getCol(){
        int max = 6;
        int min = 0;
        return colJogada = (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    @Override
    public int randomCol() {
        int max = 6;
        int min = 0;
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    @Override
    public void incrementaJogadas() {
        return;
    }

    @Override
    public int getJogadas(){
        return 0;
    }

    @Override
    public int getCreditos(){ return 0;}

    @Override
    public void removeCreditos(int creditos) {
        return;
    }

    @Override
    public void resetJogadas() {
        return;
    }

    @Override
    public void incrementaRespostas() {
        return;
    }

    @Override
    public int getRespostas() {
        return 0;
    }

    @Override
    public int getMinijogo() {
        return 0;
    }

    @Override
    public void mudaMinijogo() {
        return;
    }

    @Override
    public void incrementaEspecial() {
        return;
    }

    @Override
    public int getEspecial() {
        return 0;
    }

    @Override
    public void resetRespostas(){
        return;
    }

    @Override
    public void startClock() {
        return;
    }

    @Override
    public void stopClock() {
        return;
    }

    @Override
    public int getTempo() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jogador " + nome + " jogou na coluna " + (colJogada+1) + ".");
        return sb.toString();
    }
}
