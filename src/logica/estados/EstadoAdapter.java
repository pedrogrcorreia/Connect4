package logica.estados;

import logica.dados.Dados;

public abstract class EstadoAdapter implements IEstado {
    private final Dados modelo;

    public EstadoAdapter(Dados modelo){
        this.modelo = modelo;
    }

    public final Dados getModelo(){
        return modelo;
    }

    @Override
    public IEstado escolherModo(int opt) {
        return this;
    }

    @Override
    public IEstado configuraJogo(String s) {
        return this;
    }

    @Override
    public IEstado joga(int col) {
        return this;
    }
}
