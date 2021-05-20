package jogo;

import jogo.logica.dados.Dados;

public enum Situacao {
    ESCOLHE_MODO("Escolher o modo de jogo."),
    AGUARDA_CONFIG("Escolher o nome do jogador."),
    AGUARDA_JOGADOR("Aguardar jogada do jogador "),
    AGUARDA_JOGADORPC("Aguarda jogada do computador."),
    AGUARDA_MINIJOGO("Aguardar minijogo."),
    AGUARDA_MINIJOGO_RESPOSTA("Aguardar respostas do minijogo."),
    AGUARDA_RECOMECO("Aguardar recomeço.");

    private final String descricao;
    Situacao(String descricao){this.descricao = descricao;}


    @Override
    public String toString() {
        return descricao;
    }
}