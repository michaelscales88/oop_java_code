package calendar;

import java.util.*;
import java.awt.Color;
import javax.swing.*;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;

public class CalendarPanel extends JPanel 
{
   private JDatePickerImpl datePicker;

   CalendarPanel() {
      initPanel();
   }

   private void initPanel() {
      // panel layout
      setBackground(Color.gray);

      // panel logic
      UtilDateModel model = new UtilDateModel(Calendar.getInstance().getTime());
      model.setSelected(true);
      Properties p = new Properties();
      p.put("text.today", "Today");
      p.put("text.month", "Month");
      p.put("text.year", "Year");
      JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
      datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());

      add(datePicker);
      setVisible(true);
   }
}
