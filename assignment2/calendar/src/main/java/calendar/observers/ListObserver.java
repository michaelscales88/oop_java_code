package calendar;

import java.util.Observer;
import java.util.Observable;

public class ListObserver implements Observer
{
   private AppointmentBook book;
   private ObservedList ov;

   public ListObserver(ObservedList ov, AppointmentBook book) {
      this.book = book;
      this.ov = ov;
   }

   public void update(Observable obs, Object obj) {
      if (obs == ov) {
         // Add or remove Appointments from the 
         // AppointmentBook based on the action
         if (ov.getAction().equals("Add"))
            book.addAppt(ov.getDate(),
                         ov.getAppt());
         if (ov.getAction().equals("Remove"))
            book.remAppt(ov.getDate(),
                         ov.getAppt());
      }
   }
}
