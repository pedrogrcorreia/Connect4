package logica.estados;

import logica.Situacao;

public interface IEstado {
    IEstado escolherModo(int opt);
    IEstado configuraJogo(String s);
    IEstado joga(int col);
    Situacao getSituacaoAtual();
}
