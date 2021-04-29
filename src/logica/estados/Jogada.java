package logica.estados;

import logica.Situacao;
import logica.dados.Dados;

public class Jogada extends EstadoAdapter{
    public Jogada(Dados modelo){
        super(modelo);
    }

    @Override
    public IEstado joga(int col) {
        return new EscolheModo(getModelo());
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.JOGADA;
    }
}
