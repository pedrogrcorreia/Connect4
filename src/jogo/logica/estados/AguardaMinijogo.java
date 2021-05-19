package jogo.logica.estados;

import jogo.Situacao;
import jogo.logica.dados.Dados;

public class AguardaMinijogo extends EstadoAdapter{
    public AguardaMinijogo(Dados modelo){super(modelo);}

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_MINIJOGO;
    }
}
