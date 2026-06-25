package io.github.ooknight.universe.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import io.github.ooknight.universe.json.gson.support.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Jsoner {

    public static final Jsoner jsoner = new Jsoner();

    private static final Gson gson;
    private static final Configuration configuration;

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
        configuration = Configuration.builder()
            .jsonProvider(new GsonJsonProvider())
            .build();
    }

    public String json(Object object) {
        return gson.toJson(object);
    }

    public String string(String json, String path) {
        return JsonPath.using(configuration).parse(json).read(path);
    }

    public <T> T parse(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

}
