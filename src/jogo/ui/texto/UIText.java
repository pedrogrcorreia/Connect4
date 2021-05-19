package jogo.ui.texto;

import jogo.Jogo;
import jogo.Situacao;

import java.util.Scanner;

public class UIText {
    Jogo jogo;
    private boolean sair = false;
    private Scanner sc = new Scanner(System.in);

    public UIText(Jogo j){
        this.jogo = j;
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
            jogo.escolherModo(opcao);
            return;
        }
        s = sc.next();
        if(s.compareToIgnoreCase("fim") == 0){
            jogo.terminaJogoAtual();
            sair = true;
        }
    }

    void configuracao(){
        System.out.println("Introduza o nome do jogador: ");
        String s = sc.next();
        jogo.configuraJogador(s);
    }

    void efetuaJogada(){
        System.out.println("Introduza a coluna onde pretende jogar: ");
        int col = 0;
        if(sc.hasNextInt()){
            col = sc.nextInt();
            if(col <= 0 || col > 7){
                efetuaJogada();
            }
            jogo.efetuaJogada(col);
            return;
        }
    }

//    void jogada(){
//        jogo.joga(3);
//        System.out.println(jogo.getTabuleiro());
//    }
//
//    void minijogo(){
//
//    }

    public void run(){
        while(!sair) {
            Situacao sit = jogo.getSituacaoAtual();
            System.out.println(sit);
            switch(sit) {
                case ESCOLHE_MODO:
                    escolherModo();
                    break;
                case CONFIGURA_JOGADOR1:
                    configuracao();
                    break;
                case CONFIGURA_JOGADOR2:
                    configuracao();
                    break;
                case AGUARDA_JOGADOR1:
                    efetuaJogada();
                    System.out.println(jogo.toString());
                    break;
                case AGUARDA_JOGADOR2:
                    efetuaJogada();
                    System.out.println(jogo.toString());
                    break;
                case AGUARDA_MINIJOGO:
                    break;
                case AGUARDA_RECOMECO:
                    break;
            }
        }
    };
}
