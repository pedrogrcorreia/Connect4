package jogo;

public enum Situacao {
    ESCOLHE_MODO("Escolher o modo de jogo."),
    CONFIGURA_JOGADOR1("Escolher o nome do jogador 1."),
    CONFIGURA_JOGADOR2("Escolher o nome do jogador 2."),
    AGUARDA_JOGADOR1("Aguardar jogada do jogador 1."),
    AGUARDA_JOGADOR2("Aguardar jogada do jogador 2."),
    AGUARDA_JOGADORPC("Aguarda jogada do computador."),
    AGUARDA_MINIJOGO("Aguardar minijogo."),
    AGUARDA_RECOMECO("Aguardar recomeço.");

    private final String descricao;
    Situacao(String descricao){this.descricao = descricao;}


    @Override
    public String toString() {
        return descricao;
    }
}