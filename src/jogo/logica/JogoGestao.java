package jogo.logica;

import jogo.logica.memento.Caretaker;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class JogoGestao implements Serializable {
    @Serial
    private static final long serialVersionUID = 8L;

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

    public void escolherModo(int opcao) {
        originator.escolherModo(opcao);
    }

    public void configuraJogador(String s) {
        originator.configuraJogador(s);
    }

    public void efetuaJogada(int col) {
        if(col != (int)'s') {
            careTaker.gravaMemento();
        }
        originator.efetuaJogada(col);
    }

    public void efetuaJogadaEspecial(int col) {
        originator.efetuaJogadaEspecial(col);
    }

    public void efetuaJogadaPC(){
        careTaker.gravaMemento();
        originator.efetuaJogadaPC();
    }

    public void novoJogo() {
        originator.novoJogo();
    }

    public void minijogo(String s) {
        originator.minijogo(s);
    }

    public String getMinijogo() { return originator.getMiniJogo(); }

    public void minijogoResposta(String resposta){
        originator.minijogoResposta(resposta);
    }

    public List<String> getLogJogada() {
        return originator.getLogJogada();
    }

    public List<String> getLogCompleto(){ return originator.getLogCompleto(); }

    public Situacao getSituacaoAtual() {
        return originator.getSituacaoAtual();
    }

}
