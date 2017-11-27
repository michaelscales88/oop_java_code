package calendar;

import java.util.Observable;

public class ObservedSelection extends Observable
{
   private Appointment appt;

   public void setValues(Appointment appt) {
      this.appt = appt;
      setChanged();
      notifyObservers();
   }

   /*
    * Getters for SelectionObserver
    */
   public Appointment getAppt() {
      return appt;
   }
}
