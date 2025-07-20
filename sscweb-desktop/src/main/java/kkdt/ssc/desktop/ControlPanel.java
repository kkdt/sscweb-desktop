package kkdt.ssc.desktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Main control panel for buttons.
 */
public class ControlPanel extends JPanel {
    private JButton satellitesButton;
    private JButton groundStationsButton;

    public ControlPanel() {
        this.satellitesButton = new JButton("Satellites");
        this.groundStationsButton = new JButton("Ground Stations");

        GridBagConstraints c = new GridBagConstraints();
        setLayout(new GridLayout(1, 2, 5, 5));

        c.gridx = 0;
        c.gridy = 0;
        add(satellitesButton, c);

        c.gridx = 1;
        c.gridy = 0;
        add(groundStationsButton, c);
    }

    public void setSatelliteButtonActionListener(ActionListener actionListener) {
        this.satellitesButton.addActionListener(actionListener);
    }

    public void setGroundStationsButtonActionListener(ActionListener actionListener) {
        this.groundStationsButton.addActionListener(actionListener);
    }
}
