package jogo.logica.dados;

import java.io.Serializable;

public class MinijogoMatematica implements Serializable {

    private int n1, n2, res;
    private String operator;

    public void criaJogo(){
        int max = 99;
        int min = 1;
        n1 = (int)Math.floor(Math.random()*(max-min+1)+min);
        n2 = (int)Math.floor(Math.random()*(max-min+1)+min);
        switch((int)Math.floor(Math.random()*(4-1+1)+1)){
            case 1:
                operator = "+";
                res = n1 + n2;
                break;
            case 2:
                operator = "-";
                res = n1 - n2;
                break;
            case 3:
                operator = "/";
                res = n1 / n2;
                break;
            case 4:
                operator = "*";
                res = n1 * n2;
                break;
        }
    }

    public String getJogo(){
        String op = n1 + operator + n2;
        return op;
    }

    public String getResposta(){
        return String.valueOf(res);
    }
}
