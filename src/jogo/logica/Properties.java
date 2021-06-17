package jogo.logica;

public enum Properties {
    JOGO("Jogo");
    private final String descricao;
    Properties(String s){ descricao = s;}
    @Override
    public String toString(){return descricao;};
}
