package jogo.logica.estados;


import jogo.logica.Situacao;

public interface IEstado {
    IEstado escolherModo(int opt);
    IEstado configurarJogador(String s);
    IEstado efetuaJogada(int col);
    IEstado efetuaJogadaPC();
    IEstado efetuaJogadaEspecial(int col);
    IEstado novoJogo();
    IEstado minijogo(String s);
    IEstado minijogoResposta(String resposta);


    Situacao getSituacaoAtual();
}
