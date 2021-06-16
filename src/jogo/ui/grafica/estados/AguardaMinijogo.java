package jogo.ui.grafica.estados;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import jogo.logica.JogoObservavel;
import jogo.logica.Situacao;

import static jogo.logica.Properties.JOGO;
import static jogo.logica.Situacao.AGUARDA_MINIJOGO;

public class AguardaMinijogo extends HBox {
    private JogoObservavel jogoObservavel;

    private RadioButton sim, nao;
    private ToggleGroup radioGroup;
    private Button opcao;

    public AguardaMinijogo(JogoObservavel jogoObservavel){
        this.jogoObservavel = jogoObservavel;
        criaVista();
        registarObserver();
        atualiza();
    }

    private void criaVista(){
        sim = new RadioButton("Sim");
        nao = new RadioButton("Não");
        opcao = new Button("Escolher");

        radioGroup = new ToggleGroup();
        radioGroup.getToggles().addAll(sim, nao);
        setAlignment(Pos.CENTER);
        setSpacing(20);
        getChildren().addAll(sim, nao, opcao);

        opcao.setOnAction((e)->{
            if(sim.isSelected()){
                jogoObservavel.minijogo("s");
            }
            else if(nao.isSelected()){
                jogoObservavel.minijogo("n");
            }
        });
    }

    private void registarObserver(){
        jogoObservavel.addPropertyChangeListener(JOGO.toString(), event->{
            atualiza();
        });
    }

    private void atualiza(){
        Toggle toggle = radioGroup.getSelectedToggle();
        if(toggle != null){
            toggle.setSelected(false);
        }
        this.setVisible(jogoObservavel.getSituacaoAtual() == AGUARDA_MINIJOGO);
    }
}
