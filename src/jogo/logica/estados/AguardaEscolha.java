package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

import java.io.Serializable;

public class AguardaEscolha extends EstadoAdapter implements Serializable {
    public AguardaEscolha(Dados modelo){
        super(modelo);
    }

    @Override
    public IEstado escolherModo(int opc) {
        getModelo().escolheModo(opc);
        if(getModelo().getModo() == 1 || getModelo().getModo() == 2){
            return new AguardaConfig(getModelo());
        }
        if(getModelo().getModo() == 3){
            getModelo().configuraJogador("");
            return new AguardaJogadorPC(getModelo());
        }
        return this;
//        if(opc == 1 || opc == 2){
//            getModelo().escolheModo(opc);
//            return new AguardaConfig(getModelo());
//        }
//        if(opc == 3){
//            getModelo().escolheModo(opc);
//            getModelo().configuraJogador("");
//            return new AguardaJogadorPC(getModelo());
//        }
//        return new AguardaEscolha(getModelo());
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.ESCOLHE_MODO;
    }
}
