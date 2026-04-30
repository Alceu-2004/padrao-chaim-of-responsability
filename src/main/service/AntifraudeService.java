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
        return chain.handle(transacao);
    }
}