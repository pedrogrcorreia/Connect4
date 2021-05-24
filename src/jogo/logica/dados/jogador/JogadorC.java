package jogo.logica.dados.jogador;

public class JogadorC extends JogadorAdapter {
    private String nome;
    private String ficha;
    private int colJogada;
    static private int id;

    public JogadorC(String ficha){
        if(id == 0) {
            nome = "Alexa";
        }
        else{
            nome = "Siri";
        }
        id++;
        this.ficha = ficha;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getFicha(){
        return ficha;
    }

    @Override
    public int getCol(){ return colJogada; }

    @Override
    public void addCol(int col) {
        colJogada = col;
    }

    @Override
    public int randomCol() {
        int max = 6;
        int min = 0;
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jogador " + nome + " jogou na coluna " + (colJogada+1) + ".");
        return sb.toString();
    }
}
