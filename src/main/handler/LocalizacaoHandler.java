package handler;

import model.Transacao;

public class LocalizacaoHandler extends AbstractHandler {

    @Override
    public boolean handle(Transacao transacao) {
        if (!transacao.getLocalizacaoUsuario().equals(transacao.getLocalizacaoTransacao())) {
            System.out.println("Localização suspeita detectada.");
        }
        return next(transacao);
    }
}