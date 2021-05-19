package jogo.logica.estados;

import jogo.Situacao;
import jogo.logica.dados.Dados;

public class AguardaJogador1 extends EstadoAdapter{
    public AguardaJogador1(Dados modelo){super(modelo);}

    @Override
    public IEstado efetuaJogada(int col) {
        if(getModelo().efetuaJogada(col)){
            return new AguardaJogador2(getModelo());
        }
        return this;
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_JOGADOR1;
    }
}
