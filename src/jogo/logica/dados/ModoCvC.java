package jogo.logica.dados;

import java.util.List;

public class ModoCvC extends ModoAdapter{

    public ModoCvC(){
        super();
    }

    @Override
    public boolean addJogador(String s) {
        Jogador pcnovo = new JogadorC();
        getJogadores().add(pcnovo);
        pcnovo = new JogadorC();
        getJogadores().add(pcnovo);
        return false;
    }

    @Override
    public boolean efetuaJogada(int col) {
        for(int i=0; i<getJogadores().size(); i++){
            Jogador j = (Jogador) getJogadores().get(i);
            j.joga(col);
        }
        return true;
    }
}
