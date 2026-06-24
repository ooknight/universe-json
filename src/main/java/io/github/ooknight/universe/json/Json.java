package io.github.ooknight.universe.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.ooknight.universe.json.gson.support.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Json {

    public static final Json json = new Json();

    private static final Gson gson;

    static {
        gson = new GsonBuilder()
            .setDateFormat(Constant.FORMAT_DATE_TIME)
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer(Constant.FORMAT_DATE_TIME))
            .registerTypeAdapter(LocalDate.class, new LocalDateSerializer(Constant.FORMAT_DATE))
            .registerTypeAdapter(LocalTime.class, new LocalTimeSerializer(Constant.FORMAT_TIME))
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer(Constant.FORMAT_DATE_TIME))
            .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer(Constant.FORMAT_DATE))
            .registerTypeAdapter(LocalTime.class, new LocalTimeDeserializer(Constant.FORMAT_TIME))
            .create();
    }

    public String string(Object object) {
        return gson.toJson(object);
    }

    public <T> T parse(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

}
