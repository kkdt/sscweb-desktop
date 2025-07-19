package kkdt.ssc.desktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class UIFrame extends JFrame {
    private JMenuItem exit;
    private JMenuItem about;

    /**
     * Expected <code>BorderLayout</code> window.
     *
     * @param title
     */
    public UIFrame(String title) {
        super(title);
        setJMenuBar(initMenu());
        setLayout(new BorderLayout(10,10));
    }

    /**
     * Attach a listener to the 'About' menu item.
     *
     * @param about
     * @return
     */
    public UIFrame aboutListener(ActionListener about) {
        this.about.addActionListener(about);
        return this;
    }

    /**
     * Attach a listener to the 'Exit' menu item.
     *
     * @param exit
     * @return
     */
    public UIFrame exitListener(ActionListener exit) {
        this.exit.addActionListener(exit);
        return this;
    }

    public void setContents(JPanel contents) {
        getContentPane().add(contents, BorderLayout.NORTH);
    }

    /**
     * Exposes a footer area.
     *
     * @param footer
     */
    public void setFooter(Component footer) {
        getContentPane().add(footer, BorderLayout.SOUTH);
    }

    private JMenuBar initMenu() {
        exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_E);
        exit.setToolTipText("Exit application");

        about = new JMenuItem("About");
        about.setMnemonic(KeyEvent.VK_A);
        about.setToolTipText("About");

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        file.add(exit);

        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        help.add(about);

        JMenuBar menubar = new JMenuBar();
        menubar.add(file);
        menubar.add(help);

        return menubar;
    }
}
