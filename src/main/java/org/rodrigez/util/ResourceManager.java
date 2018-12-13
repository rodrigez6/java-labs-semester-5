package org.rodrigez.util;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String RESOURCE_NAME = "messages";
    ResourceManager(){
        resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME);
    }
    public void changeResource(Locale locale){
        resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME, locale);
    }
    public String getString(String key){
        return resourceBundle.getString(key);
    }
    public Enumeration getSetKey(){
        return resourceBundle.getKeys();
    }
}
