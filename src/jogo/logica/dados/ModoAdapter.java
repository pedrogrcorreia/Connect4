package jogo.logica.dados;

import java.util.ArrayList;
import java.util.List;

public abstract class ModoAdapter implements Modo {
    private List<Jogador> jogadores;
    private int jogadas;

    public ModoAdapter(){
        this.jogadores = new ArrayList<Jogador>(2);
    }

    @Override
    public List<Jogador> getJogadores(){
        return jogadores;
    }

    @Override
    public boolean addJogador(String s) {
        return false;
    }

    @Override
    public boolean efetuaJogada(int col){return false;    }

}
