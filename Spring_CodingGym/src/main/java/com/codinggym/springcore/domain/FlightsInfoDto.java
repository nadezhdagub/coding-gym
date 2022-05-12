package com.codinggym.springcore.domain;

public class FlightsInfoDto {
    private int id;
    private String log;

    public FlightsInfoDto() {
    }

    public FlightsInfoDto(final int id, final String log) {
        this.id = id;
        this.log = log;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(final String log) {
        this.log = log;
    }
}
