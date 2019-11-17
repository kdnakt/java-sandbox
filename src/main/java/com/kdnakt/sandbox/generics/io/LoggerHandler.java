package com.kdnakt.sandbox.generics.io;

import java.util.Date;

public abstract class LoggerHandler implements Handler<String, Date> {

    @Override
    public Date handle(final String s) {
        System.out.printf("Input: %s\n", s);
        final Date date = doHandle(s);
        System.out.printf("Date: %tF\n", date);
        return date;
    }

    protected abstract Date doHandle(String s);

}
