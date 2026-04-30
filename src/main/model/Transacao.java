package model;

public class Transacao {

    private double valor;
    private String localizacaoUsuario;
    private String localizacaoTransacao;
    private boolean autenticado;

    private int scoreRisco = 0; // NOVO

    public Transacao(double valor, String localizacaoUsuario, String localizacaoTransacao, boolean autenticado) {
        this.valor = valor;
        this.localizacaoUsuario = localizacaoUsuario;
        this.localizacaoTransacao = localizacaoTransacao;
        this.autenticado = autenticado;
    }

    public double getValor() {
        return valor;
    }

    public String getLocalizacaoUsuario() {
        return localizacaoUsuario;
    }

    public String getLocalizacaoTransacao() {
        return localizacaoTransacao;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public int getScoreRisco() {
        return scoreRisco;
    }

    public void adicionarRisco(int pontos) {
        this.scoreRisco += pontos;
    }
}