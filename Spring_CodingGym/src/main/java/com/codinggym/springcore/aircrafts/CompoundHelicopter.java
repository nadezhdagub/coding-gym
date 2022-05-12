package com.codinggym.springcore.aircrafts;

import com.codinggym.springcore.domain.FlightsInfo;
import com.codinggym.springcore.repository.FlightsRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CompoundHelicopter extends BasicHelicopter {

    private static final Log log = LogFactory.getLog(LongRangeAirplane.class);

    private final FlightsRepository flightsRepository;

    public CompoundHelicopter(final FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    @Override
    public void takeFlight() {
        FlightsInfo flightsInfo = new FlightsInfo();
        flightsInfo.setLog(this.getClass().getSimpleName() + " took a flight");
        flightsRepository.save(flightsInfo);
        log.info("Flight info has logged to the db");
    }
}
