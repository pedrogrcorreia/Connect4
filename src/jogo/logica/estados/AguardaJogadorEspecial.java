package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

public class AguardaJogadorEspecial extends EstadoAdapter{
    public AguardaJogadorEspecial(Dados modelo){ super(modelo); }

    @Override
    public IEstado efetuaJogadaEspecial(int col) {
        if(getModelo().getEspecial() == 0){
            return new AguardaJogador(getModelo());
        }
        else{
            if(getModelo().efetuaJogadaEspecial(col)){
                return new AguardaJogador(getModelo());
            }
            else{
                return new AguardaJogadorEspecial(getModelo());
            }
        }
    }

    @Override
    public Situacao getSituacaoAtual() {
        if(getModelo().getJogadorAtual() == 1) {
            return Situacao.AGUARDA_JOGADOR1_ESPECIAL;
        }
        else{
            return Situacao.AGUARDA_JOGADOR2_ESPECIAL;
        }
    }
}
