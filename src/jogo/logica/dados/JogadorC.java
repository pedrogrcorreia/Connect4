package jogo.logica.dados;

public class JogadorC implements Jogador{
    private String nome;
    static private int id;

    public JogadorC(){
        nome = "Artifical " + id++;
    }

    @Override
    public boolean joga(int col) {
        return true;
    }

    @Override
    public String getNome() {
        return nome;
    }
}
