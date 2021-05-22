package jogo.ui.texto;

import jogo.logica.Jogo;
import jogo.logica.JogoGestao;
import jogo.logica.Situacao;
import jogo.logica.Util;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static jogo.logica.Util.*;

public class UIText {
    JogoGestao jogoGestao;
    private boolean sair = false;
    private boolean sairJogo = false;
    private Scanner sc = new Scanner(System.in);

    public UIText(JogoGestao j){
        this.jogoGestao = j;
    }

    void escolherModo(){
        System.out.println("Escolha o modo que pretende jogar:");
        System.out.println("1. Jogador vs Jogador");
        System.out.println("2. Jogador vs Computador");
        System.out.println("3. Computador vs Computador");
        System.out.println("Introduza fim para sair");
        String s;
        int opcao = 0;
        if(sc.hasNextInt()){
            opcao = sc.nextInt();
            if(opcao <= 0 || opcao > 3){
                escolherModo();
            }
            jogoGestao.escolherModo(opcao);
            return;
        }
        s = sc.next();
        if(s.compareToIgnoreCase("fim") == 0){
            jogoGestao.terminaJogoAtual();
            sairJogo = true;
        }
    }

    void configuracao(){
        System.out.println("Introduza o nome do jogador: ");
        String s = sc.next();
        jogoGestao.configuraJogador(s);
    }

    void efetuaJogada(){
        System.out.println("Introduza 'u' para desfazer a jogada anterior.");
        System.out.println("Introduza 's' para utilizar a peça especial.");
        System.out.println("Introduza 'g' para gravar o jogo e sair.");
        System.out.println("Introduza a coluna onde pretende jogar: ");
        String s;
        int col;
        if(sc.hasNextInt()){
            col = sc.nextInt();
            jogoGestao.efetuaJogada(col);
            return;
        }
        s = sc.next();
        if(s.compareToIgnoreCase("u") == 0){
            jogoGestao.undo();
            return;
        }
        if(s.compareToIgnoreCase("s") == 0){
            jogoGestao.efetuaJogada('s');
        }
        if(s.compareToIgnoreCase("fim") == 0){
            jogoGestao.terminaJogoAtual();
            sairJogo = true;
        }
        if(s.compareToIgnoreCase("g") == 0){
            System.out.println("Introduza o nome do jogo: ");
            s = sc.next();
            gravaJogo(jogoGestao, s);
            sairJogo = true;
        }
    }

    void efetuaJogadaEspecial(){
        System.out.println("Introduza a coluna para a qual pretende eliminar as peças.");
        int col = 0;
        if(sc.hasNextInt()){
            col = sc.nextInt();
            jogoGestao.efetuaJogadaEspecial(col);
        }
    }

    void efetuaJogadaPC(){
        System.out.println("Introduza 'enter' para prosseguir a jogada.");
        System.out.println("Introduza 'g' para gravar o jogo.");
        String s;
        s = sc.nextLine();

        if(s.compareToIgnoreCase("fim") == 0){
            jogoGestao.terminaJogoAtual();
            sairJogo = true;
        }
        if(s.compareToIgnoreCase("g") == 0){
            System.out.println("Introduza o nome do jogo: ");
            s = sc.next();
            gravaJogo(jogoGestao, s);
            sairJogo = true;
        }
        jogoGestao.efetuaJogadaPC();
    }

    void novoJogo(){
        System.out.println("Pretende iniciar um novo jogo? (S/N)");
        String s;
        s = sc.next();
        if(s.compareToIgnoreCase("s") == 0){
            jogoGestao.novoJogo();
        }
        else{
            jogoGestao.terminaJogoAtual();
            sairJogo = true;
        }
    }

    void minijogo(){
        System.out.println("Pretende usufruir do minijogo? (S/N)");
        String s;
        s = sc.next();
        jogoGestao.minijogo(s);
    }

    void minijogoResposta(){
        System.out.println("Introduza a resposta: ");
        String s;
        s = sc.next();
        jogoGestao.minijogoResposta(s);
    }

