package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

public class AguardaJogadorEspecial extends EstadoAdapter {
    public AguardaJogadorEspecial(Dados modelo){ super(modelo); }

    @Override
    public IEstado efetuaJogadaEspecial(int col) {
        if(getModelo().getEspecial() == 0){ // se não tiver peças especiais -> condicao de tras falhou?
            return new AguardaJogador(getModelo()); // volta para a jogada normal
        }
        else{
            if(getModelo().efetuaJogadaEspecial(col)){ // se inserir uma coluna válida
                return new AguardaJogador(getModelo()); // joga o mesmo jogador
            }
            else{
                return new AguardaJogadorEspecial(getModelo()); // nao inseriu uma coluna válida volta a tentar
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
