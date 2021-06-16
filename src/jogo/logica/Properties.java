package jogo.logica;

public enum Properties {
    NOVO_JOGO("novo jogo"),
    CONFIG("configura jogador"),
    MODO("modo escolhido"),
    JOGO("Jogada"),
    CARREGAR_JOGO("carregar jogo"),
    ESTADO("Estado");
    private final String descricao;
    Properties(String s){ descricao = s;}
    @Override
    public String toString(){return descricao;};
}
