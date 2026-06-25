package io.github.ooknight.universe.json;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import io.github.ooknight.universe.json.model.Sample;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static io.github.ooknight.universe.json.Jsoner.jsoner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonerTests {

    //private String body = Files.re;

    @Test
    public void testJson() {
        String result = jsoner.json(sample());
        assertEquals(content(), result);
    }

    @Test
    public void testParse() {
        Sample result = jsoner.parse(content(), Sample.class);
        assertEquals(sample(), result);
    }

    @Test
    public void testPathString() {
        assertEquals("root", jsoner.string(content(), "v0.v2"));
        assertEquals("sample", jsoner.string(content(), "v2"));
        assertEquals("1", jsoner.string(content(), "v1"));
    }

    private Sample sample() {
        Sample root = new Sample();
        root.setV1(0L);
        root.setV2("root");
        Sample sample = new Sample();
        sample.setV0(root);
        sample.setV1(1L);
        sample.setV2("sample");
        sample.setV3(true);
        sample.setV4(LocalDateTime.of(2026, 5, 4, 3, 2, 1));
        sample.setV5(LocalDate.of(2026, 5, 4));
        sample.setV6(LocalTime.of(3, 2, 1));
        sample.setV7(new Date(1777834921000L));
        return sample;
    }

    private String content() {
        return "{\"v0\":{\"v1\":0,\"v2\":\"root\"},\"v1\":1,\"v2\":\"sample\",\"v3\":true,\"v4\":\"2026-05-04 03:02:01\",\"v5\":\"2026-05-04\",\"v6\":\"03:02:01\",\"v7\":\"2026-05-04 03:02:01\"}";
    }

    @Test
    public void test() {
        Configuration cfg1 = Configuration.builder()
            .jsonProvider(new GsonJsonProvider())
            .build();
        Configuration cfg2 = Configuration.defaultConfiguration();

        System.out.println(JsonPath.using(cfg1).parse(content()).read("v2", String.class));
        System.out.println(JsonPath.using(cfg2).parse(content()).read("v2", String.class));
    }

}
