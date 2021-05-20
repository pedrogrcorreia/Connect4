package jogo.logica.estados;

import jogo.Situacao;
import jogo.logica.dados.Dados;

public class AguardaJogador extends EstadoAdapter{
    public AguardaJogador(Dados modelo){super(modelo);}

    @Override
    public IEstado efetuaJogada(int col) {
        if(getModelo().getJogadas() != 0 && getModelo().getJogadas() == 4){
            return new AguardaMinijogo(getModelo());
        }
        if(getModelo().efetuaJogada(col)){
            if(getModelo().getModo() == 1) {
                if(!getModelo().verificaVitoria()) {
                    return new AguardaJogador(getModelo());
                }
                else{
                    return new AguardaRecomeco(getModelo());
                }
            }
            if(getModelo().getModo() == 2){
                if(!getModelo().verificaVitoria()){
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
        return Situacao.AGUARDA_JOGADOR;
    }
}
