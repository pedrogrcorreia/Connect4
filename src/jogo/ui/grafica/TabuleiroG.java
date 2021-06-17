package jogo.ui.grafica;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import jogo.logica.JogoObservavel;
import jogo.logica.Situacao;

import javafx.geometry.Insets;


import static javafx.scene.paint.Color.*;
import static jogo.logica.Properties.JOGO;

public class TabuleiroG extends GridPane {
    private JogoObservavel jogoObservavel;


    public TabuleiroG(JogoObservavel jogoObservavel) {
        this.jogoObservavel = jogoObservavel;
        criarVista();
        registarObserver();
        atualiza();
    }

    private void registarObserver(){
        jogoObservavel.addPropertyChangeListener(JOGO.toString(), event->{
            atualiza();
        });
    }

    private void criarVista(){
        getChildren().clear();
        setPrefSize(6, 7);
        setAlignment(Pos.CENTER_LEFT);
        for(int i=0; i<7; i++){
            ColumnConstraints columnConstraints = new ColumnConstraints(40);
            getColumnConstraints().add(columnConstraints);
        }

        for(int i=0; i<6; i++){
            RowConstraints rowConstraints = new RowConstraints(40);
            getRowConstraints().add(rowConstraints);
        }

        for(int i=0; i<7; i++){
            for(int j=0; j<6; j++){
                Circle c = new Circle(20);
                c.setFill(BLACK);
                add(c, i, j);
            }
        }
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null, new BorderWidths(2))));
    }

    private void atualiza(){
        String[][] tab;
        tab = jogoObservavel.getTabuleiro();

        for(int i=0; i<7; i++){
            for(int j=0; j<6; j++){
                Circle c = new Circle(20);
                if(tab[j][i].compareToIgnoreCase(" ") == 0){
                    c.setFill(BLACK);
                }
                if(tab[j][i].compareToIgnoreCase("X") == 0){
                    c.setFill(RED);
                }
                if(tab[j][i].compareToIgnoreCase("O") == 0){
                    c.setFill(BLUE);
                }
                int finalI = i;
                c.setOnMousePressed(e ->{
                    if(jogoObservavel.getSituacaoAtual() == Situacao.AGUARDA_JOGADOR1 || jogoObservavel.getSituacaoAtual() == Situacao.AGUARDA_JOGADOR2) {
                        jogoObservavel.efetuaJogada(finalI + 1);
                    }
                    if(jogoObservavel.getSituacaoAtual() == Situacao.AGUARDA_JOGADOR1_ESPECIAL || jogoObservavel.getSituacaoAtual() == Situacao.AGUARDA_JOGADOR2_ESPECIAL) {
                        jogoObservavel.efetuaJogadaEspecial(finalI + 1);
                    }
                });
                add(c, i, j);
            }
        }
    };
}
