package io.github.ooknight.universe.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Jsoner {

    private final Configuration configuration;
    private final ObjectMapper om;

    private Jsoner(ObjectMapper om) {
        this.om = om;
        this.configuration = Configuration.builder().jsonProvider(new JacksonJsonProvider(om)).build();
    }

    public static Jsoner simple() {
        return Simple.INSTANCE;
    }

    public static Jsoner iso() {
        return Iso.INSTANCE;
    }

    public String json(Object object) {
        try {
            return om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String string(String json, String path) {
        return JsonPath.using(configuration).parse(json).read(path, String.class);
    }

    public <T> T parse(String json, Class<T> clazz) {
        try {
            return om.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Simple {

        private static final Jsoner INSTANCE;

        static {
            JavaTimeModule jtm = new JavaTimeModule();
            jtm.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(Constant.DTF_DATE_TIME));
            jtm.addSerializer(LocalDate.class, new LocalDateSerializer(Constant.DTF_DATE));
            jtm.addSerializer(LocalTime.class, new LocalTimeSerializer(Constant.DTF_TIME));
            jtm.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(Constant.DTF_DATE_TIME));
            jtm.addDeserializer(LocalDate.class, new LocalDateDeserializer(Constant.DTF_DATE));
            jtm.addDeserializer(LocalTime.class, new LocalTimeDeserializer(Constant.DTF_TIME));
            ObjectMapper om = new ObjectMapper();
            om.registerModule(jtm);
            om.setDateFormat(new SimpleDateFormat(Constant.FORMAT_DATE_TIME));
            om.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
            INSTANCE = new Jsoner(om);
        }

    }

    private static class Iso {

        private static final Jsoner INSTANCE;

        static {
            JavaTimeModule jtm = new JavaTimeModule();
            jtm.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME));
            jtm.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ISO_DATE));
            jtm.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ISO_TIME));
            jtm.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME));
            jtm.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ISO_DATE));
            jtm.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ISO_TIME));
            ObjectMapper om = new ObjectMapper();
            om.registerModule(jtm);
            om.setDateFormat(new SimpleDateFormat(Constant.ISO_PATTERN));
            om.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
            INSTANCE = new Jsoner(om);
        }

    }

}
