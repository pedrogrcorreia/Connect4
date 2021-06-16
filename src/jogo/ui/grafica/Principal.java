package jogo.ui.grafica;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import jogo.logica.JogoObservavel;
import jogo.logica.Situacao;
import jogo.ui.grafica.estados.*;

import static jogo.logica.Properties.JOGO;

public class Principal extends BorderPane {
    private JogoObservavel jogoObservavel;


    public Principal(JogoObservavel jogoObservavel){
        this.jogoObservavel = jogoObservavel;
        criarVista();
        registarObservador();
        atualiza();
    }

    private void registarObservador(){
        jogoObservavel.addPropertyChangeListener(JOGO.toString(), evt -> {
            atualiza();
        });
    }

    private void criarVista(){
        // À esquerda é para meter o tabuleiro
        TabuleiroG tabg = new TabuleiroG(jogoObservavel);
        VBox esquerda = new VBox(10);

        esquerda.getChildren().addAll(tabg);

        // À direita são os botões

        Button undo = new Button("Undo");
        Button especial = new Button("Especial");
        Label jinfo = new Label();
        if(jogoObservavel.getSituacaoAtual() != Situacao.ESCOLHE_MODO && jogoObservavel.getSituacaoAtual() != Situacao.AGUARDA_CONFIG){
            jinfo.setText("Peças especiais: " + jogoObservavel.getEspeciais() + "\nJogadas p/ minijogo: " + jogoObservavel.getJogadas() + "\nCréditos: " + jogoObservavel.getCreditos());
        }
        VBox direita = new VBox(10);
        direita.setAlignment(Pos.CENTER_RIGHT);
        direita.getChildren().addAll(jinfo, undo, especial);

        // central

        HBox central = new HBox(10);
        central.setAlignment(Pos.CENTER);
        central.getChildren().addAll(esquerda, direita);
        setCenter(central);

        // Painel que altera
        AguardaConfig aguardaConfig = new AguardaConfig(jogoObservavel);
        AguardaEscolha aguardaEscolha = new AguardaEscolha(jogoObservavel);
        AguardaJogada aguardaJogada = new AguardaJogada(jogoObservavel);
        AguardaMinijogo aguardaMinijogo = new AguardaMinijogo(jogoObservavel);
        AguardaMinijogoResposta aguardaMinijogoResposta = new AguardaMinijogoResposta(jogoObservavel);
        StackPane bot = new StackPane(aguardaConfig, aguardaEscolha, aguardaJogada, aguardaMinijogo, aguardaMinijogoResposta);
        setBottom(bot);
    }

    private void atualiza(){};
}
