package com.epopovic.points;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestJunit {

    @Test
    public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine",str);
    }
}
