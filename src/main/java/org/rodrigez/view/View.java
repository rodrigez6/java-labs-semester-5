package org.rodrigez.view;

public interface View {
    void write(Object o);
    Object read(Class aClass);
}