package handler;

import model.Transacao;

public interface Handler {

    void setNext(Handler next);

    boolean handle(Transacao transacao);
}