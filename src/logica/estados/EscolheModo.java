package logica.estados;

import logica.Situacao;
import logica.dados.Dados;

public class EscolheModo extends EstadoAdapter{
    public EscolheModo(Dados modelo){
        super(modelo);
    }

    @Override
    public IEstado escolherModo(int opt) {
        if(getModelo().escolheModo(opt)){
            return new Configuracao(getModelo());
        }
        return new Jogada(getModelo());
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.ESCOLHE_MODO;
    }
}
