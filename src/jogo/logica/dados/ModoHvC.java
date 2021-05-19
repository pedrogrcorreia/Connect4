package jogo.logica.dados;

import java.util.ArrayList;
import java.util.List;

public class ModoHvC extends ModoAdapter{

    public ModoHvC(){
        super();
    }

    @Override
    public boolean addJogador(String s) {
        Jogador novo = new JogadorH(s);
        getJogadores().add(novo);
        Jogador pcnovo = new JogadorC();
        getJogadores().add(pcnovo);
        return false;
    }
}
