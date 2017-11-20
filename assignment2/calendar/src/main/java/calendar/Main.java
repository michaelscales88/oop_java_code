package calendar;
import javax.swing.*;

public class Main
{
   public static void main(String args[])
   {
      AppointmentCalendar.initLogger();
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            AppointmentCalendar ex = new AppointmentCalendar();
         }
      });
   }
}
