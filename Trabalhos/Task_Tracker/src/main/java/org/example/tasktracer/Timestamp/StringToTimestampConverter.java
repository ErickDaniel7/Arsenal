package org.example.tasktracer.Timestamp;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class StringToTimestampConverter implements Converter<String, Timestamp> {

    private static final String DATE_FORMAT = "yyyy-MM-dd"; // Ajuste o formato conforme necessário

    @Override
    public Timestamp convert(String source) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            return new Timestamp(sdf.parse(source).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid timestamp format: " + source);
        }
    }
}
