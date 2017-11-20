package calendar;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JPanel;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;

public class CalendarWidget extends JPanel
{
   public JDatePickerImpl getCalendar() {
      UtilDateModel model = new UtilDateModel(Calendar.getInstance().getTime());
      model.setSelected(true);
      Properties p = new Properties();
      p.put("text.today", "Today");
      p.put("text.month", "Month");
      p.put("text.year", "Year");
      JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
      JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
      return datePicker;
   }
}
