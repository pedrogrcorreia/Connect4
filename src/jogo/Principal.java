package jogo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jogo.logica.Jogo;
import jogo.logica.JogoGestao;
import jogo.logica.JogoObservavel;
import jogo.ui.grafica.JogoUIGrafica;
//import jogo.ui.texto.UIText;

import java.io.IOException;

public class Principal extends Application {

    @Override
    public void start(Stage primaryStage){
        JogoGestao jogoGestao = new JogoGestao();
        JogoObservavel jogoObservavel = new JogoObservavel(jogoGestao);
        jogoGestao.efetuaJogada(3);
        jogoGestao.efetuaJogada(4);
        jogoGestao.efetuaJogada(7);
        JogoUIGrafica jogoUIGrafica = new JogoUIGrafica(jogoObservavel);

        Scene scene = new Scene(jogoUIGrafica);
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        primaryStage.setTitle("4 em Linha");
        primaryStage.setOnCloseRequest(windowEvent -> Platform.exit());
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        launch(args);
    }
}

//public class Principal {
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        JogoGestao jGestao = new JogoGestao();
//        UIText uiText = new UIText(jGestao);
//        uiText.run();
//    }
//}
