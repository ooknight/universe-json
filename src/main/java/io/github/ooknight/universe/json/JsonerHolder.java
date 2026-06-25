package io.github.ooknight.universe.json;

public class JsonerHolder {

    public static final JsonerHolder jsoner = new JsonerHolder();

    public Jsoner simple() {
        return Jsoner.simple();
    }

    public Jsoner iso() {
        return Jsoner.iso();
    }

}
