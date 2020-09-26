package com.kdnakt.simple;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AppTest {

    private App app = new App();

    @Test
    public void testSimple() {
        assertEquals(2, app.add(1, 1));
    }

}
