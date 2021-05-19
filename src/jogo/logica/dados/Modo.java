package jogo.logica.dados;

import java.util.ArrayList;
import java.util.List;

public interface Modo {
    boolean addJogador(String s);
    boolean efetuaJogada(int col);
    List<Jogador> getJogadores();
}
