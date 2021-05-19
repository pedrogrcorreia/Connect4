package jogo.logica.estados;

import jogo.Situacao;
import jogo.logica.dados.Dados;

public class AguardaRecomeco extends EstadoAdapter{
    public AguardaRecomeco(Dados modelo){super(modelo);}

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_RECOMECO;
    }
}
