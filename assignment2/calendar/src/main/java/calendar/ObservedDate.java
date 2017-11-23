package calendar;

import java.util.Observable;

public class ObservedDate extends Observable
{
   private String date;

   ObservedDate(String date) {
      this.date = date;
   }

   public void setValue(String date)
   {
      this.date = date;
      setChanged();
      notifyObservers();
   }

   public String getValue()
   {
      return date;
   }
}
