package org.rodrigez.commands;

import org.rodrigez.routing.Request;
import org.rodrigez.routing.RequestException;

public abstract class Command {

    public abstract void execute(Request request) throws RequestException;
}