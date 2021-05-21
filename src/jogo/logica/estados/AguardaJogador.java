package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

public class AguardaJogador extends EstadoAdapter{
    public AguardaJogador(Dados modelo){super(modelo);}

    @Override
    public IEstado efetuaJogada(int col) {
//        if(getModelo().efetuaJogada(col)){
//            if(getModelo().getModo() == 1) {
//                if(!getModelo().verificaVitoria()) {
//                    if(getModelo().getJogadas() != 0 && getModelo().getJogadas() != 4) {
//                        getModelo().proxJogador();
//                        return new AguardaJogador(getModelo());
//                    }
//                    if(getModelo().getJogadas() != 0 && (getModelo().getJogadas() % 4) == 0){
//                        return new AguardaMinijogo(getModelo());
//                    }
//                }
//                else{
//                    return new AguardaRecomeco(getModelo());
//                }
//            }
//            if(getModelo().getModo() == 2){
//                if(!getModelo().verificaVitoria()){
//                    getModelo().proxJogador();
//                    return new AguardaJogadorPC(getModelo());
//                }
//                else{
//                    return new AguardaRecomeco(getModelo());
//                }
//            }
//        }
//        return this;
        if(getModelo().getModo() == 1) {
            if(col == 9){
                return new AguardaJogadorEspecial(getModelo());
            }
            if (!getModelo().efetuaJogada(col)) {
                return this;
            }
            else {
                if (!getModelo().verificaVitoria()) {
                    return new AguardaJogador(getModelo());
                }
                else {
                    return new AguardaRecomeco(getModelo());
                }
            }
        }
        return this;
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
