package org.rodrigez.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum BeanStorage {

    INSTANCE;

    Map<String, Object> objects = new ConcurrentHashMap<>();

    public void add(String name, Object object){
        objects.put(name,object);
    }

    public <T> void add(Class<T> clazz, T object){
        add(clazz.getName(), object);
    }

    public Object get(String name){
        return objects.get(name);
    }

    public <T> T get(Class<T> clazz){
        return (T) get(clazz.getName());
    }

}
