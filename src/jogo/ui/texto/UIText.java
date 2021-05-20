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
        }
    }

    void efetuaJogadaPC(){
        System.out.println("Introduza 'prox' para prosseguir a jogada.");
        String s;
        s = sc.nextLine();
        jogo.efetuaJogadaPC();
//        if(s.compareToIgnoreCase("prox") == 0){
//            jogo.efetuaJogadaPC();
//        }
    }

    void novoJogo(){
        System.out.println("Pretende iniciar um novo jogo? (S/N)");
        String s;
        s = sc.next();
        if(s.compareToIgnoreCase("s") == 0){
            jogo.novoJogo();
        }
        else{
            jogo.terminaJogoAtual();
            sair = true;
        }
    }

    void minijogo(){
        System.out.println("Pretende usufruir do minijogo? (S/N)");
        String s;
        s = sc.next();
        jogo.minijogo(s);
    }

    void minijogoResposta(){

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
                case AGUARDA_CONFIG:
                    configuracao();
                    break;
                case AGUARDA_JOGADOR:
                    efetuaJogada();
                    System.out.println(jogo.toString());
                    break;
                case AGUARDA_JOGADORPC:
                    efetuaJogadaPC();
                    System.out.println(jogo.toString());
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
