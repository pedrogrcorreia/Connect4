package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

public class AguardaMinijogoResposta extends EstadoAdapter{
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
                return new AguardaMinijogoResposta(getModelo());
            }
        }
        getModelo().proxJogador();
        return new AguardaJogador(getModelo());
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_MINIJOGO_RESPOSTA;
    }
}
