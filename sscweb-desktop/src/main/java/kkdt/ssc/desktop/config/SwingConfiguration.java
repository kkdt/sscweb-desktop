package kkdt.ssc.desktop.config;

import gov.nasa.gsfc.spdf.ssc.SatelliteSituationCenterInterface;
import kkdt.ssc.desktop.ControlPanel;
import kkdt.ssc.desktop.SSCClient;
import kkdt.ssc.desktop.UIFrame;
import kkdt.ssc.desktop.controller.GroundStationTableController;
import kkdt.ssc.desktop.controller.MenuController;
import kkdt.ssc.desktop.controller.SatelliteTableController;
import kkdt.ssc.desktop.model.GroundStationModel;
import kkdt.ssc.desktop.model.SatelliteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

@Configuration
public class SwingConfiguration {
    @Value("${ssc-desktop.title}")
    private String title;

    @Autowired
    private SatelliteSituationCenterInterface satelliteSituationCenter;

    @Bean
    public SSCClient sscClient() {
        return new SSCClient(satelliteSituationCenter);
    }

    @Bean
    public SatelliteModel satelliteModel() {
        return new SatelliteModel();
    }

    @Bean
    public GroundStationModel groundStationModel() {
        return new GroundStationModel();
    }

    @Bean
    public JTable satellitesTable() {
        JTable table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return table;
    }

    @Bean
    public JTable groundStationsTable() {
        JTable table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return table;
    }

    @Bean
    public SatelliteTableController satelliteTableController(@Autowired JTable satellitesTable,
         @Autowired SatelliteModel satelliteModel,
         @Autowired SSCClient sscClient)
    {
        SatelliteTableController controller = new SatelliteTableController(satellitesTable, satelliteModel);
        controller.setSatelliteSituationCenter(sscClient);
        return controller;
    }

    @Bean
    public GroundStationTableController groundStationTableController(@Autowired JTable groundStationsTable,
        @Autowired GroundStationModel groundStationModel,
        @Autowired SSCClient sscClient)
    {
        GroundStationTableController controller = new GroundStationTableController(groundStationsTable, groundStationModel);
        controller.setSatelliteSituationCenter(sscClient);
        return controller;
    }

    @Bean
    public MenuController menuController() {
        return new MenuController();
    }

    @Bean
    public ControlPanel controlPanel(@Autowired SatelliteTableController satelliteTableController,
        @Autowired GroundStationTableController groundStationTableController)
    {
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setSatelliteButtonActionListener(satelliteTableController);
        controlPanel.setGroundStationsButtonActionListener(groundStationTableController);
        return controlPanel;
    }

    @Bean
    public UIFrame mainWindow(@Autowired MenuController menuController, @Autowired ControlPanel controlPanel) {
        UIFrame frame = new UIFrame(title)
            .withMenuListener(menuController);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContents(controlPanel);
        return frame;
    }
}
