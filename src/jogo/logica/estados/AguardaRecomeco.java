package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

public class AguardaRecomeco extends EstadoAdapter{
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
