package io.github.ooknight.universe.json;

import io.github.ooknight.universe.json.model.Sample;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static io.github.ooknight.universe.json.JsonerHolder.jsoner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonerIsoTests {

    @Test
    public void testJson() {
        String result = jsoner.iso().json(sample());
        assertEquals(content(), result);
    }

    @Test
    public void testParse() {
        Sample result = jsoner.iso().parse(content(), Sample.class);
        assertEquals(sample(), result);
    }

    @Test
    public void testPathString() {
        assertEquals("root", jsoner.iso().string(content(), "v0.v2"));
        assertEquals("sample", jsoner.iso().string(content(), "v2"));
        assertEquals("1", jsoner.iso().string(content(), "v1"));
        assertEquals("true", jsoner.iso().string(content(), "v3"));
        assertEquals("2026-05-04T03:02:01", jsoner.iso().string(content(), "v4"));
        assertEquals("2026-05-04", jsoner.iso().string(content(), "v5"));
        assertEquals("03:02:01", jsoner.iso().string(content(), "v6"));
        assertEquals("2026-05-04T03:02:01.999", jsoner.iso().string(content(), "v7"));
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
        sample.setV7(new Date(1777834921999L));
        return sample;
    }

    private String content() {
        return "{\"v0\":{\"v1\":0,\"v2\":\"root\"},\"v1\":1,\"v2\":\"sample\",\"v3\":true,\"v4\":\"2026-05-04T03:02:01\",\"v5\":\"2026-05-04\",\"v6\":\"03:02:01\",\"v7\":\"2026-05-04T03:02:01.999\"}";
    }

    @Test
    public void test() {
        System.out.println(jsoner.iso().json(LocalDateTime.now()));
        System.out.println(jsoner.iso().json(LocalDateTime.of(2026, 5, 4, 3, 2, 1,1)));
    }

}
