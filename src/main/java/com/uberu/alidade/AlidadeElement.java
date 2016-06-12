package com.uberu.alidade;

import org.jsoup.nodes.Element;

public class AlidadeElement {
    private Element element;

    public AlidadeElement(Element element) {
        this.element = element;
    }

    public String text() {
        return element.text();
    }

    public String attr(String arg) {
        return element.attr(arg);
    }

    public Object innerHtml() {
        return element.html();
    }
}
