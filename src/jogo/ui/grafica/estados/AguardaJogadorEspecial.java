package jogo.ui.grafica.estados;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import jogo.logica.JogoObservavel;

import static jogo.logica.Properties.JOGO;
import static jogo.logica.Situacao.*;

public class AguardaJogadorEspecial extends HBox {
    private JogoObservavel jogoObservavel;
    private Label text;

    public AguardaJogadorEspecial(JogoObservavel jogoObservavel){
        this.jogoObservavel = jogoObservavel;
        criarJanela();
        registarObserver();
        atualiza();
    }

    private void criarJanela(){
        text = new Label();
        setAlignment(Pos.CENTER);
        getChildren().addAll(text);
    }

    private void registarObserver(){
        jogoObservavel.addPropertyChangeListener(JOGO.toString(), event->{
            atualiza();
        });
    }

    private void atualiza(){
        if(jogoObservavel.getSituacaoAtual() == AGUARDA_JOGADOR1_ESPECIAL){
            text.setText("Jogador 1 a efetuar uma jogada especial.");
        }
        else if(jogoObservavel.getSituacaoAtual() == AGUARDA_JOGADOR2_ESPECIAL){
            text.setText("Jogador 2 a efetuar uma jogada especial.");
        }
        setVisible(jogoObservavel.getSituacaoAtual() == AGUARDA_JOGADOR1_ESPECIAL || jogoObservavel.getSituacaoAtual() == AGUARDA_JOGADOR2_ESPECIAL);
    };
}
