package jogo;

import jogo.logica.JogoGestao;
import jogo.ui.texto.UIText;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JogoGestao jGestao = new JogoGestao();
        UIText uiText = new UIText(jGestao);
        uiText.run();
    }
}
