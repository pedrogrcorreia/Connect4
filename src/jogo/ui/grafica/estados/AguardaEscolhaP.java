package jogo.ui.grafica.estados;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import jogo.logica.JogoObservavel;
import static jogo.logica.Properties.*;
import static jogo.logica.Situacao.ESCOLHE_MODO;

public class AguardaEscolhaP extends HBox {
    private JogoObservavel jogoObservavel;

    private Button hvh;
    private Button hvc;
    private Button cvc;

    public AguardaEscolhaP(JogoObservavel jogoObservavel) {
        this.jogoObservavel = jogoObservavel;
        criarJanela();
        registarObserver();
        registarListener();
        atualiza();
    }

    private void criarJanela(){
        hvh = new Button("Jogador vs Jogador");
        hvc = new Button("Jogador vs Computador");
        cvc = new Button("Computador vs Computador");
        setSpacing(10);
        setAlignment(Pos.CENTER);
        getChildren().addAll(hvh, hvc, cvc);
    }

    private void registarListener(){
        hvh.setOnAction(e->jogoObservavel.escolherModo(1));


        hvc.setOnAction(e->jogoObservavel.escolherModo(2));

        cvc.setOnAction(e->jogoObservavel.escolherModo(3));
    }


    private void registarObserver(){
        jogoObservavel.addPropertyChangeListener(JOGO.toString(), event->{
            atualiza();
        });
    }

    private void atualiza(){
        setVisible(jogoObservavel.getSituacaoAtual() == ESCOLHE_MODO);
    };
}
