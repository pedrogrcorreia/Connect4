package jogo.logica.estados;


import jogo.Situacao;

public interface IEstado {
    IEstado escolherModo(int opt);
    IEstado configurarJogador(String s);
    IEstado efetuaJogada(int col);

    Situacao getSituacaoAtual();
}
