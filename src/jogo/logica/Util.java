package jogo.logica;

import java.io.*;

public class Util {
    public static boolean gravaJogo(JogoGestao x, String nomeFicheiro){
        ObjectOutputStream out = null;

        try{
            out = new ObjectOutputStream(new FileOutputStream(nomeFicheiro));
            out.writeObject(x);
            return true;
        }catch(IOException e){
            return false;
        }finally{
            if(out != null){
                try{
                    out.close();
                }catch(IOException e){
                    return false;
                }
            }
        }
    }

    public static JogoGestao recuperaJogo(String nomeFicheiro) throws IOException, ClassNotFoundException{
        JogoGestao x;
        ObjectInputStream in = null;

        try{
            in = new ObjectInputStream(new FileInputStream(nomeFicheiro));
            x = (JogoGestao) in.readObject();
        }finally{
            if(in != null){
                in.close();
            }
        }
        return x;
    }
}
