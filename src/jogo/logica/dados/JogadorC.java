package jogo.logica.dados;

import java.util.Random;

public class JogadorC implements Jogador{
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
}
