package logica;

public enum Situacao {
    CONFIGURACAO("Configurar o jogo"),
    ESCOLHE_MODO("Escolher o modo de jogo"),
    JOGADA("Fazer uma jogada"),
    MINIJOGO("Minijogo");

    private final String descricao;
    private Situacao(String descricao){this.descricao = descricao;}


    @Override
    public String toString() {
        return descricao;
    }
}
