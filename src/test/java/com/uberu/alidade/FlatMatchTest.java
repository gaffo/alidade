package com.uberu.alidade;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

public class FlatMatchTest {
    @Test public void emptyObject() throws IOException, InvocationTargetException, IllegalAccessException {
        Alidade alidade = new Alidade();

        FlatSingleField toFill = new FlatSingleField();
        alidade.fill(toFill, getClass().getResourceAsStream("/single_field_with_id.html"));

        assertEquals("BLARG", toFill.mapped);
    }
}
