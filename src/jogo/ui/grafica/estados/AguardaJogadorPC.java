package jogo.ui.grafica.estados;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import jogo.logica.JogoObservavel;
import static jogo.logica.Properties.JOGO;
import static jogo.logica.Situacao.*;

public class AguardaJogadorPC extends HBox {
    private JogoObservavel jogoObservavel;
    private Label text;
    private Slider slider;
    private double speed;

    public AguardaJogadorPC(JogoObservavel jogoObservavel){
        this.jogoObservavel = jogoObservavel;
        criarJanela();
        registarObserver();
        atualiza();
    }

    private void criarJanela(){
        text = new Label();
        slider = new Slider(1, 4, 1);
        slider.setBlockIncrement(1);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(1);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        setAlignment(Pos.CENTER);
        setSpacing(10);
        getChildren().addAll(text, slider);
    }

    private void registarObserver(){
        jogoObservavel.addPropertyChangeListener(JOGO.toString(), event->{
            atualiza();
        });
    }

    private void atualiza() {

        if(jogoObservavel.getSituacaoAtual() == AGUARDA_JOGADORPC){
            speed = slider.getValue();
            PauseTransition p = new PauseTransition(Duration.millis(speed*1000));
            p.setOnFinished(e->jogoObservavel.efetuaJogadaPC());
            text.setText("Jogador PC a jogar.\nAjuste a velocidade.");
            p.play();
        }
        setVisible(jogoObservavel.getSituacaoAtual() == AGUARDA_JOGADORPC);

    };
}
