package calendar;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class AppointmentCalendar extends JFrame
{
   public AppointmentCalendar()
   {
      InitUI();
   }

   private void InitUI()
   {
      setTitle("Simple example");
      setSize(300, 200);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   public static void main(String args[])
   {
      EventQueue.invokeLater(() -> {
         AppointmentCalendar ex = new AppointmentCalendar();
         ex.setVisible(true);
      });
   }
}
