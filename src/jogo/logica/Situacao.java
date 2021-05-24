package jogo.logica;

import java.io.Serializable;

public enum Situacao implements Serializable {
    ESCOLHE_MODO("Escolher o modo de jogo."),
    AGUARDA_CONFIG("Escolher o nome do jogador."),
    AGUARDA_JOGADOR1("Aguardar jogada do jogador 1."),
    AGUARDA_JOGADOR2("Aguardar jogada do jogador 2."),
    AGUARDA_JOGADORPC("Aguarda jogada do computador."),
    AGUARDA_JOGADOR1_ESPECIAL("Aguarda jogada especial do jogador 1."),
    AGUARDA_JOGADOR2_ESPECIAL("Aguarda jogada especial do jogador 2."),
    AGUARDA_MINIJOGO("Aguardar minijogo."),
    AGUARDA_MINIJOGO_RESPOSTA("Aguardar respostas do minijogo."),
    AGUARDA_RECOMECO("Aguardar recomeço.");

    private final String descricao;
    Situacao(String descricao){ this.descricao = descricao; }


    @Override
    public String toString() {
        return descricao;
    }
}