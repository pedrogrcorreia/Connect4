package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

public class AguardaJogadorPC extends EstadoAdapter{
    public AguardaJogadorPC(Dados modelo){super(modelo);}

    @Override
    public IEstado efetuaJogadaPC() {
        if(getModelo().efetuaJogadaPC()){
            if(getModelo().getModo() == 2) {
                if(!getModelo().verificaVitoria()) {
                    return new AguardaJogador(getModelo());
                }
                else{
                    return new AguardaRecomeco(getModelo());
                }
            }
            if(getModelo().getModo() == 3){
                if(!getModelo().verificaVitoria()) {
                    return new AguardaJogadorPC(getModelo());
                }
                else{
                    return new AguardaRecomeco(getModelo());
                }
            }
        }
        return this;
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_JOGADORPC;
    }
}
