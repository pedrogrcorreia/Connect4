package jogo.logica.dados;

import java.util.ArrayList;
import java.util.List;

public class Dados {
    private Tabuleiro tabuleiro;
    private Modo modo;
    private List jogadores;
    public Dados(){
        tabuleiro = new Tabuleiro();
    }

    public boolean escolheModo(int opc){
        switch(opc){
            case 1:
                modo = new ModoHvH();
                break;
            case 2:
                modo = new ModoHvC();
                break;
            case 3:
                modo = new ModoCvC();
                break;
            default:
                return false;
        }
        return true;
    }

    public boolean configuraJogador(String s){
        if(modo.addJogador(s)) {
            return true;
        }
        return false;
    }

    public boolean iniciaJogo(){
        jogadores = modo.getJogadores();
        for(int i=0; i< jogadores.size(); i++){
            Jogador j = (Jogador) jogadores.get(i);
            System.out.println(j.getNome()+"\n");
        }
        return true;
    }

    public boolean efetuaJogada(int col){
        tabuleiro.joga(col-1);
        return true;
    }

    public String getTabuleiro(){
        return tabuleiro.toString();
    }
}
