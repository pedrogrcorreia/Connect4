package jogo.logica.dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dados implements Serializable {
    private Tabuleiro tabuleiro;
    private int modo;
    private Jogador j1, j2, atual, prox;
    private List<String> logCompleto;

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

    public void iniciaJogo(){
        tabuleiro = new Tabuleiro();
        atual = j1;
        prox = j2;
    }

    public boolean efetuaJogada(int col){
        atual.addCol(col-1);
        if(tabuleiro.joga(atual.getCol(), atual.getFicha())) {
            atual.incrementaJogadas();
            addLog(atual.toString());
            proxJogador();
            return true;
        }
        return false;
    }

    public boolean efetuaJogadaPC(){
        int colArt = atual.getCol();
        if(tabuleiro.joga(colArt, atual.getFicha())) {
            addLog(atual.toString());
            proxJogador();
            return true;
        }
        return false;
    }

    public boolean verificaVitoria(){
        if(!tabuleiro.verificaVitoria(atual.getCol(), atual.getFicha())){
            return false;
        }
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
            return true;
        }
        return false;
    }

    public boolean getMinijogo(){
        MinijogoMatematica m = new MinijogoMatematica();
        m.getJogo();
        return true;
    }

    public int getCreditos(){
        return atual.getCreditos();
    }

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

    public String getTabuleiro(){
        return tabuleiro.toString();
    }


}
