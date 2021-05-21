package jogo.logica.dados;

import java.io.Serializable;
import java.util.Random;

public class JogadorC implements Jogador, Serializable {
    private String nome;
    private String ficha;
    private int colJogada;
    static private int id;

    public JogadorC(String ficha){
        nome = "Artifical " + id++;
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
        int max = 7;
        int min = 1;
        colJogada = (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    @Override
    public int getCol(){
        return colJogada;
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jogador " + nome + " jogou na coluna " + (colJogada+1));
        return sb.toString();
    }
}
