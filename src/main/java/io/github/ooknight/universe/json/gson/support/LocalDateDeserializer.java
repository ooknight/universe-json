package io.github.ooknight.universe.json.gson.support;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateDeserializer implements JsonDeserializer<LocalDate> {

    private final String format;

    public LocalDateDeserializer(String format) {
        this.format = format;
    }

    @Override
    public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        return LocalDate.parse(json.getAsString(), DateTimeFormatter.ofPattern(format));
    }

}
