package logica.dados;

public class Jogador {
    String username;
    int jogadas;

    public Jogador(String u){
        username = u;
        jogadas = 0;
    }

    public void incrementaJogada(){
        jogadas++;
    }

    public int getJogadas(){
        return jogadas;
    }
}
