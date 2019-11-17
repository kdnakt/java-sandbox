package com.kdnakt.sandbox.generics.io;

public interface Handler<I, O> {

    O handle(I i);

}
