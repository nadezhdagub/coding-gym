package com.codinggym.springcore.domain;

import javax.persistence.*;

@Entity(name = "t_flights")
public class FlightsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "log")
    private String log;

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

    public FlightsInfoDto flightsInfoToFlightsInfoDto(FlightsInfo flightsInfo) {
        FlightsInfoDto flightsInfoDto = new FlightsInfoDto();
        flightsInfoDto.setId(flightsInfo.getId());
        flightsInfoDto.setLog(flightsInfo.getLog());

        return flightsInfoDto;
    }
}
