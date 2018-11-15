package org.rodrigez.util;

import org.rodrigez.controller.handlers.*;

import java.util.HashMap;
import java.util.Map;

public class HandlerManager {
    private Map<String, Handler> handlerMap = new HashMap<>();
    {
        handlerMap.put("add-specification", new AddSpecificationHandler());
        handlerMap.put("register-specifications", new RegisterSpecificationHandler());
        handlerMap.put("bill-cost", new BillCostHandler());
        handlerMap.put("create-crew", new CreateCrewHandler());
        handlerMap.put("login", new LoginHandler());
        handlerMap.put("menu", new MenuHandler());
        handlerMap.put("logout", new LogoutHandler());
        handlerMap.put("get-customer-specifications", new GetCustomerSpecificationsHandler());
        handlerMap.put("get-manager-specifications", new GetManagerSpecificationsHandler());
        handlerMap.put("get-designer-specifications", new GetDesignerSpecificationsHandler());
        handlerMap.put("save-specification", new SaveSpecificationHandler());
        handlerMap.put("customer-menu", new MenuCustomerHandler());
        handlerMap.put("manager-menu", new MenuManagerHandler());
        handlerMap.put("designer-menu", new MenuDesignerHandler());
    }

    private static HandlerManager instance = new HandlerManager();

    public static HandlerManager getInstance(){
        return instance;
    }

    public Handler get(String s){
        return handlerMap.get(s);
    }
}
