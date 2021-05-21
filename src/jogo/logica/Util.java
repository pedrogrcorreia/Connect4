package jogo.logica;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Util {
    public static boolean gravaReplay(JogoGestao x){
        ObjectOutputStream out = null;
        String[] jogos = new String[5];
        File targetDir=new File("replays");
        int proximoJogo = 0;


        File[] files = targetDir.listFiles();
        Arrays.sort(files, Comparator.comparingLong(File::lastModified));
        for(int i=0; i< files.length; i++){
            jogos[i] = files[i].getName();
        }

//        for(String j : jogos){
//            System.out.println(j);
//        }

//        System.out.println(jogos[0]);

        if(jogos.length >= 5){
            File gameToDelete = new File(targetDir, jogos[0]);
            gameToDelete.delete();
            System.out.println("Apaguei o jogo " + jogos[0]);
        }
        if(jogos.length == 0){
            proximoJogo = 1;
        }
        else{
            proximoJogo = Integer.parseInt(jogos[jogos.length-1]);
            proximoJogo++;
        }

        System.out.println(proximoJogo);
        File targetFile=new File(targetDir, String.valueOf(proximoJogo));

        try{
            out = new ObjectOutputStream(new FileOutputStream(targetFile));
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

    public static JogoGestao recuperaReplay(int jogo) throws IOException, ClassNotFoundException{
        JogoGestao x;
        ObjectInputStream in = null;
        String[] jogos = new String[5];
        File targetDir=new File("replays");

        File[] files = targetDir.listFiles();
        Arrays.sort(files, Comparator.comparingLong(File::lastModified));
        for(int i=0; i< files.length; i++){
            jogos[i] = files[i].getName();
        }

        System.out.println(jogos[jogo-1]);

        File targetFile=new File(targetDir, jogos[jogo-1]);

        try{
            in = new ObjectInputStream(new FileInputStream(targetFile));
            x = (JogoGestao) in.readObject();
        }finally{
            if(in != null){
                in.close();
            }
        }
        return x;
    }

}
