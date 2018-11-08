package org.rodrigez.routing;

import java.util.HashMap;

public class Request {
    private HashMap<String,String> attributes = new HashMap<>();

    public String getAttribute(String key) {
        return attributes.get(key);
    }

    public void setAttribute(String key, String value){
        attributes.put(key, value);
    }
}
