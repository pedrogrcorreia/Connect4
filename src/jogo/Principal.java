package jogo;

import jogo.logica.Jogo;
import jogo.logica.JogoGestao;
import jogo.logica.Util;
import jogo.ui.texto.UIText;
import jogo.logica.Util.*;

import java.io.IOException;

import static jogo.logica.Util.gravaJogo;

public class Principal {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JogoGestao jGestao = new JogoGestao();
        UIText uiText = new UIText(jGestao);
        //uiText.run();
//        Util u = new Util();
//        Util.gravaReplay(jGestao);
//        Util.gravaReplay(jGestao);
//        Util.gravaReplay(jGestao);
//        Util.gravaReplay(jGestao);
//        Util.gravaReplay(jGestao);
//        Util.recuperaReplay(2);
//        Util.gravaReplay(jGestao);
        uiText.run();
//        teste1();
    }
}
//
//    static class Tabuleiro{
//        String[][] tab;
//        Tabuleiro(){
//            tab = new String[6][7];
//            for(int i=0; i<6; i++){
//                for(int j=0; j<7; j++){
//                    tab[i][j] = "*";
//                }
//            }
//        }
//
//        public boolean joga(int col){
//            if(col<0 || col > 6)
//                return false;
//            for(int i=0; i<6; i++){
//                if(tab[0][col].compareToIgnoreCase("*")!=0){
//                    return false;
//                }
//                if(tab[i][col].compareToIgnoreCase("*") != 0){
//                    tab[i-1][col] = "+";
//                    return true;
//                }
//            }
//            tab[5][col] = "+";
//            return true;
//        }
//
//        @Override
//        public String toString() {
//            StringBuilder sb = new StringBuilder();
//            for(int i=0; i<6; i++){
//                for(int j=0; j<7; j++){
//                    sb.append(tab[i][j]+" ");
//                }
//                sb.append("\n");
//            }
//            return sb.toString();
//        }
//    }
//
//     public static void teste1(){
//        Tabuleiro tab = new Tabuleiro();
//        System.out.println(tab);
//        tab.joga(3);
//        tab.joga(3);
//        tab.joga(3);
//        System.out.println(tab);
//    }
//}
