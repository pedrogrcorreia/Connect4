package jogo.logica.estados;

import jogo.Situacao;
import jogo.logica.dados.Dados;

public class AguardaJogador2 extends EstadoAdapter{
    public AguardaJogador2(Dados modelo){super(modelo);}

    @Override
    public IEstado efetuaJogada(int col) {
        if(getModelo().efetuaJogada(col)){
            return new AguardaJogador1(getModelo());
        }
        return this;
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_JOGADOR2;
    }
}
