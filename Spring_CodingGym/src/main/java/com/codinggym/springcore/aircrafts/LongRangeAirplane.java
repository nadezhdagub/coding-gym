package com.codinggym.springcore.aircrafts;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LongRangeAirplane extends BasicAirplane {
    private static final Log log = LogFactory.getLog(LongRangeAirplane.class);

    @Override
    public void takeFlight() {
        log.info(this.getClass().getSimpleName() + " took a flight");
    }
}