package service;

import handler.*;
import model.Transacao;

public class AntifraudeService {

    private Handler chain;

    public AntifraudeService() {
        Handler valor = new ValorAltoHandler();
        Handler localizacao = new LocalizacaoHandler();
        Handler historico = new HistoricoHandler();
        Handler autenticacao = new AutenticacaoHandler();

        valor.setNext(localizacao);
        localizacao.setNext(historico);
        historico.setNext(autenticacao);

        this.chain = valor;
    }

    public boolean processar(Transacao transacao) {
        boolean passouNaChain = chain.handle(transacao);

        if (!passouNaChain) {
            return false;
        }

        System.out.println("Score final: " + transacao.getScoreRisco());

        if (transacao.getScoreRisco() > 50) {
            System.out.println("Transação REPROVADA por alto risco");
            return false;
        }

        return true;
    }
}