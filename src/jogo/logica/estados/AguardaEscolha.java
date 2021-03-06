package jogo.logica.estados;

import jogo.logica.Situacao;
import jogo.logica.dados.Dados;

public class AguardaEscolha extends EstadoAdapter {
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
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.ESCOLHE_MODO;
    }
}
