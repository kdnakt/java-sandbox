package com.kdnakt.sandbox.generics;

import org.springframework.core.GenericTypeResolver;

public abstract class SpringContainer<T extends Object> {

    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public SpringContainer() {
        this.clazz = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), SpringContainer.class);
    }

    public void print() {
        System.out.println(clazz);
    }

}
