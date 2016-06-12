package com.uberu.alidade;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlidadeTest {
    @Test public void basicField() throws Exception {
        Alidade alidade = new Alidade();

        FlatSingleField toFill = new FlatSingleField();
        alidade.fill(toFill, getClass().getResourceAsStream("/single_field_with_id.html"));

        assertEquals("BLARG", toFill.mapped);
    }

    @Test public void basicAttribute() throws Exception {
        Alidade alidade = new Alidade();

        Link toFill = new Link();
        alidade.fill(toFill, getClass().getResourceAsStream("/link.html"));

        assertEquals("hi", toFill.href);
    }

    @Test public void basicHtml() throws Exception {
        Alidade alidade = new Alidade();

        HtmlPojo toFill = new HtmlPojo();
        alidade.fill(toFill, getClass().getResourceAsStream("/gethtml.html"));

        assertEquals("<tbody></tbody>", toFill.html);
    }

    @Test public void simpleSelector() throws Exception {
        Alidade alidade = new Alidade();

        LinkBySelector toFill = new LinkBySelector();
        alidade.fill(toFill, getClass().getResourceAsStream("/link.html"));

        assertEquals("hi", toFill.href);
    }
}
