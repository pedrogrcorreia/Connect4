package jogo;

import jogo.logica.dados.Dados;
import jogo.logica.estados.AguardaEscolha;
import jogo.logica.estados.IEstado;

public class Jogo {
    private Dados modelo;
    private IEstado estado;

    public Jogo(){
        modelo = new Dados();
        estado = new AguardaEscolha(modelo);
    }

    public void setEstado(IEstado estado){
        this.estado = estado;
    }

    public void escolherModo(int opc){
        setEstado(estado.escolherModo(opc));
    }

    public void configuraJogador(String s){setEstado(estado.configurarJogador(s));}

    public void efetuaJogada(int col){setEstado(estado.efetuaJogada(col));}
    public void terminaJogoAtual(){
        return;
    }

    public Situacao getSituacaoAtual(){
        return estado.getSituacaoAtual();
    }

    @Override
    public String toString() {
        return modelo.getTabuleiro();
    }
}
