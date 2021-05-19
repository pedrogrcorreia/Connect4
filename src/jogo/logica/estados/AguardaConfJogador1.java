package jogo.logica.estados;

import jogo.Situacao;
import jogo.logica.dados.Dados;

public class AguardaConfJogador1 extends EstadoAdapter{
    public AguardaConfJogador1(Dados modelo){
        super(modelo);
    }

    @Override
    public IEstado configurarJogador(String s) {
        if(getModelo().configuraJogador(s)){
            return new AguardaConfJogador2(getModelo());
        }
        if(!getModelo().configuraJogador(s)){
            if(getModelo().iniciaJogo()) {
                return new AguardaJogador1(getModelo());
            }
        }
        return this;
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.CONFIGURA_JOGADOR1;
    }
}
