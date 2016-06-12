package com.uberu.alidade;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.reflections.ReflectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Set;

import static org.reflections.ReflectionUtils.withAnnotation;

public class Alidade {
    public void fill(Object toFill, InputStream resourceAsStream) throws IOException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Document soup = Jsoup.parse(resourceAsStream, "UTF-8", "");

        Set<Field> fields = ReflectionUtils.getFields(toFill.getClass(), withAnnotation(Mapping.class));
        for (Field field: fields) {
            Mapping mapping = field.getAnnotation(Mapping.class);
            String css = mapping.css();
            Elements nodes = soup.select(css);
            if (nodes.isEmpty()) {
                continue;
            }

            Class aClass = field.getType();
            if (Collection.class.isAssignableFrom(aClass)) {
                fillCollection(toFill, field, mapping, nodes);
            } else {
                fillBasic(toFill, field, mapping, nodes);
            }
        }
    }

    private void fillCollection(Object toFill, Field field, Mapping mapping, Elements nodes) throws IllegalAccessException, InstantiationException {
        Collection c = (Collection) field.get(toFill);

        for (Element e: nodes) {
            AlidadeElement ae = new AlidadeElement(e);
            Object value = mapping.from().newInstance().get(ae, mapping.args());
            c.add(value);
        }
    }

    private void fillBasic(Object toFill, Field field, Mapping mapping, Elements nodes) throws IllegalAccessException, InstantiationException {
        AlidadeElement ae = new AlidadeElement(nodes.get(0));
        FieldUtils.writeField(field, toFill, mapping.from().newInstance().get(ae, mapping.args()));
    }
}
