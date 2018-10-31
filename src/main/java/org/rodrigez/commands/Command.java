package org.rodrigez.commands;

import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;

public abstract class Command {
    private Command next;

    public Command linkWith(Command next){
        this.next = next;
        return next;
    }

    public abstract String execute(Request request) throws RequestException;

    String executeNext(Request request) throws RequestException {
        if(next == null) {
            return "info";
        }
        return next.execute(request);
    }
}