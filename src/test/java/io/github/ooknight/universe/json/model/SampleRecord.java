package io.github.ooknight.universe.json.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public record SampleRecord(
    SampleRecord v0,
    Long v1,
    String v2,
    Boolean v3,
    LocalDateTime v4,
    LocalDate v5,
    LocalTime v6,
    Date v7
) {
}
