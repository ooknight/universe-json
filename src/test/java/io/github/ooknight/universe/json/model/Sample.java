package io.github.ooknight.universe.json.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Sample {

    private Long v1 = 1L;
    private String v2 = "sample";
    private Boolean v3 = true;
    private LocalDateTime v4 = LocalDateTime.now();
    private LocalDate v5 = LocalDate.now();
    private LocalTime v6 = LocalTime.now();
    private Date v7 = new Date();

    public Long getV1() {
        return v1;
    }
    public void setV1(Long v1) {
        this.v1 = v1;
    }
    public String getV2() {
        return v2;
    }
    public void setV2(String v2) {
        this.v2 = v2;
    }
    public Boolean getV3() {
        return v3;
    }
    public void setV3(Boolean v3) {
        this.v3 = v3;
    }
    public LocalDateTime getV4() {
        return v4;
    }
    public void setV4(LocalDateTime v4) {
        this.v4 = v4;
    }
    public LocalDate getV5() {
        return v5;
    }
    public void setV5(LocalDate v5) {
        this.v5 = v5;
    }
    public LocalTime getV6() {
        return v6;
    }
    public void setV6(LocalTime v6) {
        this.v6 = v6;
    }
    public Date getV7() {
        return v7;
    }
    public void setV7(Date v7) {
        this.v7 = v7;
    }

    @Override
    public String toString() {
        return "Sample{" +
            "v1=" + v1 +
            ", v2='" + v2 + '\'' +
            ", v3=" + v3 +
            ", v4=" + v4 +
            ", v5=" + v5 +
            ", v6=" + v6 +
            ", v7=" + v7 +
            '}';
    }

}
