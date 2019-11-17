package com.kdnakt.sandbox.generics.io;

import java.util.Date;

public abstract class BarHandler extends LoggerHandler {

    @Override
    protected Date doHandle(final String s) {
        return new Date(parseString(s));
    }

    abstract long parseString(String s);

}
