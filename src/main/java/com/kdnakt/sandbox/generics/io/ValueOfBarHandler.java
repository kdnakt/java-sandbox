package com.kdnakt.sandbox.generics.io;

public class ValueOfBarHandler extends BarHandler {

    @Override
    long parseString(final String s) {
        return Long.valueOf(s);
    }

}
