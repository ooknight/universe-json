package io.github.ooknight.universe.json;

import io.github.ooknight.universe.json.model.Sample;
import org.junit.jupiter.api.Test;

import static io.github.ooknight.universe.json.Json.json;

public class JsonTests {

    @Test
    public void test() {
        String result = json.string(new Sample());
        System.out.println(result);
    }

    @Test
    public void testParse() {
        Sample result = json.parse("{\"v1\":1,\"v2\":\"sample\",\"v3\":true,\"v4\":\"2026-06-24 16:08:29\",\"v5\":\"2026-06-24\",\"v6\":\"16:08:29\",\"v7\":\"2026-06-24 16:08:29\"}", Sample.class);
        System.out.println(result);
    }

}
