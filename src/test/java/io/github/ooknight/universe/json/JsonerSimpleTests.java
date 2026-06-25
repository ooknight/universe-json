package io.github.ooknight.universe.json;

import io.github.ooknight.universe.json.model.Sample;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static io.github.ooknight.universe.json.JsonerHolder.jsoner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonerSimpleTests {

    @Test
    public void testJson() {
        String result = jsoner.simple().json(sample());
        assertEquals(content(), result);
    }

    @Test
    public void testParse() {
        Sample result = jsoner.simple().parse(content(), Sample.class);
        assertEquals(sample(), result);
    }

    @Test
    public void testPathString() {
        assertEquals("root", jsoner.simple().string(content(), "v0.v2"));
        assertEquals("sample", jsoner.simple().string(content(), "v2"));
        assertEquals("1", jsoner.simple().string(content(), "v1"));
        assertEquals("true", jsoner.simple().string(content(), "v3"));
        assertEquals("2026-05-04 03:02:01", jsoner.simple().string(content(), "v4"));
        assertEquals("2026-05-04", jsoner.simple().string(content(), "v5"));
        assertEquals("03:02:01", jsoner.simple().string(content(), "v6"));
        assertEquals("2026-05-04 03:02:01", jsoner.simple().string(content(), "v7"));
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

}
