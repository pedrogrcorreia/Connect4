package jogo.ui.texto;

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
    private boolean newGame = true;
    private Scanner sc = new Scanner(System.in).useDelimiter("\\n");

    public UIText(JogoGestao j){
        this.jogoGestao = j;
    }

    void escolherModo(){
        System.out.println("Escolha o modo que pretende jogar:");
        System.out.println("1. Jogador vs Jogador");
        System.out.println("2. Jogador vs Computador");
        System.out.println("3. Computador vs Computador");
        System.out.print("Opção: ");
        String s;
        int opcao = 0;
        if(sc.hasNextInt()){
            opcao = sc.nextInt();
            sc.nextLine();
            if(opcao <= 0 || opcao > 3){
                escolherModo();
            }
            jogoGestao.escolherModo(opcao);
            return;
        }
        s = sc.next();
        if(s.compareToIgnoreCase("fim") == 0){
            sairJogo = true;
        }
    }

    void configuracao(){
        System.out.println("Introduza o nome do jogador: ");
        String s = sc.next();
        if(s.compareToIgnoreCase("fim") == 0){
            sairJogo = true;
        }
        else {
            jogoGestao.configuraJogador(s);

        }
    }

    void instrucoes(){
        System.out.println("As colunas são numeradas de 1 a 7.");
        System.out.println("Introduza 'j' para jogar.");
        System.out.println("Introduza 'u' para desfazer a jogada anterior.");
        System.out.println("Introduza 's' para utilizar a peça especial.");
        System.out.println("Introduza 'g' para gravar o jogo e sair.");
        System.out.println("Introduza 'fim' para sair a qualquer altura.\n");
    }

    void efetuaJogada(){
        System.out.println("Introduza a opção que pretende.");
        System.out.print("Opção/Coluna: ");
        String s;
        int col;
        if(sc.hasNextInt()){
            col = sc.nextInt();
            sc.nextLine();
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
        System.out.print("Coluna: ");
        int col = 0;
        if(sc.hasNextInt()){
            col = sc.nextInt();
            jogoGestao.efetuaJogadaEspecial(col);
        }
    }

    void efetuaJogadaPC(){
        System.out.println("Prima enter para prosseguir o jogo.");
        String s;
        s = sc.nextLine();
        if(s.compareToIgnoreCase("fim") == 0){
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

    public void novoJogo(){
        System.out.println("Pretende iniciar um novo jogo? (S/N)");
        System.out.print("Opção: ");
        String s;
        s = sc.next();
        if(s.compareToIgnoreCase("s") == 0){
            System.out.println(s);
            newGame = true;
            jogoGestao.novoJogo();
            return;
        }
        if(s.compareToIgnoreCase("n") == 0){
            sairJogo = true;
            return;
        }
        System.out.println("Por favor introduza uma opção válida.\n");
        novoJogo();
    }

    void minijogo(){
        System.out.println("Pretende usufruir do minijogo? (S/N)");
        System.out.print("Opção: ");
        String s;
        s = sc.next();
        if(s.compareToIgnoreCase("s") == 0|| s.compareToIgnoreCase("n") == 0){
            jogoGestao.minijogo(s);
        }
        else{
            System.out.println("Por favor introduza uma opção válida.\n");
            minijogo();
        }

    }

    void minijogoResposta(){
        System.out.println("Introduza a resposta.");
        System.out.println("Resposta: ");
        String s;
        s = sc.next();
        jogoGestao.minijogoResposta(s);
    }

    JogoGestao carregaJogo() throws IOException, ClassNotFoundException {
        System.out.println("Introduza o nome do ficheiro do jogo");
        System.out.print("Nome do ficheiro: ");
        String s;
        s = sc.next();
        jogoGestao = Util.recuperaJogo(s);
        return jogoGestao;
    }

    JogoGestao recuperaReplay() throws IOException, ClassNotFoundException {
        System.out.println("Introduza o numero do jogo que pretende rever. (1-5)");
        System.out.println("Tem " + Util.getReplays() + " para rever.");
        System.out.print("Opção: ");
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
        List<String> log = jogoGestao.getLogCompleto();
        for(String s : log){
            System.out.println(s);
        }
    }

    void printLogJogada(){
        List<String> log = jogoGestao.getLogJogada();
        for(String s : log){
            System.out.println(s+"\n");
        }
    }

    void jogo(){
        while (!sairJogo) {
            if(newGame){
                instrucoes();
            }
            newGame = false;
            if (jogoGestao != null) {
                Situacao sit = jogoGestao.getSituacaoAtual();
                printLogJogada();
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
                        break;
                    case AGUARDA_JOGADOR1_ESPECIAL:
                    case AGUARDA_JOGADOR2_ESPECIAL:
                        efetuaJogadaEspecial();
                        break;
                    case AGUARDA_JOGADORPC:
                        efetuaJogadaPC();
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
            }
        }
    }

    public void run() throws IOException, ClassNotFoundException {
        while (!sair) {
            sairJogo = false;
            jogoGestao = new JogoGestao();
            System.out.println("Começar um novo jogo (N).");
            System.out.println("Carregar um jogo gravado (C).");
            System.out.println("Ver o replay de um jogo (R).");
            System.out.println("Terminar. (T)\n");
            System.out.print("Opção: ");
            String s;
            s = sc.next();
            switch(s){
                case "c":
                case "C":
                    jogoGestao = carregaJogo();
                    if(jogoGestao != null) {
                        printLog();
                        jogo();
                    }
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
                case "t":
                case "T":
                    sair = true;
                    break;
                default:
                    System.out.println("Introduza uma opção válida.\n");
                    break;
            }
        }
    }
}
