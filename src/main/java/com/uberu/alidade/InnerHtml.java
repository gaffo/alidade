package com.uberu.alidade;

/**
 * Created by mike on 6/11/2016.
 */
public class InnerHtml implements AlidadeGetter {
    public Object get(AlidadeElement e, String arg) {
        return e.innerHtml();
    }
}
