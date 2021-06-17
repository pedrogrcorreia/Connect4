package jogo.logica;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import static jogo.logica.Properties.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JogoObservavel {
    private JogoGestao jogoGestao;
    private final PropertyChangeSupport propertyChangeSupport;

    public JogoObservavel(JogoGestao jogoGestao){
        this.jogoGestao = jogoGestao;
        propertyChangeSupport = new PropertyChangeSupport(jogoGestao);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener){
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    // métodos do JogoGestao

    public void escolherModo(int opcao){
        jogoGestao.escolherModo(opcao);
        propertyChangeSupport.firePropertyChange(JOGO.toString(), null, null);
    }

    public void configuraJogador(String s){
        jogoGestao.configuraJogador(s);
        propertyChangeSupport.firePropertyChange(JOGO.toString(), null, null);
    }

    public void efetuaJogada(int col){
        jogoGestao.efetuaJogada(col);
        propertyChangeSupport.firePropertyChange(JOGO.toString(), null, null);
    }

    public void efetuaJogadaEspecial(int col){
        jogoGestao.efetuaJogadaEspecial(col);
        propertyChangeSupport.firePropertyChange(JOGO.toString(), null, null);
    }

    public void efetuaJogadaPC(){
        jogoGestao.efetuaJogadaPC();
        propertyChangeSupport.firePropertyChange(JOGO.toString(), null, null);
    }

    public void novoJogo(){
        jogoGestao.novoJogo();
        propertyChangeSupport.firePropertyChange(JOGO.toString(), null, null);
    }

    public void minijogo(String s){
        jogoGestao.minijogo(s);
        propertyChangeSupport.firePropertyChange(JOGO.toString(), null, null);
    }

    public String getMinijogo(){
        //propertyChangeSupport.firePropertyChange(JOGO.toString(), null, null);
        return jogoGestao.getMinijogo();}

    public void minijogoResposta(String resposta){
        jogoGestao.minijogoResposta(resposta);
        propertyChangeSupport.firePropertyChange(JOGO.toString(), null, null);
    }

    public List<String> getLogJogada(){return jogoGestao.getLogJogada();}

    public List<String> getLogCompleto(){ return jogoGestao.getLogCompleto();}

    public Situacao getSituacaoAtual(){ return jogoGestao.getSituacaoAtual(); }

    public boolean getMinijogoVitoria() { return jogoGestao.getMinijogoVitoria(); }

    public int getEspeciais(){ return jogoGestao.getEspeciais(); }

    public int getJogadas(){ return jogoGestao.getJogadas(); }

    public int getCreditos(){ return jogoGestao.getCreditos(); }

    public String[][] getTabuleiro(){ return jogoGestao.getTabuleiro(); }

    public int getJogadorAtual(){ return jogoGestao.getJogadorAtual(); }

    public void terminaJogoAtual(){
        jogoGestao.terminaJogoAtual();
        propertyChangeSupport.firePropertyChange(JOGO.toString(), null, null);
    }

    public boolean undo(){
        boolean aux;
        aux = jogoGestao.undo();
        propertyChangeSupport.firePropertyChange(JOGO.toString(), null, null);
        return aux;
    }


    // metodos para gravação e recuperação de jogos

    public boolean gravarJogo(File filename){
        Util.gravaJogo(jogoGestao, filename);
        return true;
    }

    public boolean recuperaJogo(File filename) throws IOException, ClassNotFoundException {
        JogoGestao aux = Util.recuperaJogo(filename);
        if(aux != null){
            jogoGestao = aux;
            propertyChangeSupport.firePropertyChange(JOGO.toString(), null, null);
            return true;
        }
        return false;
    }

    public void gravarReplay(){
        if(jogoGestao.getSituacaoAtual() == Situacao.AGUARDA_RECOMECO){
            Util.gravaReplay(jogoGestao);
        }
    }
}
