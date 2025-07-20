package kkdt.ssc.desktop;

import gov.nasa.gsfc.spdf.ssc.SSCExternalException_Exception;
import gov.nasa.gsfc.spdf.ssc.SatelliteDescription;
import gov.nasa.gsfc.spdf.ssc.SatelliteSituationCenterInterface;
import kkdt.ssc.desktop.model.SatelliteEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SSCClient {
    private static final Logger logger = LoggerFactory.getLogger(SSCClient.class);

    private SatelliteSituationCenterInterface satelliteSituationCenter;

    public SSCClient(SatelliteSituationCenterInterface satelliteSituationCenter) {
        this.satelliteSituationCenter = satelliteSituationCenter;
    }

    public Collection<SatelliteEntry> getSatellites() {
        Collection<SatelliteEntry> results = Collections.emptyList();
        try {
            List<SatelliteDescription> allSatellites = satelliteSituationCenter.getAllSatellites();
            results = allSatellites.stream().map(s -> {
                SatelliteEntry entry = new SatelliteEntry();
                entry.setId(s.getId());
                entry.setName(s.getName());
                entry.setGeometry(s.getGeometry());
                entry.setResolution(s.getResolution());
                entry.setTrajectoryGeometry(s.getTrajectoryGeometry());
                entry.setStartTime(s.getStartTime().toGregorianCalendar());
                entry.setEndTime(s.getEndTime().toGregorianCalendar());
                return entry;
            }).toList();
            logger.info("Satellites found: {}", results.size());
        } catch (SSCExternalException_Exception e) {
            logger.error("Encountered error retrieving all satellites", e);
        }
        return results;
    }
}
