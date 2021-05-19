package jogo.logica.dados;

import java.util.ArrayList;
import java.util.List;

public class Dados {
    private Tabuleiro tabuleiro;
    private int modo;
    private Jogador j1, j2, atual, prox;
    public Dados(){
        tabuleiro = new Tabuleiro();
    }

    public boolean escolheModo(int opc){
        modo = opc;
        return true;
    }

    public int getModo(){
        return modo;
    }

    public boolean configuraJogador(String s){
        if(modo == 1){
            if(j1 == null) {
                j1 = new JogadorH(s, "O");
                return false;
            }
            else{
                if(j1.getNome().compareToIgnoreCase(s) == 0){
                    return false;
                }
                j2 = new JogadorH(s, "X");
                iniciaJogo();
                return true;
            }
        }
        if(modo == 2){
            j1 = new JogadorH(s, "O");
            j2 = new JogadorC("X");
            iniciaJogo();
            return true;
        }
        if(modo == 3){
            j1 = new JogadorC("O");
            j2 = new JogadorC("X");
            iniciaJogo();
            return true;
        }
        return true;
    }

    public boolean iniciaJogo(){
        atual = j1;
        prox = j2;
        return true;
    }

    public boolean efetuaJogada(int col){
        tabuleiro.joga(col-1, atual.getFicha());
        Jogador aux = atual;
        atual = prox;
        prox = aux;
        return true;
    }

    public boolean efetuaJogadaPC(){
        tabuleiro.joga(atual.getCol()-1, atual.getFicha());
        Jogador aux = atual;
        atual = prox;
        prox = aux;
        return true;
    }

    public String getTabuleiro(){
        return tabuleiro.toString();
    }
}
