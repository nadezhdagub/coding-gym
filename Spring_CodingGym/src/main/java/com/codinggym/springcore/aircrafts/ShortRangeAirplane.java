package com.codinggym.springcore.aircrafts;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ShortRangeAirplane extends BasicAirplane {
    private static final Log log = LogFactory.getLog(ShortRangeAirplane.class);

    @Override
    public void takeFlight() {
        log.info(this.getClass().getSimpleName() + " took a flight");
    }
}
