package jogo.logica.dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dados implements Serializable {
    private Tabuleiro tabuleiro;
    private int modo, minijogoN;
    private Jogador j1, j2, atual, prox;
    private List<String> logCompleto;
    private List<String> logJogada;
    private transient Minijogo minijogo;

    public Dados(){
        logCompleto = new ArrayList<String>();
    };

    public boolean escolheModo(int opc){
        modo = opc;
        addLog("Foi escolhido o modo " + modo + ".\n");
        return true;
    }

    public int getModo(){
        return modo;
    }

    public boolean configuraJogador(String s){
        if(modo == 1){
            if(j1 == null) {
                j1 = new JogadorH(s, "O");
                addLog("Configuração do jogador "+s+" com a ficha " + " O " + ".\n");
                return false;
            }
            else{
                if(j1.getNome().compareToIgnoreCase(s) == 0){
                    return false;
                }
                j2 = new JogadorH(s, "X");
                addLog("Configuração do jogador "+s+" com a ficha " + " X " + ".\n");
                iniciaJogo();
                return true;
            }
        }
        if(modo == 2){
            j1 = new JogadorH(s, "O");
            addLog("Configuração do jogador "+s+" com a ficha " + " O " + ".\n");
            j2 = new JogadorC("X");
            addLog("Configuração do jogador "+j2.getNome()+" com a ficha " + " X " + ".\n");
            iniciaJogo();
            return true;
        }
        if(modo == 3){
            j1 = new JogadorC("O");
            addLog("Configuração do jogador "+j1.getNome()+" com a ficha " + " O " + ".\n");
            j2 = new JogadorC("X");
            addLog("Configuração do jogador "+j2.getNome()+" com a ficha " + " X " + ".\n");
            iniciaJogo();
            return true;
        }
        return true;
    }

    // FUNCAO CORRETA
    public void iniciaJogo(){
        tabuleiro = new Tabuleiro();
        //addLog(tabuleiro.toString());
        atual = j1;
        prox = j2;
    }

     //FUNCAO DEBUG
//    public void iniciaJogo(){
//        tabuleiro = new Tabuleiro();
//        atual = new JogadorH("s", "x");
//        prox = new JogadorH("t", "o");
//    }

    public boolean efetuaJogada(int col){
        atual.addCol(col-1);
        if(tabuleiro.joga(atual.getCol(), atual.getFicha())) {
            atual.incrementaJogadas();
            addLog(atual.toString());
            addLog(tabuleiro.toString());
            return true;
        }
        return false;
    }

    public boolean efetuaJogadaEspecial(int col){
        return tabuleiro.jogaEspecial(col - 1);
    }

    public boolean efetuaJogadaPC(){
        int colArt = atual.getCol();
        if(tabuleiro.joga(colArt, atual.getFicha())) {
            addLog(atual.toString());
            return true;
        }
        return false;
    }

    public boolean verificaVitoria(){
        if(!tabuleiro.verificaVitoria(atual.getCol(), atual.getFicha())){
            return false;
        }
        addLog("Jogador " + atual.getNome() + " venceu o jogo!\n");
        return true;
    }

    public void proxJogador(){
        Jogador aux = atual;
        atual = prox;
        prox = aux;
    }

    public void terminaJogo(){
        j1 = null;
        j2 = null;
    }

    public int getJogadas(){
        return atual.getJogadas();
    }

    public int getJogadorAtual(){
        if(atual == j1){
            return 1;
        }
        else{
            return 2;
        }
    }

    public boolean minijogo(String s){
        if(s.compareToIgnoreCase("s") == 0){
            atual.startClock();
            return true;
        }
        return false;
    }

    public String getMinijogo(){
        if(atual.getMinijogo() == 0){
            minijogo = new MinijogoMatematica();
        }
        else{
            minijogo = new MinijogoDicionario();
        }
        minijogo.criaJogo();
        System.out.println(minijogo.getResposta());
        return minijogo.getJogo();
//        if(atual.getMinijogo() == 0){
//            m.criaJogo();
//            System.out.println(m.getResposta());
//            return m.getJogo();
//        }
//        else{
//            d.criaJogo();
//            System.out.println(d.getResposta());
//            return d.getJogo();
//        }
    }

    public boolean minijogoResposta(String resposta) {
        if(minijogo.respostaCorreta(resposta)){
            atual.incrementaRespostas();
            return true;
        }
        return false;
    }

    public boolean continuaMinijogo(){
        if(minijogo.continuaMinijogo(atual.getRespostas())){
            System.out.println(atual.getRespostas());
            return true;
        }
        atual.stopClock();
        return false;
    }

    public boolean minijogoVitoria(){
        System.out.println(atual.getTempo());
        if(minijogo.vitoriaMinijogo(atual.getTempo(), atual.getRespostas())){
            return true;
        }
        return false;
    }

    public void mudaMinijogo(){
        atual.mudaMinijogo();
    }

    public void atribuiEspecial(){
        addLog("Jogador " + atual.getNome() + " ganhou o minijogo e uma peça especial.\n");
        atual.incrementaEspecial();
    }

    public int getEspecial(){
        return atual.getEspecial();
    }

    public int getRespostas(){
        return atual.getRespostas();
    }

    public int getCreditos(){
        return atual.getCreditos();
    }

    public void incrementaJogadas(){ atual.incrementaJogadas(); }

    public void resetRespostas(){ atual.resetRespostas(); }

    public void mantemJogador(int jogador) {
        if(jogador == 1){
            atual = j1;
            prox = j2;
        }
        else{
            atual = j2;
            prox = j1;
        }
    }

    public void removeCreditos(int creditos){
        atual.removeCreditos(creditos);
        System.out.println("Foi removido um credito ao jogador " + atual.getNome() + ".\n");
        System.out.println("Tem " + atual.getCreditos() + " creditos.\n");
        addLog("Foi removido um crédito ao jogador " + atual.getNome() + ".\n");
    }

    public void resetJogadas(){
        atual.resetJogadas();
        addLog("As jogadas até ao mini-jogo foram resetadas para o jogador " + atual.getNome() + ".\n");
    }

    private void addLog(String a){
        logCompleto.add(a);
    }

    public List<String> getLog(){
        return logCompleto;
    }

    public String getLogJogada() {
        if (logCompleto.size() > 0) {
            return logCompleto.get(logCompleto.size() - 1);
        }
        return "";
    }

    public String getTabuleiro(){
        return tabuleiro.toString();
    }

    public boolean tabuleiroCheio() {
        if(tabuleiro.cheio()){
            addLog("Jogadores empataram.");
            return true;
        }
        return false;
    }
}
