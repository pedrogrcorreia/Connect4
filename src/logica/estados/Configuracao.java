package logica.estados;

import logica.Situacao;
import logica.dados.Dados;

public class Configuracao extends EstadoAdapter{
    public Configuracao(Dados modelo){
        super(modelo);
    }

    @Override
    public IEstado configuraJogo(String s) {
        if(getModelo().configuraJogo(s)){
            return new Jogada(getModelo());
        }
        return new Configuracao(getModelo());
    }

    @Override
    public Situacao getSituacaoAtual() {
        return Situacao.CONFIGURACAO;
    }
}
