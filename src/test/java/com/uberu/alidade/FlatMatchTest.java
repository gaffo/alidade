package com.uberu.alidade;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

public class FlatMatchTest {
    @Test public void basicField() throws IOException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Alidade alidade = new Alidade();

        FlatSingleField toFill = new FlatSingleField();
        alidade.fill(toFill, getClass().getResourceAsStream("/single_field_with_id.html"));

        assertEquals("BLARG", toFill.mapped);
    }

    @Test public void basicAttribute() throws IllegalAccessException, IOException, InvocationTargetException, InstantiationException {
        Alidade alidade = new Alidade();

        Link toFill = new Link();
        alidade.fill(toFill, getClass().getResourceAsStream("/link.html"));

        assertEquals("hi", toFill.href);
    }
}
