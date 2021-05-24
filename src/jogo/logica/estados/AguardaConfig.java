package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

import java.io.Serializable;

public class AguardaConfig extends EstadoAdapter {
    public AguardaConfig(Dados modelo){super(modelo);}

    @Override
    public IEstado configurarJogador(String s) {
        if(getModelo().getModo() == 1){
            if(!getModelo().configuraJogador(s)) {
                return new AguardaConfig(getModelo());
            }
            else{
                return new AguardaJogador(getModelo());
            }
        }
        if(getModelo().getModo() == 2){
            if(getModelo().configuraJogador(s)) {
                return new AguardaJogador(getModelo());
            }
        }
        return this;
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.AGUARDA_CONFIG;
    }
}
