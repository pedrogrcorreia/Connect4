package jogo.logica.estados;

import jogo.logica.dados.Dados;

public abstract class EstadoAdapter implements IEstado{
    private final Dados modelo;

    public EstadoAdapter(Dados modelo){
        this.modelo = modelo;
    }

    public final Dados getModelo(){
        return modelo;
    }

    @Override
    public IEstado escolherModo(int opc) {
        return this;
    }

    @Override
    public IEstado configurarJogador(String s) {
        return this;
    }

    @Override
    public IEstado efetuaJogada(int col) {
        return this;
    }

    @Override
    public IEstado novoJogo() {
        return this;
    }

    @Override
    public IEstado minijogo(String s){
        return this;
    }

    @Override
    public IEstado minijogoResposta(){
        return this;
    }

    @Override
    public IEstado efetuaJogadaPC() {
        return this;
    }
}
