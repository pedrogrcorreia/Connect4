package jogo.logica.estados;

import jogo.Situacao;
import jogo.logica.dados.Dados;

public class AguardaEscolha extends EstadoAdapter{
    public AguardaEscolha(Dados modelo){
        super(modelo);
    }

    @Override
    public IEstado escolherModo(int opc) {
        if(opc == 1 || opc == 2){
            getModelo().escolheModo(opc);
            return new AguardaConfJogador1(getModelo());
        }
        if(opc == 3){
            getModelo().escolheModo(opc);
            return new AguardaJogadorPC(getModelo());
        }
        return new AguardaEscolha(getModelo());
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.ESCOLHE_MODO;
    }
}
