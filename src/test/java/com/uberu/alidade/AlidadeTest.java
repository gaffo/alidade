package com.uberu.alidade;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class AlidadeTest {
    @Test public void basicField() throws Exception {
        Alidade alidade = new Alidade();

        FlatSingleField toFill = new FlatSingleField();
        alidade.fill(toFill, r("/single_field_with_id.html"));

        assertEquals("BLARG", toFill.mapped);
    }

    @Test public void basicAttribute() throws Exception {
        Alidade alidade = new Alidade();

        Link toFill = new Link();
        alidade.fill(toFill, r("/link.html"));

        assertEquals("hi", toFill.href);
    }

    @Test public void basicHtml() throws Exception {
        Alidade alidade = new Alidade();

        HtmlPojo toFill = new HtmlPojo();
        alidade.fill(toFill, r("/gethtml.html"));

        assertEquals("<tbody></tbody>", toFill.html);
    }

    @Test public void simpleSelector() throws Exception {
        Alidade alidade = new Alidade();

        LinkBySelector toFill = new LinkBySelector();
        alidade.fill(toFill, r("/link.html"));

        assertEquals("hi", toFill.href);
    }

    @Test public void basicCollection() throws Exception {
        Alidade alidade = new Alidade();

        MultiLinks toFill = new MultiLinks();
        alidade.fill(toFill, r("/multi-links.html"));

        assertEquals(10, toFill.links.size());
        assertEquals("7", toFill.links.get(6));
    }

    private InputStream r(String s) {
        return getClass().getResourceAsStream(s);
    }
}
