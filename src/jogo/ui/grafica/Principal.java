package jogo.ui.grafica;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import jogo.logica.JogoObservavel;
import jogo.logica.Situacao;
import jogo.ui.grafica.estados.*;

import static jogo.logica.Properties.JOGO;

public class Principal extends BorderPane {
    private JogoObservavel jogoObservavel;
    private VBox direita;
    private VBox esquerda;
    private HBox central;
    private Label jinfo;

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
        // esquerda é o tabuleiro
        TabuleiroG tabg = new TabuleiroG(jogoObservavel);
        esquerda = new VBox(10);

        esquerda.getChildren().addAll(tabg);
        esquerda.setPadding(new Insets(25, 0, 10, 0));


        // direita são os botões + texto

        Button undo = new Button("Undo");
        Button especial = new Button("Especial");
        jinfo = new Label();
        jinfo.setText("Peças especiais:\nJogadas p/ minijogo:\nCréditos:");
        direita = new VBox(10);
        direita.setAlignment(Pos.CENTER_RIGHT);
        direita.getChildren().addAll(jinfo, undo, especial);
        direita.setPrefWidth(200);
        undo.setOnAction(e->{
            if(!jogoObservavel.undo()){
                Alert msgBox = new Alert(Alert.AlertType.ERROR);
                msgBox.setHeaderText("Créditos");
                msgBox.setContentText("Não tem créditos para poder voltar atrás");
                msgBox.showAndWait();
            }
        });

        especial.setOnAction(e-> jogoObservavel.efetuaJogada('s'));

        // central

        central = new HBox(10);
        central.setAlignment(Pos.CENTER);
        central.getChildren().addAll(esquerda, direita);
        setCenter(central);

        // Painel que altera
        AguardaConfig aguardaConfig = new AguardaConfig(jogoObservavel);
        AguardaEscolha aguardaEscolha = new AguardaEscolha(jogoObservavel);
        AguardaJogador aguardaJogador = new AguardaJogador(jogoObservavel);
        AguardaMinijogo aguardaMinijogo = new AguardaMinijogo(jogoObservavel);
        AguardaMinijogoResposta aguardaMinijogoResposta = new AguardaMinijogoResposta(jogoObservavel);
        AguardaRecomeco aguardaRecomeco = new AguardaRecomeco(jogoObservavel);
        AguardaJogadorPC aguardaJogadorPC = new AguardaJogadorPC(jogoObservavel);
        AguardaJogadorEspecial aguardaJogadorEspecial = new AguardaJogadorEspecial(jogoObservavel);
        StackPane bot = new StackPane(aguardaConfig, aguardaEscolha, aguardaJogador, aguardaMinijogo, aguardaMinijogoResposta, aguardaRecomeco, aguardaJogadorPC, aguardaJogadorEspecial);
        setBottom(bot);
        bot.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
        bot.setPadding(new Insets(10, 10, 10, 10));
    }

    private void atualiza(){
        if(jogoObservavel.getSituacaoAtual() == Situacao.AGUARDA_JOGADOR1 || jogoObservavel.getSituacaoAtual() == Situacao.AGUARDA_JOGADOR2){
            jinfo.setText("Peças especiais: " + jogoObservavel.getEspeciais() + "\nJogadas p/ minijogo: " + (4-jogoObservavel.getJogadas()) + "\nCréditos: " + jogoObservavel.getCreditos());
        }
    }
}
