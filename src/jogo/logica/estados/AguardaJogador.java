package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

public class AguardaJogador extends EstadoAdapter {
    public AguardaJogador(Dados modelo){super(modelo);}

    @Override
    public IEstado efetuaJogada(int col) {
        if(getModelo().getModo() == 1){ // modo HvH
            if(getModelo().getJogadas() > 0 && getModelo().getJogadas() % 4 == 0) { // se o numero de jogadas for maior que 0 e multiplo de 4
                return new AguardaMinijogo(getModelo()); // avança para um minijogo
            }
            if(col == (int) 's'){ // se a coluna for especial
                if(getModelo().getEspecial() > 0){ // e o jogador tiver peças especiais
                    return new AguardaJogadorEspecial(getModelo()); // avança para o estado de jogar uma peça especial
                }
                return this;
            }
            if(getModelo().efetuaJogada(col)){ // se a coluna for válida
                if(getModelo().verificaVitoria() || getModelo().tabuleiroCheio()){ // check vitoria ou empate
                   return new AguardaRecomeco(getModelo());
                }
                getModelo().proxJogador(); // muda de jogador
                return new AguardaJogador(getModelo());
            }
            else{
                return new AguardaJogador(getModelo());
            }
        }
        if(getModelo().getModo() == 2){
            if(getModelo().getJogadas() > 0 && getModelo().getJogadas() % 4 == 0) { // se o numero de jogadas for maior que 0 e multiplo de 4
                return new AguardaMinijogo(getModelo()); // avança para um minijogo
            }
            if(col == (int) 's'){ // se a coluna for especial
                if(getModelo().getEspecial() > 0){ // e o jogador tiver peças especiais
                    return new AguardaJogadorEspecial(getModelo()); // avança para o estado de jogar uma peça especial
                }
                return this;
            }
            if(getModelo().efetuaJogada(col)){ // se a coluna for válida
                if(getModelo().verificaVitoria() || getModelo().tabuleiroCheio()){ // check vitoria ou empate
                    return new AguardaRecomeco(getModelo());
                }
                getModelo().proxJogador(); // muda de jogador
                return new AguardaJogadorPC(getModelo());
            }
            else{
                return new AguardaJogador(getModelo());
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
