package logica;

import logica.dados.Dados;
import logica.estados.EscolheModo;
import logica.estados.IEstado;

public class Jogo {
    private Dados modelo;
    private IEstado estado;

    public Jogo(){
        modelo = new Dados();
        estado = new EscolheModo(modelo);
    }

    void setEstado(IEstado estado){
        this.estado = estado;
    }

    public void escolherModo(int opt){
        setEstado(estado.escolherModo(opt));
    }

    public void configuracao(String s){
        setEstado(estado.configuraJogo(s));
    }

    public void joga(int col){
        setEstado(estado.joga(col));
    }

    public String getTabuleiro(){
        return modelo.getTabuleiro();
    }

    public Situacao getSituacaoAtual(){
        return estado.getSituacaoAtual();
    }

    public void terminaJogoAtual(){
        return;
    }

}
