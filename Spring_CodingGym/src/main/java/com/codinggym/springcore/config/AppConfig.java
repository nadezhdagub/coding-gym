package com.codinggym.springcore.config;

import com.codinggym.springcore.ControlCenter;
import com.codinggym.springcore.aircrafts.Aircraft;
import com.codinggym.springcore.aircrafts.CompoundHelicopter;
import com.codinggym.springcore.aircrafts.LongRangeAirplane;
import com.codinggym.springcore.aircrafts.ShortRangeAirplane;
import com.codinggym.springcore.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource(value = {"classpath:db.properties"})
public class AppConfig {

    @Bean
    LongRangeAirplane longRangeAirplane() {
        return new LongRangeAirplane();
    }

    @Bean
    ShortRangeAirplane shortRangeAirplane() {
        return new ShortRangeAirplane();
    }

    @Bean
    CompoundHelicopter compoundHelicopter(FlightsRepository flightsRepository) {
        return new CompoundHelicopter(flightsRepository);
    }

    @Bean
    ControlCenter controlCenter(ShortRangeAirplane shortRangeAirplane, LongRangeAirplane longRangeAirplane,
                                CompoundHelicopter compoundHelicopter,
                                @Value("#{T(com.epam.codinggym.springcore.aircrafts.BasicAirplane).canFly() ? shortRangeAirplane : longRangeAirplane}") Aircraft aircraft,
                                @Value("${controlCenterMessage}") String message) {

        List<Aircraft> aircrafts = new ArrayList<>();
        aircrafts.add(longRangeAirplane);
        aircrafts.add(shortRangeAirplane);
        aircrafts.add(compoundHelicopter);
        aircrafts.add(aircraft);

        return new ControlCenter(aircrafts, message);
    }
}
