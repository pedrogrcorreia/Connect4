package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

import java.io.Serializable;

public class AguardaJogadorPC extends EstadoAdapter implements Serializable {
    public AguardaJogadorPC(Dados modelo){super(modelo);}

    @Override
    public IEstado efetuaJogadaPC() {
        if(getModelo().getModo() == 3){ // modo CvC
            if(getModelo().efetuaJogadaPC()){ // se a jogada resultar...
                if(getModelo().verificaVitoria() || getModelo().tabuleiroCheio()) { // em caso de vitoria ou empate
                    return new AguardaRecomeco(getModelo());
                }
                getModelo().proxJogador(); // passar ao proximo jogador PC
                return new AguardaJogadorPC(getModelo());
            }
            return this;
        }
        if(getModelo().getModo() == 2){ // modo HvC
            if(getModelo().efetuaJogadaPC()){
                if(getModelo().verificaVitoria() || getModelo().tabuleiroCheio()){
                    return new AguardaRecomeco(getModelo());
                }
                getModelo().proxJogador(); // passa ao proximo jogador H
                return new AguardaJogador(getModelo());
            }
        }
        return this;
//        if(getModelo().efetuaJogadaPC()){
//            if(getModelo().getModo() == 2) {
//                if(!getModelo().verificaVitoria()) {
//                    return new AguardaJogador(getModelo());
//                }
//                else{
//                    return new AguardaRecomeco(getModelo());
//                }
//            }
//            if(getModelo().getModo() == 3){
//                if(!getModelo().verificaVitoria()) {
//                    return new AguardaJogadorPC(getModelo());
//                }
//                else{
//                    return new AguardaRecomeco(getModelo());
//                }
//            }
//        }
        //return this;
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_JOGADORPC;
    }
}
