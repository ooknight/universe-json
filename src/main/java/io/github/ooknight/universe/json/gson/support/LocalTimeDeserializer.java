package io.github.ooknight.universe.json.gson.support;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeDeserializer implements JsonDeserializer<LocalTime> {

    private final String format;

    public LocalTimeDeserializer(String format) {
        this.format = format;
    }

    @Override
    public LocalTime deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        return LocalTime.parse(json.getAsString(), DateTimeFormatter.ofPattern(format));
    }

}
