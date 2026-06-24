package io.github.ooknight.universe.json.gson.support;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeSerializer implements JsonSerializer<LocalTime> {

    private final String format;

    public LocalTimeSerializer(String format) {
        this.format = format;
    }

    @Override
    public JsonElement serialize(LocalTime src, Type type, JsonSerializationContext context) {
        return new JsonPrimitive(src.format(DateTimeFormatter.ofPattern(format)));
    }

}
