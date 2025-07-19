package kkdt.ssc.desktop.config;

import gov.nasa.gsfc.spdf.ssc.SatelliteSituationCenterInterface;
import kkdt.ssc.desktop.SSCBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SatelliteSituationCenterConfiguration {

    @Value("${ssc-desktop.SatelliteSituationCenter.clientName}")
    private String clientName;

    @Bean
    public SatelliteSituationCenterInterface satelliteSituationCenter() {
        return new SSCBuilder()
            .with(c -> c.clientName = clientName)
            .build();
    }
}
