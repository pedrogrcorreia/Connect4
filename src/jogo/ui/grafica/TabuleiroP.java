package jogo.ui.grafica;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import jogo.logica.JogoObservavel;
import jogo.logica.Situacao;
import static javafx.scene.paint.Color.*;
import static jogo.logica.Properties.JOGO;

public class TabuleiroP extends GridPane {
    private JogoObservavel jogoObservavel;


    public TabuleiroP(JogoObservavel jogoObservavel) {
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
        setAlignment(Pos.CENTER);
        for(int i=0; i<7; i++){
            ColumnConstraints columnConstraints = new ColumnConstraints(40);
            getColumnConstraints().add(columnConstraints);
        }

        for(int i=0; i<6; i++){
            RowConstraints rowConstraints = new RowConstraints(40);
            getRowConstraints().add(rowConstraints);
        }
        setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID,null, new BorderWidths(3))));
        setBackground(new Background(new BackgroundFill(BLUE, null, null)));
    }

    private void atualiza(){
        String[][] tab;
        tab = jogoObservavel.getTabuleiro();

        for(int i=0; i<7; i++){
            for(int j=0; j<6; j++){
                Circle c = new Circle(20);
                c.setStroke(BLACK);
                c.setStrokeWidth(3);
                if(tab[j][i].compareToIgnoreCase(" ") == 0){
                    c.setFill(DARKGRAY.darker());
                }
                if(tab[j][i].compareToIgnoreCase("X") == 0){
                    c.setFill(RED);
                }
                if(tab[j][i].compareToIgnoreCase("O") == 0){
                    c.setFill(YELLOW);
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
