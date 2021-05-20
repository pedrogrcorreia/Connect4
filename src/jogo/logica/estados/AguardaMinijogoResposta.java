package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

public class AguardaMinijogoResposta extends EstadoAdapter{
    public AguardaMinijogoResposta(Dados modelo){super(modelo);}

    @Override
    public IEstado minijogoResposta() {
        if(getModelo().getMinijogo()){
            return new AguardaMinijogoResposta(getModelo());
        }
        return new AguardaMinijogoResposta(getModelo());
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_MINIJOGO_RESPOSTA;
    }
}
