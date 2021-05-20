package jogo.logica.memento;


import java.io.IOException;

public interface IMementoOriginator {
    IMemento getMemento() throws IOException;
    void setMemento(IMemento m) throws IOException, ClassNotFoundException;
}
