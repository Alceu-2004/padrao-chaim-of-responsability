package handler;

import model.Transacao;

public class AutenticacaoHandler extends AbstractHandler {

    @Override
    public boolean handle(Transacao transacao) {
        if (!transacao.isAutenticado()) {
            System.out.println("Falha na autenticação.");
            return false;
        }
        return next(transacao);
    }
}