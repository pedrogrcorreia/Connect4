package jogo.logica.dados.minijogo;

import java.io.Serial;
import java.io.Serializable;

public interface IMinijogo extends Serializable {
    @Serial
    long serialVersionUID = 2L;

    void criaJogo();
    String getJogo();
    String getResposta();
    boolean respostaCorreta(String resposta);
    boolean vitoriaMinijogo(int tempo, int respostas);
    boolean continuaMinijogo(int respostas);
}
