package io.github.ooknight.universe.json;

import java.time.format.DateTimeFormatter;

public class Constant {

    public static final String ISO_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_TIME = "HH:mm:ss";

    public static final DateTimeFormatter DTF_DATE_TIME = DateTimeFormatter.ofPattern(FORMAT_DATE_TIME);
    public static final DateTimeFormatter DTF_DATE = DateTimeFormatter.ofPattern(FORMAT_DATE);
    public static final DateTimeFormatter DTF_TIME = DateTimeFormatter.ofPattern(FORMAT_TIME);

}
