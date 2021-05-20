package jogo.logica.dados;

public interface Jogador {
    String getNome();
    String getFicha();
    int getCol();
    void addCol(int col);
    void incrementaJogadas();
    int getJogadas();
    void resetJogadas();
    int getCreditos();
    void removeCreditos(int creditos);
}
