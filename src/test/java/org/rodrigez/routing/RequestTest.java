package org.rodrigez.routing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestTest {
    private static Request request = new Request();

    @BeforeEach
    void setUp() {
        request.setAttribute("attr1", "t");
    }

    @Test
    void getAttribute() throws ModelException {
        Assertions.assertEquals(1, request.getAttribute("attr1"));
        Throwable thrown = assertThrows(ModelException.class, ()->{
            request.getAttribute("attr2");
        });
        Assertions.assertNotNull(thrown.getMessage());
    }
}