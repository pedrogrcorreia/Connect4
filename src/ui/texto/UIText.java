package ui.texto;

import logica.Jogo;
import logica.Situacao;

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
        jogo.configuracao(s);
    }

    void jogada(){
        jogo.joga(3);
        System.out.println(jogo.getTabuleiro());
    }

    void minijogo(){

    }

    public void run(){
        while(!sair) {
            Situacao sit = jogo.getSituacaoAtual();
            System.out.println(sit);
            switch(sit) {
                case ESCOLHE_MODO:
                    escolherModo();
                    break;
                case CONFIGURACAO:
                    configuracao();
                    break;
                case JOGADA:
                    jogada();
                    break;
                case MINIJOGO:
                    minijogo();
                    break;
            }
        }
    };
}
