package jogo.logica.dados;

public class JogadorH implements Jogador{
    String nome;
    String ficha;
    public JogadorH(String username, String ficha){
        nome = username;
        this.ficha = ficha;
    }

    @Override
    public int getCol() {
        return 0;
    }

    @Override
    public String getFicha(){
        return ficha;
    }

    @Override
    public String getNome() {
        return nome;
    }
}
