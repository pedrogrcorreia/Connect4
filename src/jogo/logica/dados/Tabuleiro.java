package jogo.logica.dados;

import java.io.Serializable;

public class Tabuleiro implements Serializable {
    private String[][] tab;

    public Tabuleiro(){
        tab = new String[6][7];
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                tab[i][j] = " ";
            }
        }
    }

    public boolean joga(int col, String ficha){
        if(col<0 || col > 6) {
            return false;
        }
        for(int i=0; i<6; i++){
            if(tab[0][col].compareToIgnoreCase(" ")!=0){
                return false;
            }
            if(tab[i][col].compareToIgnoreCase(" ") != 0){
                tab[i-1][col] = ficha;
                return true;
            }
        }
        tab[5][col] = ficha;
        return true;
    }

    public boolean verificaVitoria(int col, String ficha){
        int linha = 0;
        int conta;

        // obtem a linha
        for(int i=0; i<6; i++){
            if(tab[i][col].compareToIgnoreCase(" ") != 0){
                linha = i;
                break;
            }
        }

        // pesquisa na vertical
        conta = 0;
        for(int i=linha; i<6; i++){
            if(tab[i][col].compareToIgnoreCase(ficha) == 0){
                conta++;
            }
            else{
                break;
            }
        }

        if(conta == 4){
            return true;
        }

        // pesquisa horizontal frente
        conta = 0;
        for(int i=col; i<7; i++){
            if(tab[linha][i].compareToIgnoreCase(ficha) == 0){
                conta++;
            }
            else{
                break;
            }
        }
        // pesquisa horizontal tras
        for(int i=col-1; i>=0; i--){
            if(tab[linha][i].compareToIgnoreCase(ficha) == 0){
                conta++;
            }
            else{
                break;
            }
        }

        if(conta == 4){
            return true;
        }

        // quadrantes pares frente
        conta=0;
        int coluna=col;
        for(int i=linha; i<6; i++){
            if(tab[i][coluna].compareToIgnoreCase(ficha) == 0){
                conta++;
                if(coluna < 6){
                    coluna++;
                }
            }
            else{
                break;
            }
        }
        // quadrantes pares tras
        coluna = col-1;
        if(coluna <= 0){
            coluna = 0;
        }
        for(int i=linha-1; i>=0; i--){
            if(tab[i][coluna].compareToIgnoreCase(ficha) == 0){
                conta++;
                if(coluna > 0){
                    coluna--;
                }
            }
            else{
                break;
            }
        }
        if(conta == 4){
            return true;
        }

        // quadrantes impares tras
        conta = 0;
        coluna = col;
        for(int i=linha; i<6; i++){
            if(tab[i][coluna].compareToIgnoreCase(ficha) == 0){
                conta++;
                if(coluna > 0){
                    coluna--;
                }
            }
            else{
                break;
            }
        }
        // quadrantes impares frente
        coluna = col+1;
        if(coluna >= 7){
            coluna = 6;
        }
        for(int i=linha-1; i>=0; i--){
            if(tab[i][coluna].compareToIgnoreCase(ficha) == 0){
                conta++;
                if(coluna < 6){
                    coluna++;
                }
            }
            else{
                break;
            }
        }
        if(conta == 4){
            return true;
        }

        return false;
    }

    public boolean jogaEspecial(int col){
        if(col<0 || col > 6) {
            return false;
        }
        for(int i=0; i<6; i++){
            tab[i][col] = " ";
        }
        return true;
    }

    public boolean cheio(){
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                if(tab[i][j].compareToIgnoreCase(" ") == 0){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("_______________\n");
        sb.append("\n 1 2 3 4 5 6 7 \n");
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                if(j==0){
                    sb.append("|");
                }
                sb.append(tab[i][j]+"|");
            }
            sb.append("\n");
        }
        //sb.append("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        return sb.toString();
    }
}
