package jogo.logica.dados;

import java.util.ArrayList;
import java.util.List;

public class ModoHvH extends ModoAdapter{

    public ModoHvH(){
        super();
    }

    @Override
    public boolean addJogador(String s) {
        for(int i=0; i<getJogadores().size(); i++){
            Jogador j = (Jogador) getJogadores().get(i);
            if(j.getNome().compareToIgnoreCase(s) == 0){
                return false;
            }
        }
        JogadorH novo = new JogadorH(s);
        getJogadores().add(novo);
        return true;
    }
}
