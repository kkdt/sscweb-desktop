package kkdt.ssc.desktop.config;

import gov.nasa.gsfc.spdf.ssc.GroundStationDescription;
import gov.nasa.gsfc.spdf.ssc.SatelliteDescription;
import gov.nasa.gsfc.spdf.ssc.SatelliteSituationCenterInterface;
import kkdt.ssc.desktop.UIFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.awt.EventQueue;
import java.util.List;

@Configuration
public class ApplicationConfiguration implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Autowired
    private SatelliteSituationCenterInterface satelliteSituationCenter;

    @Autowired
    private UIFrame mainWindow;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<SatelliteDescription> allSatellites = satelliteSituationCenter.getAllSatellites();
        List<GroundStationDescription> allGroundStations = satelliteSituationCenter.getAllGroundStations();
        logger.info("Found {} satellite(s) and {} ground station(s)", allSatellites.size(), allGroundStations.size());

        EventQueue.invokeLater(() -> {
            mainWindow.pack();
            mainWindow.setLocationRelativeTo(null);
            mainWindow.setVisible(true);
        });
    }
}
