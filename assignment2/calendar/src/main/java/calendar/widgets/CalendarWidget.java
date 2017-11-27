package calendar;

import java.util.Properties;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;

public class CalendarWidget
{
   private JDatePickerImpl datePicker;

   CalendarWidget(UtilDateModel model) {
      initWidget(model);
   }

   private void initWidget(UtilDateModel model) {
      Properties p = new Properties();
      p.put("text.today", "Today");
      p.put("text.month", "Month");
      p.put("text.year", "Year");

      datePicker = new JDatePickerImpl(new JDatePanelImpl(model, p),
                                       new DateComponentFormatter());
   }

   public JDatePickerImpl getWidget() {
      return datePicker;
   }
}
