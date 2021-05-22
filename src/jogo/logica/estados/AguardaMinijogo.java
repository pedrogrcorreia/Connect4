package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

import java.io.Serializable;

public class AguardaMinijogo extends EstadoAdapter implements Serializable {
    public AguardaMinijogo(Dados modelo){super(modelo);}

    @Override
    public IEstado minijogo(String s) {
        if(getModelo().minijogo(s)){
            return new AguardaMinijogoResposta(getModelo());
        }
        getModelo().proxJogador();
        return new AguardaJogador(getModelo());
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_MINIJOGO;
    }
}
