package kkdt.ssc.desktop.controller;

import kkdt.ssc.desktop.SSCDesktopApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch(actionEvent.getActionCommand()) {
            case "Exit":
                System.exit(0);
                break;
            case "About":
                handleAbout();
                break;
        }
    }

    private void handleAbout() {
        Package p = SSCDesktopApplication.class.getPackage();
        String version = p.getImplementationVersion();
        String spec = p.getSpecificationVersion();
        String vendor = p.getImplementationVendor();
        StringBuilder buffer = new StringBuilder(p.getImplementationTitle() != null ? p.getImplementationTitle() : "Satellite Situation Center");
        buffer.append("\nVersion: " + version);
        buffer.append("\nSpecification: " + p.getSpecificationTitle() + " " + spec);
        buffer.append("\nAuthor: " + vendor);
        JOptionPane.showMessageDialog(null,
            buffer.toString(),
            "About",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
