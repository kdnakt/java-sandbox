package com.kdnakt.sandbox.generics.io;

import java.util.Date;

public class BadStringHandler implements Handler<String, Date> {

    @Override
    public Date handle(final String s) {
        return null;
    }

}
