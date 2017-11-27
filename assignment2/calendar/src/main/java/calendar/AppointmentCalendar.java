package calendar;

import java.io.IOException;
import java.util.logging.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Container;
import javax.swing.*;

public class AppointmentCalendar
{
   final static Logger LOGGER = Logger.getLogger(AppointmentCalendar.class.getName());
   private static FileHandler fh = null;
   private JFrame frame;
   private DateObserver dObs;

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

   public static void log(String text) {
      LOGGER.info(text);
   }

   AppointmentCalendar() {
      initUI();
   }

   private void initUI()
   {
      // Configure top frame
      frame = new JFrame("Appointment Calendar");
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Container contentPane = frame.getContentPane();
      SpringLayout layout = new SpringLayout();
      contentPane.setLayout(layout);

      // Bind startup events
      bindFrameEvents();

      // Set widgets
      initWidgets(contentPane);
      SpringUtilities.makeCompactGrid(contentPane,
                                      3, 1,  // rows, cols
                                      5, 5,  // initial x, y
                                      5, 5); // xpad, ypad

      // set frame to content size
      frame.pack();

      // Display the window
      frame.setVisible(true);
   }

   private void initWidgets(Container contentPane) {
      // calendar panel
      final CalendarPanel calPanel = new CalendarPanel();

      // appointmentbook panel
      final AppointmentPanel apptPanel = new AppointmentPanel();

      // button panel
      final ButtonPanel btnPanel = new ButtonPanel();

      // set panel behavior
      dObs = new DateObserver(calPanel.getObservable(),
                              apptPanel);
      calPanel.addObserver(dObs);
      btnPanel.linkPanel(apptPanel);
      apptPanel.setApptList(calPanel.currDate());

      contentPane.add(calPanel);
      contentPane.add(apptPanel);
      contentPane.add(btnPanel);
   }

   private void bindFrameEvents() {
      frame.addWindowListener(new WindowAdapter() {
         public void windowOpened(WindowEvent e) {
            LOGGER.info("Logging begins.");
         }
      });

      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            LOGGER.info("Logging ends.");
         }
      });
   }
}
