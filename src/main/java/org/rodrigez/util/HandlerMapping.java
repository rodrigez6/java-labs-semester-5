package org.rodrigez.util;

import org.rodrigez.controller.handlers.*;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
    private Map<String, Handler> map = new HashMap<>();


    {
        map.put("add-specification", new AddSpecificationHandler());
        map.put("register-specifications", new RegisterSpecificationHandler());
        map.put("update-cost", new UpdateCostHandler());
        map.put("update-crew", new UpdateCrewHandler());
        map.put("login", new LoginHandler());
        map.put("menu", new MenuHandler());
        map.put("logout", new LogoutHandler());
        map.put("get-customer-specifications", new GetCustomerSpecificationsHandler());
        map.put("get-manager-specifications", new GetManagerSpecificationsHandler());
        map.put("get-designer-specifications", new GetDesignerSpecificationsHandler());
        map.put("save-specification", new SaveSpecificationHandler());
        map.put("customer-menu", new MenuCustomerHandler());
        map.put("manager-menu", new MenuManagerHandler());
        map.put("designer-menu", new MenuDesignerHandler());
    }

    private static HandlerMapping instance = new HandlerMapping();

    public static HandlerMapping getInstance(){
        return instance;
    }

    public Handler get(String s){
        return map.get(s);
    }
}
