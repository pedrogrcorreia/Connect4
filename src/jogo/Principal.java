package jogo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import jogo.logica.JogoGestao;
import jogo.logica.JogoObservavel;
import jogo.ui.grafica.JogoUIGrafica;
//import jogo.ui.texto.UIText;

import java.io.IOException;

public class Principal extends Application {


    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        JogoGestao jogoGestao = new JogoGestao();
        JogoObservavel jogoObservavel = new JogoObservavel(jogoGestao);
        JogoUIGrafica jogoUIGrafica = new JogoUIGrafica(jogoObservavel);
        Image icon = new Image(getClass().getResourceAsStream("imagens/icon.png"));


        Scene scene = new Scene(jogoUIGrafica, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("4 em Linha");
        primaryStage.setOnCloseRequest(windowEvent -> Platform.exit());
        primaryStage.getIcons().add(icon);
        primaryStage.show();

//        JogoGestao jogoGestao2 = new JogoGestao();
//        JogoObservavel jogoObservavel2 = new JogoObservavel(jogoGestao2);
//        Stage janela2 = new Stage();
//        JogoUIGrafica jogoUIGrafica2 = new JogoUIGrafica(jogoObservavel2);
//        Scene scene2 = new Scene(jogoUIGrafica2, 600, 400);
//        janela2.setScene(scene2);
//        janela2.setResizable(false);
//        janela2.setTitle("4 em Linha");
//        janela2.setOnCloseRequest(windowEvent->Platform.exit());
//        janela2.getIcons().add(icon);
//        janela2.show();
//
//        Stage janela3 = new Stage();
//        JogoUIGrafica jogoUIGrafica3 = new JogoUIGrafica(jogoObservavel2);
//        Scene scene3 = new Scene(jogoUIGrafica3, 600, 400);
//        janela3.setScene(scene3);
//        janela3.setResizable(false);
//        janela3.setTitle("4 em Linha");
//        janela3.setOnCloseRequest(windowEvent->Platform.exit());
//        janela3.getIcons().add(icon);
//        janela3.show();

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
