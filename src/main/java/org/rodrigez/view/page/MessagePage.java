package org.rodrigez.view.page;

import org.rodrigez.view.Page;

public class MessagePage implements Page {

    @Override
    public void show(Object object) {
        String message = (String) object;
        System.out.println(message);
    }
}
