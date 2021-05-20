package jogo.logica.dados;

public class Dados {
    private Tabuleiro tabuleiro;
    private int modo;
    private Jogador j1, j2, atual, prox;
    public Dados(){};

    public boolean escolheModo(int opc){
        modo = opc;
        return true;
    }

    public int getModo(){
        return modo;
    }

    public boolean configuraJogador(String s){
        if(modo == 1){
            if(j1 == null) {
                j1 = new JogadorH(s, "O");
                return false;
            }
            else{
                if(j1.getNome().compareToIgnoreCase(s) == 0){
                    return false;
                }
                j2 = new JogadorH(s, "X");
                iniciaJogo();
                return true;
            }
        }
        if(modo == 2){
            j1 = new JogadorH(s, "O");
            j2 = new JogadorC("X");
            iniciaJogo();
            return true;
        }
        if(modo == 3){
            j1 = new JogadorC("O");
            j2 = new JogadorC("X");
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
            return true;
        }
        return false;
    }

    public boolean efetuaJogadaPC(){
        atual.addCol(0);
        if(tabuleiro.joga(atual.getCol(), atual.getFicha())) {
            return true;
        }
        return false;
    }

    public boolean verificaVitoria(){
        if(!tabuleiro.verificaVitoria(atual.getCol(), atual.getFicha())){
            Jogador aux = atual;
            atual = prox;
            prox = aux;
            return false;
        }
        return true;
    }

    public void terminaJogo(){
        j1 = null;
        j2 = null;
    }

    public int getJogadas(){
        System.out.println(atual.getJogadas());
        return atual.getJogadas();
    }

    public boolean minijogo(String s){
        if(s.compareToIgnoreCase("s") == 0){
            return true;
        }
        return false;
    }

    public String getTabuleiro(){
        return tabuleiro.toString();
    }
}
