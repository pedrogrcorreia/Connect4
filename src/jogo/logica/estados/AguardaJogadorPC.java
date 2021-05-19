package jogo.logica.estados;

import jogo.Situacao;
import jogo.logica.dados.Dados;

public class AguardaJogadorPC extends EstadoAdapter{
    public AguardaJogadorPC(Dados modelo){super(modelo);}

    @Override
    public IEstado efetuaJogadaPC() {
        if(getModelo().efetuaJogadaPC()){
            if(getModelo().getModo() == 2) {
                return new AguardaJogador(getModelo());
            }
            if(getModelo().getModo() == 3){
                return new AguardaJogadorPC(getModelo());
            }
        }
        return this;
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_JOGADORPC;
    }
}
