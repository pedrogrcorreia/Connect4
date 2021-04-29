package logica.dados;

import java.util.ArrayList;
import java.util.List;

public class Dados {
    private Tabuleiro tab;
    private Modo modo;

    public Dados(){
        tab = new Tabuleiro();
    }

    public boolean escolheModo(int opt){
        if(opt == 1){
            modo = new HvH();
            return true;
        }
        if(opt == 2){
            modo = new HvC();
            return true;
        }
        if(opt == 3){
            modo = new CvC();
            return false;
        }
        return false;
    }

    public boolean configuraJogo(String s){
        return modo.addJogador(new Jogador(s));
    }

    public String getTabuleiro(){
        return tab.toString();
    }
}
