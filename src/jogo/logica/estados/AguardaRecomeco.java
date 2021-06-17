package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

public class AguardaRecomeco extends EstadoAdapter {
    public AguardaRecomeco(Dados modelo){super(modelo);}

    @Override
    public IEstado novoJogo() {
        getModelo().terminaJogoAtual();
        if(getModelo().getModo() == 1 || getModelo().getModo() == 2) {
            return new AguardaJogador(getModelo());
        }
        else{
            return new AguardaJogadorPC(getModelo());
        }
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_RECOMECO;
    }
}
