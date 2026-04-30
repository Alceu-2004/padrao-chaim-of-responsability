package handler;

import model.Transacao;

public class HistoricoHandler extends AbstractHandler {

    @Override
    public boolean handle(Transacao transacao) {
        System.out.println("Histórico analisado: +20 risco");
        transacao.adicionarRisco(20);
        return next(transacao);
    }
}