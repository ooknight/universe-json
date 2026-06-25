package io.github.ooknight.universe.json.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class Sample {

    private Sample v0;
    private Long v1;
    private String v2;
    private Boolean v3;
    private LocalDateTime v4;
    private LocalDate v5;
    private LocalTime v6;
    private Date v7;

    public Sample getV0() {
        return v0;
    }
    public void setV0(Sample v0) {
        this.v0 = v0;
    }
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
            "v0=" + v0 +
            ", v1=" + v1 +
            ", v2='" + v2 + '\'' +
            ", v3=" + v3 +
            ", v4=" + v4 +
            ", v5=" + v5 +
            ", v6=" + v6 +
            ", v7=" + v7 +
            '}';
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Sample)) return false;
        Sample sample = (Sample) object;
        return Objects.equals(v0, sample.v0) && Objects.equals(v1, sample.v1) && Objects.equals(v2, sample.v2) && Objects.equals(v3, sample.v3) && Objects.equals(v4, sample.v4) && Objects.equals(v5, sample.v5) && Objects.equals(v6, sample.v6) && Objects.equals(v7, sample.v7);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v0, v1, v2, v3, v4, v5, v6, v7);
    }

}
