//package jogo.ui.grafica.estados;
//
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;
//import javafx.scene.layout.HBox;
//import jogo.logica.JogoObservavel;
//
//import static jogo.logica.Properties.*;
//
//public class VistaEscolha extends HBox {
//    private Button novoJogo;
//    private Button verReplay;
//    private Button carregarJogo;
//
//    private JogoObservavel jogoObservavel;
//
//    public VistaEscolha(JogoObservavel jogoObservavel){
//        this.jogoObservavel = jogoObservavel;
//        criarJanela();
//        registarObserver();
//    }
//
//    private void criarJanela(){
//        novoJogo = new Button("Novo Jogo");
//        verReplay = new Button("Ver Replays");
//        carregarJogo = new Button("Carregar Jogo");
//        setAlignment(Pos.CENTER);
//        setSpacing(10);
//        getChildren().addAll(novoJogo, verReplay, carregarJogo);
//    }
//
//
//
//
//    private void registarObserver(){
//        jogoObservavel.addPropertyChangeListener(CONFIG, event->{
//            jogoObservavel.escolherModo();
//        });
//    }
//    private void atualiza(){};
//}
