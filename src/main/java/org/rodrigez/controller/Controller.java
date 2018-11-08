package org.rodrigez.controller;

import org.rodrigez.commands.*;
import org.rodrigez.routing.Request;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private Map<String, Handler> routes = new HashMap<>();
    {
        routes.put("create-specification", new CreateSpecificationHandler());
        routes.put("provide-specification", new ProvideSpecificationHandler());
        routes.put("register-specification", new RegisterSpecificationHandler());
        routes.put("bill-cost", new BillCostHandler());
        routes.put("create-crew", new CreateCrewHandler());
    }

    public void execute(Request request){
        String path = request.getAttribute("handler");
        Handler handler = routes.get(path);
        handler.execute(request);
    }
}
