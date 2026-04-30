package handler;

import model.Transacao;

public class ValorAltoHandler extends AbstractHandler {

    @Override
    public boolean handle(Transacao transacao) {
        if (transacao.getValor() > 10000) {
            System.out.println("Transação com valor alto detectada.");
        }
        return next(transacao);
    }
}