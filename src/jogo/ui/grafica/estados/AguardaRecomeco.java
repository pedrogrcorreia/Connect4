package jogo.ui.grafica.estados;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import jogo.logica.JogoObservavel;
import jogo.logica.Situacao;

import static jogo.logica.Properties.JOGO;

public class AguardaRecomeco extends HBox {
    private JogoObservavel jogoObservavel;

    private Label text;
    private Button novoJogo;
    private Button sair;

    public AguardaRecomeco(JogoObservavel jogoObservavel){
        this.jogoObservavel = jogoObservavel;
        criarJanela();
        registarObserver();
        atualiza();
    }

    private void criarJanela(){
        text = new Label("Jogador a jogar: ");
        novoJogo = new Button("Recomeçar");
        sair = new Button("Sair");

        novoJogo.setOnAction(e->{
            jogoObservavel.novoJogo();
        });

        sair.setOnAction(e->{
            jogoObservavel.terminaJogoAtual();
        });
        setAlignment(Pos.CENTER);
        setSpacing(10);
        getChildren().addAll(text, novoJogo, sair);
    }

    private void registarObserver(){
        jogoObservavel.addPropertyChangeListener(JOGO.toString(), event->{
            atualiza();
        });
    }

    private void atualiza(){
        if(jogoObservavel.getSituacaoAtual() == Situacao.AGUARDA_RECOMECO){
            jogoObservavel.gravarReplay();
            text.setText("Jogador " + jogoObservavel.getJogadorAtual() + " venceu.");
        }
        setVisible(jogoObservavel.getSituacaoAtual() == Situacao.AGUARDA_RECOMECO);
    }
}
