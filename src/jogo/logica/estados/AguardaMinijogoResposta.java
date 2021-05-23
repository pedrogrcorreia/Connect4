package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

import java.io.Serializable;

public class AguardaMinijogoResposta extends EstadoAdapter implements Serializable {
    public AguardaMinijogoResposta(Dados modelo){super(modelo);}

    @Override
    public IEstado minijogoResposta(String resposta) {
        if(getModelo().getModo() == 1) { // se o modo for o HvH
            if (getModelo().minijogoResposta(resposta)) { // se acertou
                if (getModelo().continuaMinijogo()) { // se o jogo é para continuar (matemática)
                    return new AguardaMinijogoResposta(getModelo());
                }
                if (getModelo().minijogoVitoria()) { // se ganhou
                    getModelo().mudaMinijogo(); // mudar o minijogo para o jogador atual
                    getModelo().atribuiEspecial(); // atribuir a peça especial
                    getModelo().incrementaJogadas(); // incrementa o numero de jogadas
                    getModelo().resetRespostas(); // faz o reset das respostas
                    return new AguardaJogador(getModelo()); // novo estado
                } else { // se perdeu (tempo excedido)
                    getModelo().mudaMinijogo(); // so nao atribui a peça especial
                    getModelo().incrementaJogadas();
                    getModelo().resetRespostas();
                    getModelo().proxJogador(); // passa ao proximo jogador porque perdeu
                    return new AguardaJogador(getModelo());
                }
            } // se errou
            getModelo().mudaMinijogo();
            getModelo().incrementaJogadas();
            getModelo().resetRespostas();
            getModelo().proxJogador(); // passa ao proximo jogador porque perdeu
            return new AguardaJogador(getModelo());
        }
        else { // se o modo for HvC
            if (getModelo().minijogoResposta(resposta)) { // se acertou
                if (getModelo().continuaMinijogo()) { // se o jogo é para continuar (matemática)
                    return new AguardaMinijogoResposta(getModelo());
                }
                if (getModelo().minijogoVitoria()) { // se ganhou
                    getModelo().mudaMinijogo(); // mudar o minijogo para o jogador atual
                    getModelo().atribuiEspecial(); // atribuir a peça especial
                    getModelo().incrementaJogadas(); // incrementa o numero de jogadas
                    getModelo().resetRespostas(); // faz o reset das respostas
                    return new AguardaJogadorPC(getModelo()); // novo estado
                } else { // se perdeu (tempo excedido)
                    getModelo().mudaMinijogo(); // nao atribui a peça especial
                    getModelo().incrementaJogadas();
                    getModelo().resetRespostas();
                    getModelo().proxJogador(); // passa ao proximo jogador
                    return new AguardaJogadorPC(getModelo());
                }
            } // se errou
            getModelo().mudaMinijogo();
            getModelo().incrementaJogadas();
            getModelo().resetRespostas();
            getModelo().proxJogador(); // passa ao proximo jogador
            return new AguardaJogadorPC(getModelo());
        }
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_MINIJOGO_RESPOSTA;
    }
}
