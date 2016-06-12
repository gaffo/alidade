package com.uberu.alidade;

public class Text implements AlidadeGetter {
    public Object get(AlidadeElement e, String args) {
        return e.text();
    }
}
