package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

import java.io.Serializable;

public class AguardaRecomeco extends EstadoAdapter implements Serializable {
    public AguardaRecomeco(Dados modelo){super(modelo);}

    @Override
    public IEstado novoJogo() {
        getModelo().terminaJogo();
        return new AguardaEscolha(getModelo());
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_RECOMECO;
    }
}
