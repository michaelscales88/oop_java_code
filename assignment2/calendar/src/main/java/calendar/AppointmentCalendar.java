package calendar;

import java.io.IOException;
import java.util.logging.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class AppointmentCalendar extends JFrame
{
   private final static Logger LOGGER = Logger.getLogger(AppointmentCalendar.class.getName());
   private static FileHandler fh = null;

   public static void initLogger() {
      if (fh == null) {
         // Configure logger and handler
         try {
            fh = new FileHandler("ApptCal.log", true);
         } catch (SecurityException | IOException e) {
            e.printStackTrace();
         }
            fh.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fh);
            LOGGER.setLevel(Level.INFO);
      }
   }

   public AppointmentCalendar()
   {
      AppointmentCalendar.initLogger();
      initUI();
   }

   private void initUI()
   {
      setTitle("Appointment Calendar");
      setSize(300, 200);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      // Bind startup events
      bindWindowEvents();

      // Create layout
      setLayout(new FlowLayout());

      // Set widgets
      initWidgets();

      // Display the window
      setVisible(true);
   }

   private void initWidgets() {
      add(new CalendarWidget().getCalendar());
   }

   private void bindWindowEvents() {
      addWindowListener(new WindowAdapter() {
         public void windowOpened(WindowEvent e) {
            LOGGER.info("Logging begins.");
         }
      });

      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            LOGGER.info("Logging ends.");
            System.exit(0);
         }
      });

   }

   public static void main(String args[])
   {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            AppointmentCalendar ex = new AppointmentCalendar();
         }
      });
   }
}
