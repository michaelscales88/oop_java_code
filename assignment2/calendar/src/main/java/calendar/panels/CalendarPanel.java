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
   private UtilDateModel model;

   CalendarPanel() {
      initPanel();
   }

   private void initPanel() {
      // panel layout
      setBackground(Color.gray);

      // date stuff
      model = new UtilDateModel(Calendar.getInstance().getTime());
      obsDate = new ObservedDate(df.format(model.getValue()));
      add(new CalendarWidget(model).getWidget());

      // set up notification for appointmentpanel
      bindListeners();
      setVisible(true);
   }

   private void bindListeners() {
      model.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent e) {
            UtilDateModel source = (UtilDateModel) e.getSource();
            obsDate.setValue(df.format(source.getValue()));
         }
      });
   }

   public ObservedDate getObservable() {
      return obsDate;
   }

   public void addObserver(DateObserver obs) {
      obsDate.addObserver(obs);
   }

   public String currDate() {
      return df.format(model.getValue());
   }
}
