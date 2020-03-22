package com.kdnakt.sandbox.generics.io;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.reflections.Reflections;
import org.springframework.core.GenericTypeResolver;

public class ShouldExtendsTest {

    private static final List<String> ignore = Arrays.asList("BadStringHandler");

    @SuppressWarnings("rawtypes")
    @Test
    public void test() {
        final Reflections reflections = new Reflections("com.kdnakt.sandbox.generics.io");
        final Set<Class<? extends Handler>> classes = reflections.getSubTypesOf(Handler.class);
        for (Class<? extends Handler> clazz : classes) {
            final Class input = GenericTypeResolver.resolveTypeArguments(clazz, Handler.class)[0];
            if ("String".equals(input.getSimpleName())) {
                Class curr = clazz;
                Class superClass = clazz;
                do {
                    curr = superClass;
                    superClass = curr.getSuperclass();
                } while (superClass.getSuperclass() != null
                        && (!"Object".equals(superClass.getSimpleName()) || !"Object".equals(curr.getSimpleName())));
                assertTrue(String.format(
                        "Handler accepts String should extends com.kdnakt.sandbox.generics.io.LoggerHandler: %s",
                        clazz.getSimpleName()),
                        "LoggerHandler".equals(curr.getSimpleName()) || ignore.contains(curr.getSimpleName()));
            }
        }
    }

}
