package kkdt.ssc.desktop;

import gov.nasa.gsfc.spdf.ssc.SatelliteSituationCenterInterface;
import gov.nasa.gsfc.spdf.ssc.SatelliteSituationCenterService;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Consumer;

public class SSCBuilder {
    public String serviceLocation = "http://sscWeb.gsfc.nasa.gov/WS/ssc/2/SatelliteSituationCenterService?wsdl";
    public String clientName;

    public SSCBuilder with(Consumer<SSCBuilder> c) {
        c.accept(this);
        return this;
    }

    public SatelliteSituationCenterInterface build() {
        if(clientName == null || clientName.isBlank()) {
            throw new IllegalArgumentException("Client name is mandatory");
        }

        if(serviceLocation == null || serviceLocation.isBlank()) {
            throw new IllegalArgumentException("Service location is mandatory");
        }

        System.setProperty("http.agent", "WsExample (" +
            System.getProperty("os.name") + " " +
            System.getProperty("os.arch") + ")");

        SatelliteSituationCenterService service = null;
        try {
            service = new SatelliteSituationCenterService(
                new URL(serviceLocation),
                new QName("http://ssc.spdf.gsfc.nasa.gov/", "SatelliteSituationCenterService"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        SatelliteSituationCenterInterface ssc = service.getSatelliteSituationCenterPort();
        return ssc;
    }
}
