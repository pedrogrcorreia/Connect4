package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

import java.io.Serializable;

public class AguardaMinijogoResposta extends EstadoAdapter implements Serializable {
    public AguardaMinijogoResposta(Dados modelo){super(modelo);}

    @Override
    public IEstado minijogoResposta(String resposta) {
        if(getModelo().minijogoResposta(resposta)){
            if(getModelo().getRespostas() < 5) {
                return new AguardaMinijogoResposta(getModelo());
            }
            else{
                getModelo().mudaMinijogo();
                getModelo().atribuiEspecial();
                getModelo().incrementaJogadas();
                getModelo().resetRespostas();
                getModelo().proxJogador();
                return new AguardaJogador(getModelo());
            }
        }
        getModelo().resetRespostas();
        getModelo().incrementaJogadas();
        getModelo().proxJogador(); // se perder o minijogo passa para o seguinte
        return new AguardaJogador(getModelo());
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_MINIJOGO_RESPOSTA;
    }
}
