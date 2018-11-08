package org.rodrigez.commands;

import org.rodrigez.routing.Request;
import org.rodrigez.routing.ModelException;

public abstract class Handler {

    public abstract void execute(Request request);
}