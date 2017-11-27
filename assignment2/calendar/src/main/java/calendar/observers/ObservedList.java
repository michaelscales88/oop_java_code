package calendar;

import java.util.Observable;

public class ObservedList extends Observable
{
   private String action;
   private String date;
   private Appointment appt;

   public void setValues(String action, String date, Appointment appt) {
      this.action = action;
      this.date = date;
      this.appt = appt;
      setChanged();
      notifyObservers();
   }

   /*
    * Getters for ListObserver 
    */
   public String getAction() {
      return action;
   }

   public String getDate() {
      return date;
   }

   public Appointment getAppt() {
      return appt;
   }
}
