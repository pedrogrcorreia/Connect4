package jogo.ui.grafica.estados;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import jogo.logica.JogoObservavel;


import static jogo.logica.Properties.*;
import static jogo.logica.Situacao.AGUARDA_CONFIG;

public class AguardaConfigP extends HBox {
    private JogoObservavel jogoObservavel;
    private Label text;
    private TextField nome;
    private Button enter;

    public AguardaConfigP(JogoObservavel jogoObservavel){
        this.jogoObservavel = jogoObservavel;
        criarJanela();
        registarObserver();
        registarListener();
        atualiza();
    }

    private void criarJanela(){
        text = new Label("Nome do jogador: ");
        nome = new TextField();
        enter = new Button("Seguinte");
        setAlignment(Pos.CENTER);
        setSpacing(10);
        getChildren().addAll(text, nome, enter);
    }



    private void registarObserver(){
        jogoObservavel.addPropertyChangeListener(JOGO.toString(), event->{
            atualiza();
        });
    }

    private void registarListener(){
        enter.setOnAction(e->jogoObservavel.configuraJogador(nome.getText()));

        setOnKeyPressed(e->{
            switch(e.getCode()) {
                case ENTER:
                    jogoObservavel.configuraJogador(nome.getText());
                    break;
            }
        });
    }

    private void atualiza(){
        nome.requestFocus();
        nome.clear();
        this.setVisible(jogoObservavel.getSituacaoAtual() == AGUARDA_CONFIG);
    };
}
