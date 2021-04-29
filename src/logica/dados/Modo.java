package logica.dados;

import java.util.ArrayList;
import java.util.List;

public abstract class Modo {
    private List<Jogador> jogadores = new ArrayList<>();

    public List getJogadores(){return jogadores;}
    public abstract boolean addJogador(Jogador j);

}
