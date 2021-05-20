package jogo.logica.dados;

public class JogadorH implements Jogador{
    String nome;
    String ficha;
    private int colJogada;
    private int jogadas;
    private int special;

    public JogadorH(String username, String ficha){
        nome = username;
        this.ficha = ficha;
        jogadas = 0;
    }

    @Override
    public int getCol() {
        return colJogada;
    }

    @Override
    public void addCol(int col){
        colJogada = col;
    }

    @Override
    public String getFicha(){
        return ficha;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void incrementaJogadas() {
        ++jogadas;
    }

    @Override
    public int getJogadas() {
        return jogadas;
    }
}
