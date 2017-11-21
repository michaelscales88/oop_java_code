package calendar;

import java.io.IOException;
import java.util.logging.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.BorderLayout;
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

   AppointmentCalendar() {
      initUI();
   }

   private void initUI()
   {
      // Configure top frame
      setTitle("Appointment Calendar");
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      // Bind startup events
      bindWindowEvents();

      // Set widgets
      initWidgets();

      // set frame to content size
      pack();

      // Display the window
      setVisible(true);
   }

   private void initWidgets() {
      // calendar panel
      final CalendarPanel calPanel = new CalendarPanel();

      // appointmentbook panel
      final AppointmentBook apptPanel = new AppointmentBook();
      //apptPanel.runTest();

      // button panel
      final ButtonPanel btnPanel = new ButtonPanel();
      btnPanel.linkPanel(apptPanel);

      add(calPanel, BorderLayout.NORTH);
      add(apptPanel, BorderLayout.CENTER);
      add(btnPanel, BorderLayout.SOUTH);
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
         }
      });
   }
}
