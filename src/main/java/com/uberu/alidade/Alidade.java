package com.uberu.alidade;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.reflections.ReflectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import static org.reflections.ReflectionUtils.withAnnotation;

/**
 * Created by mike on 6/11/2016.
 */
public class Alidade {
    public void fill(Object toFill, InputStream resourceAsStream) throws IOException, InvocationTargetException, IllegalAccessException {
        Document soup = Jsoup.parse(resourceAsStream, "UTF-8", "");

        Set<Field> fields = ReflectionUtils.getFields(toFill.getClass(), withAnnotation(Mapping.class));
        for (Field field: fields) {
            Mapping mapping = field.getAnnotation(Mapping.class);
            String css = mapping.value();
            Elements nodes = soup.select(css);
            if (nodes.isEmpty()) {
                continue;
            }
            String text = nodes.first().text();
            FieldUtils.writeField(field, toFill, text);
        }
    }
}
