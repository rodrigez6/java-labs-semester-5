package org.rodrigez.routing;

import java.util.HashMap;

public class Request {
    private HashMap<String,Object> attributes = new HashMap<>();

    public Object getAttribute(String key) throws RequestException {
        Object value = attributes.get(key);
        if (value==null) throw new RequestException("No such attribute");
        return value;
    }

    public void setAttribute(String key, Object value){
        attributes.put(key, value);
    }
}
