package com.uberu.alidade;

/**
 * Created by mike on 6/11/2016.
 */
public class LinkBySelector {
    @Mapping(css="a", from = Atrr.class, args="href") public String href;
}
