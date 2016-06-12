package com.uberu.alidade;

import java.util.ArrayList;
import java.util.List;

public class MultiLinks {
    @Mapping(css="a", from=Text.class) public List<String> links = new ArrayList<>();
}
