package jogo.logica.estados;


import jogo.Situacao;

public interface IEstado {
    IEstado escolherModo(int opt);
    IEstado configurarJogador(String s);
    IEstado efetuaJogada(int col);
    IEstado efetuaJogadaPC();
    IEstado novoJogo();
    IEstado minijogo(String s);
    IEstado minijogoResposta();

    Situacao getSituacaoAtual();
}
