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
      if (obs == ov) panel.setList(ov.getValue());
   }
}
