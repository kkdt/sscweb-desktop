package kkdt.ssc.desktop.controller;

import kkdt.generictable.GenericTableController;
import kkdt.generictable.GenericTableModel;
import kkdt.ssc.desktop.CalendarCellRenderer;
import kkdt.ssc.desktop.ResultsWindow;
import kkdt.ssc.desktop.SSCClient;
import kkdt.ssc.desktop.model.SatelliteEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.JTable;
import javax.swing.table.TableColumn;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class SatelliteTableController extends GenericTableController<SatelliteEntry>
    implements ActionListener
{
    private static final Logger logger = LoggerFactory.getLogger(SatelliteTableController.class);

    private SSCClient sscClient;
    private ResultsWindow resultsWindow;

    public SatelliteTableController(JTable table, GenericTableModel<SatelliteEntry> model) {
        super(table, model);

        TableColumn startColumn = table.getColumnModel().getColumn(4);
        startColumn.setCellRenderer(new CalendarCellRenderer());
        TableColumn endColumn = table.getColumnModel().getColumn(5);
        endColumn.setCellRenderer(new CalendarCellRenderer());

        this.resultsWindow = new ResultsWindow("Satellites", this);
        this.resultsWindow.setPreferredSize(new Dimension(1000, 500));
        this.resultsWindow.layoutComponents(table);
    }

    public void setSatelliteSituationCenter(SSCClient sscClient) {
        this.sscClient = sscClient;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(sscClient != null && "Satellites".equals(actionEvent.getActionCommand())) {
            Collection<SatelliteEntry> satellites = sscClient.getSatellites();
            clearTable();
            for(SatelliteEntry satellite : satellites) {
                addEntry(satellite);
            }
            EventQueue.invokeLater(() -> {
                this.resultsWindow.pack();
                this.resultsWindow.setVisible(true);
            });
        }
    }
}
