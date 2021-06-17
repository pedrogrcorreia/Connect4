package jogo.ui.grafica.estados;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import jogo.logica.JogoObservavel;

import static jogo.logica.Properties.JOGO;
import static jogo.logica.Situacao.AGUARDA_MINIJOGO_RESPOSTA;

public class AguardaMinijogoRespostaP extends HBox {
    private JogoObservavel jogoObservavel;
    private Label text;
    private TextField resposta;
    private Button enter;
    private String res;

    public AguardaMinijogoRespostaP(JogoObservavel jogoObservavel){
        this.jogoObservavel = jogoObservavel;
        criarJanela();
        registarObserver();
        registarListener();
        atualiza();
    }

    private void registarObserver(){
        jogoObservavel.addPropertyChangeListener(JOGO.toString(), event->{
            atualiza();
        });
    }

    private void criarJanela(){
        enter = new Button("Enviar");
        text = new Label();
        resposta = new TextField();
        setAlignment(Pos.CENTER);
        setSpacing(10);
        getChildren().addAll(text, resposta, enter);
    }

    private void registarListener(){
        enter.setOnAction(e->jogoObservavel.minijogoResposta(resposta.getText()));

        setOnKeyPressed(e->{
            switch(e.getCode()){
                case ENTER:
                    jogoObservavel.minijogoResposta(resposta.getText());
            }
        });
    }

    private void atualiza(){
        if(jogoObservavel.getSituacaoAtual() == AGUARDA_MINIJOGO_RESPOSTA) {
            resposta.clear();
            text.setText(jogoObservavel.getMinijogo());
            res = resposta.getText();
        }
        setVisible(jogoObservavel.getSituacaoAtual() == AGUARDA_MINIJOGO_RESPOSTA);
    }
}
