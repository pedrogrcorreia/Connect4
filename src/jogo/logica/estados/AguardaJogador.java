package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

import java.io.Serializable;

public class AguardaJogador extends EstadoAdapter implements Serializable {
    public AguardaJogador(Dados modelo){super(modelo);}

    @Override
    public IEstado efetuaJogada(int col) {
        if(getModelo().getModo() == 1){
            if(col == (int) 's'){
                if(getModelo().getEspecial() > 0){
                    return new AguardaJogadorEspecial(getModelo());
                }
                else{
                    return this;
                }
            }
            if(getModelo().efetuaJogada(col)){
                if(!getModelo().verificaVitoria()){
                    if(getModelo().getJogadas() > 0 && getModelo().getJogadas() % 4 == 0){
                        return new AguardaMinijogo(getModelo());
                    }
                    getModelo().proxJogador();
                    return new AguardaJogador(getModelo());
                }
            }
        }
        if(getModelo().getModo() == 2){
            if(col == (int) 's'){
                if(getModelo().getEspecial() > 0){
                    return new AguardaJogadorEspecial(getModelo());
                }
                else{
                    return this;
                }
            }
            if(getModelo().getJogadas() > 0 && getModelo().getJogadas() % 4 == 0){
                return new AguardaMinijogo(getModelo());
            }
            if(getModelo().efetuaJogada(col)){
                if(!getModelo().verificaVitoria()){
                    getModelo().proxJogador();
                    return new AguardaJogadorPC(getModelo());
                }
            }
        }
        return this;

        //// TESTEEEE
//        if(getModelo().getModo() == 1) {
//            if(col == (int) 's'){
//                if(getModelo().getEspecial() > 0) {
//                    return new AguardaJogadorEspecial(getModelo());
//                }
//                else{
//                    return this;
//                }
//            }
//            if (!getModelo().efetuaJogada(col)) {
//                return this;
//            }
//            else {
//                if (!getModelo().verificaVitoria()) {
//                    getModelo().proxJogador();
//                    return new AguardaJogador(getModelo());
//                }
//                else {
//                    return new AguardaRecomeco(getModelo());
//                }
//            }
//        }
//        return this;
    }

    @Override
    public Situacao getSituacaoAtual() {
        if(getModelo().getJogadorAtual() == 1) {
            return Situacao.AGUARDA_JOGADOR1;
        }
        else{
            return Situacao.AGUARDA_JOGADOR2;
        }
    }
}
