package jogo.logica.estados;

import jogo.Situacao;
import jogo.logica.dados.Dados;

public class AguardaJogador extends EstadoAdapter{
    public AguardaJogador(Dados modelo){super(modelo);}

    @Override
    public IEstado efetuaJogada(int col) {
        if(getModelo().efetuaJogada(col)){
            if(getModelo().getModo() == 1) {
                return new AguardaJogador(getModelo());
            }
            if(getModelo().getModo() == 2){
                return new AguardaJogadorPC(getModelo());
            }
        }
        return this;
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_JOGADOR;
    }
}
