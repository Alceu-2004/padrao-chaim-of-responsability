package handler;

import model.Transacao;

public class HistoricoHandler extends AbstractHandler {

    @Override
    public boolean handle(Transacao transacao) {
        System.out.println("Verificando histórico do usuário...");
        return next(transacao);
    }
}