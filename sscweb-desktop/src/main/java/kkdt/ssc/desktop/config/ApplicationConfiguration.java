package kkdt.ssc.desktop.config;

import gov.nasa.gsfc.spdf.ssc.GroundStationDescription;
import gov.nasa.gsfc.spdf.ssc.SatelliteDescription;
import gov.nasa.gsfc.spdf.ssc.SatelliteSituationCenterInterface;
import kkdt.ssc.desktop.ControlPanel;
import kkdt.ssc.desktop.UIFrame;
import kkdt.ssc.desktop.controller.SSCController;
import kkdt.ssc.desktop.controller.UIController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.util.List;

@Configuration
public class ApplicationConfiguration implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Autowired
    private SatelliteSituationCenterInterface satelliteSituationCenter;

    @Value("${ssc-desktop.title}")
    private String title;

    @Bean
    public SSCController sscController() {
        return new SSCController(satelliteSituationCenter);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<SatelliteDescription> allSatellites = satelliteSituationCenter.getAllSatellites();
        List<GroundStationDescription> allGroundStations = satelliteSituationCenter.getAllGroundStations();
        logger.info("Found {} satellite(s) and {} ground station(s)", allSatellites.size(), allGroundStations.size());

        UIController uiController = new UIController();
        // build the Desktop GUI
        UIFrame frame = new UIFrame(title)
            .exitListener(uiController)
            .aboutListener(uiController);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContents(new ControlPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
