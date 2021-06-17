package jogo.logica.dados.jogador;

public abstract class JogadorAdapter implements IJogador {
    @Override
    public String getNome() {
        return null;
    }

    @Override
    public String getFicha() {
        return null;
    }

    @Override
    public int getCol() {
        return 0;
    }

    @Override
    public void addCol(int col) {}

    @Override
    public int randomCol() {
        return 0;
    }

    @Override
    public void incrementaJogadas() {}

    @Override
    public int getJogadas() {
        return 0;
    }

    @Override
    public void resetJogadas() {}

    @Override
    public int getCreditos() {
        return 0;
    }

    @Override
    public void removeCreditos(int creditos) {}

    @Override
    public void incrementaRespostas() {}

    @Override
    public int getRespostas() { return 0; }

    @Override
    public int getMinijogo() { return 0; }

    @Override
    public void mudaMinijogo() {}

    @Override
    public void incrementaEspecial(int i) {}

    @Override
    public int getEspecial() { return 0; }

    @Override
    public void resetRespostas() {}

    @Override
    public void startClock() {}

    @Override
    public void stopClock() {}

    @Override
    public int getTempo() { return 0; }

    @Override
    public void resetCreditos(){}
}
