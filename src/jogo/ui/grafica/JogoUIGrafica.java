package jogo.ui.grafica;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import jogo.logica.JogoObservavel;
import java.io.File;
import java.io.IOException;
import static jogo.logica.Properties.*;
import static jogo.logica.Situacao.*;

public class JogoUIGrafica extends BorderPane {
    private JogoObservavel jogoObservavel;
    private MenuItem menu;
    private PrincipalP principalP;

    public JogoUIGrafica(JogoObservavel jogoObservavel) throws InterruptedException {
        this.jogoObservavel = jogoObservavel;
        criarVista();
        menus();
        registarObserver();
        atualiza();
    }

    private void registarObserver(){
        jogoObservavel.addPropertyChangeListener(JOGO.toString(), event-> {
            atualiza();
        });
    }

    private void criarVista() throws InterruptedException {
        principalP = new PrincipalP(jogoObservavel);
        setCenter(principalP);
    }

    private void menus(){
        MenuBar menuBar = new MenuBar();
        setTop(menuBar);

        Menu jogo = new Menu("_Jogo");
        menu = new MenuItem("Novo jogo");

        MenuItem carregarJogo = new MenuItem("Carregar jogo");
        MenuItem gravarJogo = new MenuItem("Gravar jogo");
        MenuItem replayJogo = new MenuItem("Ver replay");
        MenuItem sair = new MenuItem("Sair");

        jogo.getItems().addAll(menu, carregarJogo, gravarJogo, replayJogo, sair);

        menu.setOnAction(e->{
            jogoObservavel.terminaJogoAtual();
        });

        sair.setOnAction((ActionEvent e)-> {
            Stage janela2 = (Stage) this.getScene().getWindow();
            fireEvent( new WindowEvent(janela2, WindowEvent.WINDOW_CLOSE_REQUEST));
        });

        carregarJogo.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("./"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if(selectedFile != null){
                try {
                    jogoObservavel.recuperaJogo(selectedFile);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });

        gravarJogo.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("./"));
            File selectedFile = fileChooser.showSaveDialog(null);
            if(selectedFile != null){
               jogoObservavel.gravarJogo(selectedFile);
            }
                }
        );

        replayJogo.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("./replays"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if(selectedFile != null){
                try {
                    jogoObservavel.recuperaJogo(selectedFile);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });

        Menu sobre = new Menu("_Sobre");
        MenuItem regras = new MenuItem("Regras");
        MenuItem trabalho = new MenuItem("About me");

        regras.setOnAction((ActionEvent e)->{
            Alert msgBox = new Alert(Alert.AlertType.INFORMATION);
            msgBox.setHeaderText("Regras");
            msgBox.setContentText("Jogador 1 tem as fichas amarelas.\nJogador 2 tem as fichas vermelhas.\nTente fazer linhas de 4 fichas seguidas da mesma cor.\nDe 4 em 4 jogadas tem direito a um minijogo.\nSe ganhar o minijogo pode jogar peças especiais que eliminam todas as fichas de uma coluna.\nPode voltar atrás durante o jogo.\n");
            msgBox.showAndWait();
        });

        trabalho.setOnAction((ActionEvent e)->{
            Alert msgBox = new Alert(Alert.AlertType.INFORMATION);
            msgBox.setHeaderText("About me");
            msgBox.setContentText("Pedro Correia\nProgramação Avançada - ISEC 2021\nhttps://github.com/pedrogrcorreia/TPPA2021");
            msgBox.showAndWait();
        });

        sobre.getItems().addAll(regras, trabalho);

        menuBar.getMenus().addAll(jogo, sobre);
    }

    private void atualiza(){menu.setDisable( !(jogoObservavel.getSituacaoAtual() ==  AGUARDA_JOGADOR1) && !(jogoObservavel.getSituacaoAtual() == AGUARDA_JOGADOR2) && !(jogoObservavel.getSituacaoAtual() == AGUARDA_JOGADORPC));};
}
