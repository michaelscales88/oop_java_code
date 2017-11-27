package calendar;

import java.util.Observable;

public class ObservedDate extends Observable
{
   private String date;

   ObservedDate(String date) {
      this.date = date;
   }

   public void setValue(String date) {
      this.date = date;
      setChanged();
      notifyObservers();
   }

   /*
    * Getters for DateObserver
    */
   public String getValue() {
      return date;
   }
}
