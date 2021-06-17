package jogo.ui.grafica.estados;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import jogo.logica.JogoObservavel;

import static jogo.logica.Properties.*;
import static jogo.logica.Situacao.AGUARDA_JOGADOR1;
import static jogo.logica.Situacao.AGUARDA_JOGADOR2;

public class AguardaJogadorP extends HBox {
    private JogoObservavel jogoObservavel;
    private Label text;

    public AguardaJogadorP(JogoObservavel jogoObservavel){
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
        if(jogoObservavel.getSituacaoAtual() == AGUARDA_JOGADOR1){
            text.setText("Jogador 1 a jogar.");
        }
        else if(jogoObservavel.getSituacaoAtual() == AGUARDA_JOGADOR2){
            text.setText("Jogador 2 a jogar");
        }
        setVisible(jogoObservavel.getSituacaoAtual() == AGUARDA_JOGADOR1 || jogoObservavel.getSituacaoAtual() == AGUARDA_JOGADOR2);
    };
}
