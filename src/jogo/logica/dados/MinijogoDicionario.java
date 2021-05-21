package jogo.logica.dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinijogoDicionario implements Serializable {

    List<String> dicionario;
    String palavra, palavraEscondida;

    public MinijogoDicionario(){
        dicionario = new ArrayList<String>();
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

    public void criaJogo(){
        int max = dicionario.size()-1;
        int min = 0;
        int rnd;
        rnd = (int) Math.floor(Math.random() * (max - min + 1) + min);
        palavra = dicionario.get(rnd);
    }

    public String getJogo(){
        int max = palavra.length()-1;
        int min = 0;
        int rnd;
        StringBuilder sb = new StringBuilder(palavra);
        for(int i=0; i<2; i++) {
            rnd = (int) Math.floor(Math.random() * (max - min + 1) + min);
            sb.setCharAt(rnd, '*');
        }
        return sb.toString();
    }

    public String getResposta(){
        return palavra;
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
