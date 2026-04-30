package handler;

import model.Transacao;

public class LocalizacaoHandler extends AbstractHandler {

    @Override
    public boolean handle(Transacao transacao) {
        if (!transacao.getLocalizacaoUsuario().equals(transacao.getLocalizacaoTransacao())) {
            System.out.println("Localização suspeita: +40 risco");
            transacao.adicionarRisco(40);
        }
        return next(transacao);
    }
}