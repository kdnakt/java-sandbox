package com.kdnakt.sandbox.generics;

import java.lang.reflect.ParameterizedType;

public abstract class Container<T extends Object> {

    private Class<T> clazz;

    public Container(Class<T> clazz) {
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    public Container() {
        this.clazz = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public void print() {
        System.out.println(clazz);
    }

}
