package jogo.logica.dados;

public class MinijogoMatematica {

    private int n1, n2, res;
    private String operator;

    public String getJogo(){
        int max = 1;
        int min = 99;
        n1 = (int)Math.floor(Math.random()*(max-min+1)+min);
        n2 = (int)Math.floor(Math.random()*(max-min+1)+min);
        switch((int)Math.floor(Math.random()*(4-1+1)+1)){
            case 1:
                operator = "+";
                res = n1 + n2;
            case 2:
                operator = "-";
                res = n1 - n2;
            case 3:
                operator = "/";
                res = n1 / n2;
            case 4:
                operator = "*";
                res = n1 * n2;
        }
        String op = n1 + operator + n2;
        System.out.println(op);
        return op;
    }
}
