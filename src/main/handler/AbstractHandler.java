package handler;

import model.Transacao;

public abstract class AbstractHandler implements Handler {

    protected Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    protected boolean next(Transacao transacao) {
        if (next == null) {
            return true;
        }
        return next.handle(transacao);
    }
}