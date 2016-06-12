package com.uberu.alidade;

public class Atrr implements AlidadeGetter {
    private String href;

    public Object get(AlidadeElement element, String arg) {
        return element.attr(arg);
    }
}
