package jogo.logica.dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MinijogoDicionario implements Minijogo, Serializable {

    List<String> dicionario;
    StringBuilder palavras;

    public MinijogoDicionario(){
        dicionario = new ArrayList<String>();
        palavras = new StringBuilder();
        leDicionario();
    }

    public void leDicionario() {
        try {
            File myObj = new File("dicionario.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dicionario.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void criaJogo(){
        int max = dicionario.size()-1;
        int min = 0;
        int rnd;
        for(int i=0; i<5; i++) {
            rnd = (int) Math.floor(Math.random() * (max - min + 1) + min);
            palavras.append(dicionario.get(rnd));
            if(i == 4){
                continue;
            }
            palavras.append(" ");
        }
    }

    public int calculaTempo(){
        return palavras.length() / 2;
    }

    @Override
    public String getJogo(){
        return palavras.toString();
    }

    @Override
    public String getResposta(){
        return palavras.toString();
    }

    @Override
    public boolean respostaCorreta(String resposta){
        if(resposta.compareToIgnoreCase(getResposta()) == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean vitoriaMinijogo(int tempo, int respostas) {
        if(tempo <= calculaTempo()){
            return true;
        }
        return false;
    }

    @Override
    public boolean continuaMinijogo(int respostas) {
        return false;
    }

    // Funcao debug
    public String getDicionario(){
        StringBuilder sb = new StringBuilder();
        for(String s : dicionario){
            sb.append(s);
        }
        return sb.toString();
    }
}
