package handler;

import model.Transacao;

public class ValorAltoHandler extends AbstractHandler {

    @Override
    public boolean handle(Transacao transacao) {
        if (transacao.getValor() > 10000) {
            System.out.println("Valor alto: +30 risco");
            transacao.adicionarRisco(30);
        }
        return next(transacao);
    }
}