    JogoGestao carregaJogo() throws IOException, ClassNotFoundException {
        System.out.println("Introduza o nome do ficheiro do jogo: ");
        String s;
        s = sc.next();
        jogoGestao = Util.recuperaJogo(s);
        if(jogoGestao != null){
            return jogoGestao;
        }
        else{
            System.out.println("Introduza um nome de ficheiro válido.");
            carregaJogo();
        }
        return null;
    }

    JogoGestao recuperaReplay() throws IOException, ClassNotFoundException {
        System.out.println("Introduza o numero do jogo que pretende rever: ");
        int jogo;
        if(sc.hasNextInt()){
            jogo = sc.nextInt();
            if(jogo < 1 || jogo > 5){
                System.out.println("Número inválido.");
                recuperaReplay();
            }
            else{
                jogoGestao = Util.recuperaReplay(jogo);
                return jogoGestao;
            }
        }
        return null;
    }

    void printLog(){
        List<String> log = jogoGestao.getLog();
        //System.out.println("\n");
        for(String s : log){
            System.out.println(s);
        }
    }

    void printLogJogada(){
        String log = jogoGestao.getLogJogada();
        System.out.println(log);
    }

    void jogo(){
        while (!sairJogo) {
            if (jogoGestao != null) {
                Situacao sit = jogoGestao.getSituacaoAtual();
                printLogJogada();
                System.out.println(sit);
                switch (sit) {
                    case ESCOLHE_MODO:
                        escolherModo();
                        break;
                    case AGUARDA_CONFIG:
                        configuracao();
                        break;
                    case AGUARDA_JOGADOR1:
                    case AGUARDA_JOGADOR2:
                        efetuaJogada();
                        //System.out.println(jogoGestao.getTabuleiro());
                        break;
                    case AGUARDA_JOGADOR1_ESPECIAL:
                    case AGUARDA_JOGADOR2_ESPECIAL:
                        efetuaJogadaEspecial();
                        //System.out.println(jogoGestao.getTabuleiro());
                        break;
                    case AGUARDA_JOGADORPC:
                        efetuaJogadaPC();
                        //System.out.println(jogoGestao.getTabuleiro());
                        break;
                    case AGUARDA_MINIJOGO:
                        minijogo();
                        break;
                    case AGUARDA_MINIJOGO_RESPOSTA:
                        System.out.println(jogoGestao.getMinijogo());
                        minijogoResposta();
                        break;
                    case AGUARDA_RECOMECO:
                        gravaReplay(jogoGestao);
                        novoJogo();
                        break;
                }
//                printLogJogada();
            }
        }
    }

    public void run() throws IOException, ClassNotFoundException {
        while (!sair) {
            sairJogo = false;
            jogoGestao = new JogoGestao();
            System.out.println("Deseja: ");
            System.out.println("Começar um novo jogo (N).");
            System.out.println("Carregar um jogo gravado (C).");
            System.out.println("Ver o replay de um jogo (R).");
            System.out.println("Terminar. (F)");
            String s;
            s = sc.next();
            switch(s){
                case "c":
                case "C":
                    jogoGestao = carregaJogo();
                    printLog();
                    jogo();
                    break;
                case "r":
                case "R":
                    jogoGestao = recuperaReplay();
                    if(jogoGestao != null) {
                        printLog();
                    }
                    else{
                        System.out.println("O replay não existe.");
                    }
                    break;
                case "n":
                case "N":
                    jogo();
                    break;
                case "f":
                case "F":
                    sair = true;
                    break;
            }
//            if (s.compareToIgnoreCase("c") == 0) {
//                jogoGestao = carregaJogo();
//                printLog();
//                jogo();
//                break;
//            }
//            if (s.compareToIgnoreCase("r") == 0) {
//                jogoGestao = recuperaReplay();
//                printLog();
//                break;
//            }
//            if(s.compareToIgnoreCase("f") == 0){
//                sair = true;
//                break;
//            }
//            if(s.compareToIgnoreCase("n") == 0){
//                jogo();
//                break;
//            }
        }
    }
}
