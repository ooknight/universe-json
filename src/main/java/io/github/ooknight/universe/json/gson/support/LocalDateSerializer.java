package io.github.ooknight.universe.json.gson.support;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateSerializer implements JsonSerializer<LocalDate> {

    private final String format;

    public LocalDateSerializer(String format) {
        this.format = format;
    }

    @Override
    public JsonElement serialize(LocalDate src, Type type, JsonSerializationContext context) {
        return new JsonPrimitive(src.format(DateTimeFormatter.ofPattern(format)));
    }

}
