package calendar;

import java.util.Observer;
import java.util.Observable;

public class DateObserver implements Observer
{
   private ObservedDate ov;
   private AppointmentPanel panel;

   public DateObserver(ObservedDate ov, AppointmentPanel panel) {
      this.panel = panel;
      this.ov = ov;
   }

   public void update(Observable obs, Object obj) {
      // Update the ListView with the selected date
      // from the CalendarWidget
      if (obs == ov) panel.setApptList(ov.getValue());
   }
}
