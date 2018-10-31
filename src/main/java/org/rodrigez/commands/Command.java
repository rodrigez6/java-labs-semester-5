package org.rodrigez.commands;

import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;

public abstract class Command {
    private Command next;

    public Command linkWith(Command next){
        this.next = next;
        return next;
    }

    public abstract void execute(Request request) throws RequestException;

    void executeNext(Request request){
        if(next == null) {
            return;
        }
        try {
            next.execute(request);
        } catch (RequestException e){
            request.setAttribute("message", e.getMessage());
        }
    }
}