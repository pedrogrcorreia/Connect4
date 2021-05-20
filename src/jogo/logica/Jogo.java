package jogo.logica;

import jogo.logica.dados.Dados;
import jogo.logica.estados.AguardaEscolha;
import jogo.logica.estados.IEstado;

import java.io.Serializable;
import java.util.List;

public class Jogo implements Serializable {
    private Dados modelo;
    private IEstado estado;

    public Jogo(){
        modelo = new Dados();
        estado = new AguardaEscolha(modelo);
    }

    public void setEstado(IEstado estado){ this.estado = estado;   }

    public void escolherModo(int opc){
        setEstado(estado.escolherModo(opc));
    }

    public void configuraJogador(String s){ setEstado(estado.configurarJogador(s)); }

    public void efetuaJogada(int col){ setEstado(estado.efetuaJogada(col)); }

    public void efetuaJogadaPC(){ setEstado(estado.efetuaJogadaPC()); }

    public void novoJogo(){ setEstado(estado.novoJogo()); }

    public void minijogo(String s){ setEstado(estado.minijogo(s)); }

    public void minijogoResposta(){ setEstado(estado.minijogoResposta()); }

    public void terminaJogoAtual(){
        return;
    }

    public Situacao getSituacaoAtual(){
        return estado.getSituacaoAtual();
    }

    public int getCreditos() { return modelo.getCreditos(); }

    public void removeCreditos(int creditos){ modelo.removeCreditos(creditos); }

    public void resetJogadas(){ modelo.resetJogadas(); }

    public List getLog(){ return modelo.getLog(); }

    @Override
    public String toString() {
        return modelo.getTabuleiro();
    }

    public void mantemJogador(int jogador) {
        modelo.mantemJogador(jogador);
    }

    public int getJogadorAtual() {
        return modelo.getJogadorAtual();
    }
}