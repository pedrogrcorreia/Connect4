package logica.dados;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private String[][] tab;

    public Tabuleiro(){
        tab = new String[6][7];
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                tab[i][j] = "*";
            }
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                sb.append(tab[i][j]+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
