package jogo.ui.grafica.estados;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import jogo.logica.JogoObservavel;
import jogo.logica.Situacao;

import javafx.geometry.Insets;


import static javafx.scene.paint.Color.*;
import static javafx.scene.paint.Color.WHITE;
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
        setGridLinesVisible(true);
        setPrefSize(6, 7);
        //this.setPadding(new Insets(10, 10, 10, 10));

        this.setAlignment(Pos.CENTER);
        //this.setHgap(10);
        //this.setVgap(10);
        for(int i=0; i<7; i++) {
            for(int j=0; j<6; j++) {
                Circle c = new Circle(20);
                c.setFill(BLACK);
                add(c, i, j);
//                setOnMouseEntered((e)->{
//                    rect.setFill(WHITE);
//                });
            }
        }//add(rect, 0, 1);
        //add(rect, 0, 2);

    }

    private void atualiza(){
        String[][] tab;
        getChildren().clear();
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
                add(c, i, j);
            }
        }
//        getChildren().clear();
//        for (int i = 0; i < 7; i++) {
//            ColumnConstraints column = new ColumnConstraints(10);
//            getColumnConstraints().add(column);
//        }
//
//        for (int i = 0; i < 6; i++) {
//            RowConstraints row = new RowConstraints(10);
//            getRowConstraints().add(row);
//        }
    };
}
