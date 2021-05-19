package jogo.logica.estados;

import jogo.Situacao;
import jogo.logica.dados.Dados;

public class AguardaJogadorPC extends EstadoAdapter{
    public AguardaJogadorPC(Dados modelo){super(modelo);}

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_JOGADORPC;
    }
}
