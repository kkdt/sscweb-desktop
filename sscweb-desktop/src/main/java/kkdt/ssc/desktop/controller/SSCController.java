package kkdt.ssc.desktop.controller;

import gov.nasa.gsfc.spdf.ssc.SatelliteSituationCenterInterface;

public class SSCController {
    private SatelliteSituationCenterInterface satelliteSituationCenter;

    public SSCController(SatelliteSituationCenterInterface satelliteSituationCenter) {
        this.satelliteSituationCenter = satelliteSituationCenter;
    }
}
