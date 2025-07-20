package kkdt.ssc.desktop;

import kkdt.generictable.GenericTableController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;

/**
 * Window that contains a scrolling table for storing results.
 */
public class ResultsWindow extends JFrame {
    private static final Logger logger = LoggerFactory.getLogger(ResultsWindow.class);

    private GenericTableController tableController;

    public ResultsWindow(String title, GenericTableController tableController) throws HeadlessException {
        super(title);
        this.tableController = tableController;
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    public void layoutComponents(JTable table) {
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        JPanel panel0 = new JPanel(new BorderLayout(10, 10));
        panel0.add(scrollPane, BorderLayout.CENTER);
        panel0.setPreferredSize(new Dimension(300, 200));

        setLayout(new BorderLayout());
        setSize(400, 400);
        add(panel0, BorderLayout.CENTER);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if(!b) {
            EventQueue.invokeLater(() -> {
                logger.info("Clearing table");
                tableController.clearTable();
            });
        }
    }
}
