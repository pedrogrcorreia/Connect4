package jogo.logica.dados;

import java.util.Random;

public class JogadorC implements Jogador{
    private String nome;
    private String ficha;
    static private int id;

    public JogadorC(String ficha){
        nome = "Artifical " + id++;
        this.ficha = ficha;
    }

    public int getCol(){
        int max = 7;
        int min = 1;
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    @Override
    public String getFicha(){
        return ficha;
    }

    @Override
    public String getNome() {
        return nome;
    }
}
