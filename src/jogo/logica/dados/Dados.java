package jogo.logica.dados;

import jogo.logica.dados.jogador.IJogador;
import jogo.logica.dados.jogador.JogadorC;
import jogo.logica.dados.jogador.JogadorH;
import jogo.logica.dados.minijogo.IMinijogo;
import jogo.logica.dados.minijogo.MinijogoDicionario;
import jogo.logica.dados.minijogo.MinijogoMatematica;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dados implements Serializable {
    @Serial
    private static final long serialVersionUID = 3L;

    private Tabuleiro tabuleiro;
    private int modo;
    private IJogador j1, j2, atual, prox;
    private List<String> logCompleto;
    private List<String> logJogada;
    private transient IMinijogo minijogo;

    public Dados(){
        logCompleto = new ArrayList<String>();
        logJogada = new ArrayList<String>();
        tabuleiro = new Tabuleiro();

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
                addLog("Configuração do jogador "+s+" com a ficha " + "O" + ".\n");
                return false;
            }
            else{
                if(j1.getNome().compareToIgnoreCase(s) == 0){
                    return false;
                }
                j2 = new JogadorH(s, "X");
                addLog("Configuração do jogador "+s+" com a ficha " + "X" + ".\n");
                iniciaJogo();
                return true;
            }
        }
        if(modo == 2){
            j1 = new JogadorH(s, "O");
            addLog("Configuração do jogador "+s+" com a ficha " + "O" + ".\n");
            j2 = new JogadorC("X");
            addLog("Configuração do jogador "+j2.getNome()+" com a ficha " + "X" + ".\n");
            iniciaJogo();
            return true;
        }
        if(modo == 3){
            j1 = new JogadorC("O");
            addLog("Configuração do jogador "+j1.getNome()+" com a ficha " + "O" + ".\n");
            j2 = new JogadorC("X");
            addLog("Configuração do jogador "+j2.getNome()+" com a ficha " + "X" + ".\n");
            iniciaJogo();
            return true;
        }
        return true;
    }

    private void getRandomJogador(){
        if(Math.random() < 0.5){
            atual = j1;
            prox = j2;
        }
        else{
            atual = j2;
            prox = j1;
        }
        addLog("Foi sorteado que o primeiro jogador é a/o " + atual.getNome() + ".\n");
    }

    public void iniciaJogo(){
        tabuleiro = new Tabuleiro();

        if(modo == 1 || modo == 3) {
            getRandomJogador();
        }
        else {
            atual = j1;
            prox = j2;
        }
        atual.resetJogadas();
        atual.resetRespostas();
        atual.resetCreditos();
        prox.resetJogadas();
        prox.resetRespostas();
        prox.resetCreditos();
        addLog(tabuleiro.toString());
        addJogadorLog();
    }

    public boolean efetuaJogada(int col){
        atual.addCol(col-1);
        if(tabuleiro.joga(atual.getCol(), atual.getFicha())) {
            atual.incrementaJogadas();
            addLog(atual.toString());
            addLog(tabuleiro.toString());
            return true;
        }
        addLog(atual.toString());
        addLog(tabuleiro.toString());
        addJogadorLog();
        return false;
    }

    public boolean efetuaJogadaEspecial(int col){
        if(tabuleiro.jogaEspecial(col-1)){
            atual.incrementaEspecial(-1);
            addLog("Jogador " + atual.getNome() + " eliminou as peças da coluna " + col + ".\n");
            addLog(tabuleiro.toString());
            addJogadorLog();
            return true;
        }
        addLog(tabuleiro.toString());
        addJogadorLog();
        return false;
    }

    public boolean efetuaJogadaPC(){
        atual.addCol(atual.randomCol());
        if(tabuleiro.joga(atual.getCol(), atual.getFicha())) {
            addLog(atual.toString());
            addLog(tabuleiro.toString());
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

    public boolean tabuleiroCheio() {
        if(tabuleiro.cheio()){
            addLog("Jogadores empataram.\n");
            return true;
        }
        return false;
    }

    public void proxJogador(){
        IJogador aux = atual;
        atual = prox;
        prox = aux;
        addJogadorLog();
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
        System.out.println("DEBUG");
        System.out.println("Resposta: " + minijogo.getResposta());
        return minijogo.getJogo();
    }

    public boolean minijogoResposta(String resposta) {
        if(minijogo.respostaCorreta(resposta)){
            atual.incrementaRespostas();
            return true;
        }
        addLog("Jogador " + atual.getNome() + " perdeu um minijogo.\n");
        addLog(tabuleiro.toString());
        return false;
    }

    public boolean continuaMinijogo(){
        if(minijogo.continuaMinijogo(atual.getRespostas())){
            return true;
        }
        atual.stopClock();
        return false;
    }

    public boolean minijogoVitoria(){
        if(minijogo.vitoriaMinijogo(atual.getTempo(), atual.getRespostas())){
            return true;
        }
        addLog("Jogador " + atual.getNome() + " perdeu um minijogo.\n");
        addLog(tabuleiro.toString());
        return false;
    }

    public void mudaMinijogo(){
        atual.mudaMinijogo();
    }

    public void atribuiEspecial(){
        addLog("Jogador " + atual.getNome() + " ganhou o minijogo e uma peça especial.\n");
        addLog(tabuleiro.toString());
        addJogadorLog();
        atual.incrementaEspecial(1);
    }

    public void incrementaJogadas(){ atual.incrementaJogadas(); }

    public void resetRespostas(){ atual.resetRespostas(); }

    public void mantemJogador(int jogador) {
        if (jogador == 1) {
            atual = j1;
            prox = j2;
        } else {
            atual = j2;
            prox = j1;
        }
    }

    public void removeCreditos(int creditos){
        atual.removeCreditos(creditos);
        addLog("Foi removido um crédito ao jogador " + atual.getNome() + ".\n");
    }

    public void resetJogadas(){
        atual.resetJogadas();
        addLog("As jogadas até ao mini-jogo foram resetadas para o jogador " + atual.getNome() + ".\n");
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

    public int getEspecial(){
        return atual.getEspecial();
    }

    public int getCreditos(){
        return atual.getCreditos();
    }

    public void terminaJogo(){
        j1 = null;
        j2 = null;
    }

    public void terminaJogoAtual(){
        iniciaJogo();
    }

    public String[][] getTabuleiro() { return tabuleiro.getTabuleiro(); }

    private void addLog(String a){
        logJogada.add(a);
    }

    private void addLogCompleto(){
        for(String s : logJogada){
            logCompleto.add(s);
        }
    }

    private void addJogadorLog(){
        addLog("\nÉ a/o " + atual.getNome() + " com a ficha " + atual.getFicha() + " a decidir.");
    }

    public List<String> getLogJogada(){
        addLogCompleto();
        List<String> aux;
        aux = logJogada;
        logJogada = new ArrayList<>();
        return aux;
    }

    public List<String> getLogCompleto(){
        return logCompleto;
    }
}
