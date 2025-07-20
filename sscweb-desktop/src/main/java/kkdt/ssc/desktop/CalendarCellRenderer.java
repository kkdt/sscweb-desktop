package kkdt.ssc.desktop;

import javax.swing.table.DefaultTableCellRenderer;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Renders Calendar objects in tables.
 */
public class CalendarCellRenderer extends DefaultTableCellRenderer {
    private SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm"); // Customize format here

    @Override
    public void setValue(Object value) {
        if (value instanceof Calendar) {
            setText(formatter.format(((Calendar) value).getTime()));
        } else {
            super.setValue(value);
        }
    }
}
