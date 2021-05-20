package jogo.ui.texto;

import jogo.logica.Jogo;
import jogo.logica.JogoGestao;
import jogo.logica.Situacao;

import java.util.List;
import java.util.Scanner;

public class UIText {
    JogoGestao jogoGestao;
    private boolean sair = false;
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
            sair = true;
        }
    }

    void configuracao(){
        System.out.println("Introduza o nome do jogador: ");
        String s = sc.next();
        jogoGestao.configuraJogador(s);
    }

    void efetuaJogada(){
        System.out.println("Introduza 'u' para desfazer a jogada anterior.");
        System.out.println("Introduza a coluna onde pretende jogar: ");
        String s;
        int col = 0;
        if(sc.hasNextInt()){
            col = sc.nextInt();
            jogoGestao.efetuaJogada(col);
            return;
        }
        s = sc.next();
        if(s.compareToIgnoreCase("u") == 0){
            jogoGestao.undo();
        }
    }

    void efetuaJogadaPC(){
        System.out.println("Introduza 'prox' para prosseguir a jogada.");
        String s;
        s = sc.nextLine();
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
            sair = true;
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
        jogoGestao.minijogoResposta();
    }

    void printLog(){
        List<String> log = jogoGestao.getLog();
        //System.out.println("\n");
        for(String s : log){
            System.out.println(s);
        }
    }



    public void run(){
        while(!sair) {
            Situacao sit = jogoGestao.getSituacaoAtual();
            System.out.println(sit);
            printLog();
            switch(sit) {
                case ESCOLHE_MODO:
                    escolherModo();
                    break;
                case AGUARDA_CONFIG:
                    configuracao();
                    break;
                case AGUARDA_JOGADOR1:
                case AGUARDA_JOGADOR2:
                    efetuaJogada();
                    System.out.println(jogoGestao.toString());
                    break;
                case AGUARDA_JOGADORPC:
                    efetuaJogadaPC();
                    System.out.println(jogoGestao.toString());
                    break;
                case AGUARDA_MINIJOGO:
                    minijogo();
                    break;
                case AGUARDA_MINIJOGO_RESPOSTA:
                    minijogoResposta();
                    break;
                case AGUARDA_RECOMECO:
                    novoJogo();
                    break;
            }
        }
    };
}
