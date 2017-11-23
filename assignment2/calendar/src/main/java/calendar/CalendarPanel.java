package calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.Color;
import javax.swing.*;
import javax.swing.event.*;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;

public class CalendarPanel extends JPanel 
{
   private static DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
   private ObservedDate obsDate;

   CalendarPanel() {
      initPanel();
   }

   private void initPanel() {
      // panel layout
      setBackground(Color.gray);

      // date stuff
      UtilDateModel model = new UtilDateModel(Calendar.getInstance().getTime());
      obsDate = new ObservedDate(df.format(model.getValue()));
      Properties p = new Properties();
      p.put("text.today", "Today");
      p.put("text.month", "Month");
      p.put("text.year", "Year");

      // Add the panel
      JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
      JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
      add(datePicker);

      // set up notification for appointmentpanel
      model.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent e) {
            UtilDateModel source = (UtilDateModel) e.getSource();
            obsDate.setValue(df.format(source.getValue()));
         }
      });
      setVisible(true);
   }

   public ObservedDate getObservable() {
      return obsDate;
   }

   public void addObserver(DateObserver obs) {
      obsDate.addObserver(obs);
   }
}
