package jogo.logica;

import jogo.logica.dados.Dados;
import jogo.logica.dados.Tabuleiro;
import jogo.logica.estados.*;
import jogo.logica.estados.IEstado;
import jogo.logica.estados.AguardaEscolha;


import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Jogo implements Serializable {
    @Serial
    private static final long serialVersionUID = 7L;

    private Dados modelo;
    private IEstado estado;

    public Jogo(){
        modelo = new Dados();
        modelo.iniciaJogo();
        estado = new AguardaJogador(modelo);
    }

    private void setEstado(IEstado estado){ this.estado = estado; }

    public void escolherModo(int opc){
        setEstado(estado.escolherModo(opc));
    }

    public void configuraJogador(String s){ setEstado(estado.configurarJogador(s)); }

    public void efetuaJogada(int col){ setEstado(estado.efetuaJogada(col)); }

    public void efetuaJogadaEspecial(int col) { setEstado(estado.efetuaJogadaEspecial(col)); }

    public void efetuaJogadaPC(){ setEstado(estado.efetuaJogadaPC()); }

    public void novoJogo(){ setEstado(estado.novoJogo()); }

    public void minijogo(String s){ setEstado(estado.minijogo(s)); }

    public String getMinijogo() { return modelo.getMinijogo(); }

    public void minijogoResposta(String resposta){ setEstado(estado.minijogoResposta(resposta)); }

    public void removeCreditos(int creditos){ modelo.removeCreditos(creditos); }

    public void resetJogadas(){ modelo.resetJogadas(); }

    public void mantemJogador(int jogador) {
        modelo.mantemJogador(jogador);
    }

    public int getCreditos() { return modelo.getCreditos(); }

    public int getJogadorAtual() {
        return modelo.getJogadorAtual();
    }

    public boolean getMinijogoVitoria() { return modelo.minijogoVitoria(); }

    public int getEspeciais(){ return modelo.getEspecial(); }

    public int getJogadas(){ return modelo.getJogadas(); }

    public String[][] getTabuleiro(){ return modelo.getTabuleiro(); }

    public List<String> getLogJogada(){ return modelo.getLogJogada(); }

    public List<String> getLogCompleto(){ return modelo.getLogCompleto(); }

    public Situacao getSituacaoAtual(){ return estado.getSituacaoAtual(); }
}
