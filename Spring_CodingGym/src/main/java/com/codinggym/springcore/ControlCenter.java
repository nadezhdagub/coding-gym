package com.codinggym.springcore;

import com.codinggym.springcore.aircrafts.Aircraft;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

public record ControlCenter(List<Aircraft> allowedAircrafts, String message) {
    private static final Log log = LogFactory.getLog(ControlCenter.class);

    @PostConstruct
    private void init() {
        log.info(message);
    }

    public void takeFlights() {
        allowedAircrafts.forEach(Aircraft::takeFlight);
    }

    @PreDestroy
    public void destroy() {
        allowedAircrafts.clear();
        log.info("No more aircrafts exists");
    }
}