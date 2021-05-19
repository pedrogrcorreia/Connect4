package jogo.logica.dados;

public class JogadorH implements Jogador{
    String nome;
    String ficha;
    public JogadorH(String username){
        nome = username;
        ficha = "X";
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
