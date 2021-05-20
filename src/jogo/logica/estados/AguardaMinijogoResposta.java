package jogo.logica.estados;

import jogo.Situacao;
import jogo.logica.dados.Dados;

public class AguardaMinijogoResposta extends EstadoAdapter{
    public AguardaMinijogoResposta(Dados modelo){super(modelo);}

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_MINIJOGO_RESPOSTA;
    }
}
