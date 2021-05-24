package jogo.logica.memento;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;

public class Caretaker implements Serializable {

    private IMementoOriginator originator;

    private Deque<IMemento> stackHist = new ArrayDeque<>();
    private Deque<IMemento> stackRedo = new ArrayDeque<>();

    public Caretaker(IMementoOriginator org) {
        this.originator = org;
    }

    public void gravaMemento() {
        stackRedo.clear();
        try{
            stackHist.push(originator.getMemento());
        } catch(IOException ex) {
            System.out.println("gravaMemento: " + ex);
            stackHist.clear();
        }
    }

    public void undo() {
        if (stackHist.isEmpty()) {
            return;
        }

        try {
            IMemento atual = originator.getMemento();
            stackRedo.push(atual);
            IMemento anterior = stackHist.pop();
            originator.setMemento(anterior);
        } catch(IOException | ClassNotFoundException ex) {
            System.out.println("undo: " + ex);
            stackHist.clear();
            stackRedo.clear();
        }

    }

    public void redo() {
        if (stackRedo.isEmpty()) {
            return;
        }

        try {
            IMemento sredo = stackRedo.pop();
            stackHist.push(originator.getMemento());
            originator.setMemento(sredo);
        } catch(IOException | ClassNotFoundException ex) {
            System.out.println("redo: " + ex);
            stackHist.clear();
            stackRedo.clear();
        }
    }

    // metodos que consultam
    // isto é só para debug
//    public String toString(){
//        return "\nstackHist=" + stackHist.size() +
//                "\nstackRedo=" + stackRedo.size();
//    }

}