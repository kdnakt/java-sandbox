package com.kdnakt.sandbox.generics.io;

import java.time.Instant;
import java.util.Date;

public class FooHandler extends LoggerHandler {

    @Override
    protected Date doHandle(final String s) {
        return Date.from(Instant.parse(s));
    }

}
