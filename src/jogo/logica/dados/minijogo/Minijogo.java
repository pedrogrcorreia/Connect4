package jogo.logica.dados.minijogo;

public interface Minijogo {
    void criaJogo();
    String getJogo();
    String getResposta();
    boolean respostaCorreta(String resposta);
    boolean vitoriaMinijogo(int tempo, int respostas);
    boolean continuaMinijogo(int respostas);
}
