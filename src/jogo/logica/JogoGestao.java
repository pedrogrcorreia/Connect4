package jogo.logica;

import jogo.logica.memento.Caretaker;

import java.io.Serializable;
import java.util.List;

public class JogoGestao implements Serializable {
    private JogoOriginator originator;
    private Caretaker careTaker;

    public JogoGestao(){
        originator = new JogoOriginator();
        careTaker = new Caretaker(originator);
    }

    public void undo(){
        if(originator.getCreditos() > 1) {
            careTaker.undo();
        }
    }

    // delegacao para jogo originator

    public void escolherModo(int opcao) {
        originator.escolherModo(opcao);
    }

    public void terminaJogoAtual() {
        originator.terminaJogoAtual();
    }

    public void configuraJogador(String s) {
        originator.configuraJogador(s);
    }

    public void efetuaJogada(int col) {
        if(col != (int)'s') {
            careTaker.gravaMemento();
        }
        System.out.println(careTaker);
        originator.efetuaJogada(col);
    }

    public void efetuaJogadaPC(){
        careTaker.gravaMemento();
        originator.efetuaJogadaPC();
    }

    public void novoJogo() {
        //careTaker.gravaMemento();
        originator.novoJogo();
    }

    public void minijogo(String s) {
        originator.minijogo(s);
    }

    public String getMinijogo() { return originator.getMiniJogo(); }

    public void minijogoResposta(String resposta){
        originator.minijogoResposta(resposta);
    }


    public Situacao getSituacaoAtual() {
        return originator.getSituacaoAtual();
    }

    @Override
    public String toString() {
        return originator.toString();
    }

    public List getLog() {
        return originator.getLog();
    }


    public void efetuaJogadaEspecial(int col) {
        originator.efetuaJogadaEspecial(col);
    }

    public String getLogJogada() {
        return originator.getLogJogada();
    }
}
