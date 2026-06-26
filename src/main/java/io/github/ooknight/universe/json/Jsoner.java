package io.github.ooknight.universe.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.Jackson3JsonProvider;
import tools.jackson.databind.ext.javatime.deser.LocalDateDeserializer;
import tools.jackson.databind.ext.javatime.deser.LocalDateTimeDeserializer;
import tools.jackson.databind.ext.javatime.deser.LocalTimeDeserializer;
import tools.jackson.databind.ext.javatime.ser.LocalDateSerializer;
import tools.jackson.databind.ext.javatime.ser.LocalDateTimeSerializer;
import tools.jackson.databind.ext.javatime.ser.LocalTimeSerializer;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Jsoner {

    private final Configuration configuration;
    private final JsonMapper om;

    private Jsoner(JsonMapper om) {
        this.om = om;
        this.configuration = Configuration.builder().jsonProvider(new Jackson3JsonProvider(om)).build();
    }

    public static Jsoner simple() {
        return Simple.INSTANCE;
    }

    public static Jsoner iso() {
        return Iso.INSTANCE;
    }

    public String json(Object object) {
        return om.writeValueAsString(object);
    }

    public String string(String json, String path) {
        return JsonPath.using(configuration).parse(json).read(path, String.class);
    }

    public <T> T parse(String json, Class<T> clazz) {
        return om.readValue(json, clazz);
    }

    private static class Simple {

        private static final Jsoner INSTANCE;

        static {
            SimpleModule sm = new SimpleModule();
            sm.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(Constant.DTF_DATE_TIME));
            sm.addSerializer(LocalDate.class, new LocalDateSerializer(Constant.DTF_DATE));
            sm.addSerializer(LocalTime.class, new LocalTimeSerializer(Constant.DTF_TIME));
            sm.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(Constant.DTF_DATE_TIME));
            sm.addDeserializer(LocalDate.class, new LocalDateDeserializer(Constant.DTF_DATE));
            sm.addDeserializer(LocalTime.class, new LocalTimeDeserializer(Constant.DTF_TIME));
            JsonMapper om = JsonMapper.builder()
                .addModule(sm)
                .defaultDateFormat(new SimpleDateFormat(Constant.FORMAT_DATE_TIME))
                .changeDefaultPropertyInclusion(incl -> incl
                    .withContentInclusion(JsonInclude.Include.NON_NULL)
                    .withValueInclusion(JsonInclude.Include.NON_NULL))
                .build();
            INSTANCE = new Jsoner(om);
        }

    }

    private static class Iso {

        private static final Jsoner INSTANCE;

        static {
            SimpleModule sm = new SimpleModule();
            sm.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME));
            sm.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ISO_DATE));
            sm.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ISO_TIME));
            sm.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME));
            sm.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ISO_DATE));
            sm.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ISO_TIME));
            JsonMapper om = JsonMapper.builder()
                .addModule(sm)
                .defaultDateFormat(new SimpleDateFormat(Constant.ISO_PATTERN))
                .changeDefaultPropertyInclusion(incl -> incl
                    .withContentInclusion(JsonInclude.Include.NON_NULL)
                    .withValueInclusion(JsonInclude.Include.NON_NULL))
                .build();
            INSTANCE = new Jsoner(om);
        }

    }

}
