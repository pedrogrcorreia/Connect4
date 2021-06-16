package jogo.ui.grafica.estados;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import jogo.logica.JogoObservavel;
import jogo.logica.Situacao;

import static jogo.logica.Properties.*;
import static jogo.logica.Situacao.AGUARDA_JOGADOR1;
import static jogo.logica.Situacao.AGUARDA_JOGADOR2;

public class AguardaJogada extends HBox {
    private JogoObservavel jogoObservavel;
    private Label text;
    private Label jogador;

    public AguardaJogada(JogoObservavel jogoObservavel){
        this.jogoObservavel = jogoObservavel;
        criarJanela();
        registarObserver();
        atualiza();
    }

    private void criarJanela(){
        text = new Label("Jogador a jogar: ");
        setAlignment(Pos.CENTER);
        getChildren().addAll(text);
    }

    private void registarObserver(){
        jogoObservavel.addPropertyChangeListener(JOGO.toString(), event->{
            atualiza();
        });
    }

    private void atualiza(){
        if(jogoObservavel.getSituacaoAtual() == AGUARDA_JOGADOR1){
            text.setText("Jogador 1 a jogar.");
        }
        else{
            text.setText("Jogador 2 a jogar");
        }
        setVisible(jogoObservavel.getSituacaoAtual() == AGUARDA_JOGADOR1 || jogoObservavel.getSituacaoAtual() == AGUARDA_JOGADOR2);
    };
}
