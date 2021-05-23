package jogo.logica;

import jogo.logica.memento.IMemento;
import jogo.logica.memento.IMementoOriginator;

import java.io.*;
import java.util.List;

public class JogoOriginator implements IMementoOriginator, Serializable {
    Jogo jogo;

    public JogoOriginator(){
        this.jogo = new Jogo();
    }

    @Override
    public IMemento getMemento() throws IOException {
        Memento m = new Memento();
        m.setSnapshot(jogo);
        return m;
    }

    @Override
    public void setMemento(IMemento m) throws IOException, ClassNotFoundException {
        Jogo a = jogo;
        Memento aux = (Memento) m;
        Object obj = aux.getSnapshot();
        jogo = (Jogo) obj;
        if(jogo != null) {
            jogo.mantemJogador(a.getJogadorAtual());
            jogo.removeCreditos(a.getCreditos());
            jogo.resetJogadas();
            jogo.efetuaJogada(0);
        }
    }

    public void escolherModo(int opcao) {
        jogo.escolherModo(opcao);
    }

    public void terminaJogoAtual() {
        jogo.terminaJogoAtual();
    }

    public void configuraJogador(String s) {
        jogo.configuraJogador(s);
    }

    public void efetuaJogada(int col) {
        jogo.efetuaJogada(col);
    }

    public void efetuaJogadaPC() {
        jogo.efetuaJogadaPC();
    }

    public void novoJogo() {
        jogo.novoJogo();
    }

    public void minijogo(String s) {
        jogo.minijogo(s);
    }

    public void minijogoResposta(String resposta){ jogo.minijogoResposta(resposta); }

    public Situacao getSituacaoAtual() {
        return jogo.getSituacaoAtual();
    }

    public String getTabuleiro() { return jogo.getTabuleiro();}

    @Override
    public String toString() {
        return jogo.toString();
    }

    public int getCreditos() {
        return jogo.getCreditos();
    }

    public String getMiniJogo() { return jogo.getMinijogo(); }


    public void efetuaJogadaEspecial(int col) {
        jogo.efetuaJogadaEspecial(col);
    }

    public List<String> getLogJogada() {
        return jogo.getLogJogada();
    }

    public List<String> getLogCompleto() {
        return jogo.getLogCompleto();
    }

    private static class Memento implements IMemento, Serializable { //Memento genérico que dá para tudo quando se recorre a serialização ...
        private byte[] snapshot = null;  // null para marcar a posição do programador

        // as seguintes NÃO SÃO @Overrides
        // são uma interface "wider" (extensão) daquila que a interface anuncia
        void setSnapshot(Object obj) throws IOException {
            ByteArrayOutputStream baos;
            ObjectOutputStream oos = null;
            try {
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(obj);
                snapshot = baos.toByteArray();
            } finally {
                if (oos != null) {
                    oos.close();
                }
            }
        }

        Object getSnapshot() throws IOException, ClassNotFoundException {
            ObjectInputStream ois = null;
            if (snapshot == null)
                return null;
            try {
                ois = new ObjectInputStream(new ByteArrayInputStream(snapshot));
                return ois.readObject();
            } finally {
                if(ois!=null){
                    ois.close();
                }
            }
        }
    }
}
