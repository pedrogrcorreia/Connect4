package jogo.logica.dados.jogador;

import java.io.Serial;
import java.io.Serializable;

public interface IJogador extends Serializable {
    @Serial
    long serialVersionUID = 1L;

    String getNome();
    String getFicha();
    int getCol();
    void addCol(int col);
    int randomCol();
    void incrementaJogadas();
    int getJogadas();
    void resetJogadas();
    int getCreditos();
    void removeCreditos(int creditos);
    void incrementaRespostas();
    int getRespostas();
    int getMinijogo();
    void mudaMinijogo();
    void incrementaEspecial(int i);
    int getEspecial();
    void resetRespostas();
    void startClock();
    void stopClock();
    int getTempo();
    void resetCreditos();
}
