package kkdt.ssc.desktop.controller;

import kkdt.generictable.GenericTableController;
import kkdt.generictable.GenericTableModel;
import kkdt.ssc.desktop.ResultsWindow;
import kkdt.ssc.desktop.SSCClient;
import kkdt.ssc.desktop.model.GroundStationEntry;

import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class GroundStationTableController extends GenericTableController<GroundStationEntry>
    implements ActionListener
{
    private SSCClient sscClient;
    private ResultsWindow resultsWindow;

    public GroundStationTableController(JTable table, GenericTableModel<GroundStationEntry> model) {
        super(table, model);

        this.resultsWindow = new ResultsWindow("Ground Stations", this);
        this.resultsWindow.setPreferredSize(new Dimension(500, 300));
        this.resultsWindow.layoutComponents(table);
    }

    public void setSatelliteSituationCenter(SSCClient sscClient) {
        this.sscClient = sscClient;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(sscClient != null && "Ground Stations".equals(actionEvent.getActionCommand())) {
            Collection<GroundStationEntry> results = sscClient.getGroundStations();
            clearTable();
            for(GroundStationEntry entry : results) {
                addEntry(entry);
            }
            EventQueue.invokeLater(() -> {
                this.resultsWindow.pack();
                this.resultsWindow.setVisible(true);
            });
        }
    }
}
