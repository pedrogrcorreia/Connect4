package jogo.logica.estados;

import jogo.logica.Situacao;

import java.io.Serial;
import java.io.Serializable;

public interface IEstado extends Serializable {
    @Serial
    long serialVersionUID = 5L;

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
