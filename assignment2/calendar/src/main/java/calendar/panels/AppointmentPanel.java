package calendar;

import java.awt.*;
import javax.swing.*;

public class AppointmentPanel extends JPanel
{
   private AppointmentBook appBook;
   private ListObserver lObs;
   private SelectionObserver lsObs;
   private ListPanel lPanel;
   private TextPanel tPanel;

   AppointmentPanel() {
      initPanel();
   }

   private void initPanel() {
      // Hold all of our appts
      appBook = new AppointmentBook();

      // Fields for our form which correlate with 
      // fields in the appBook
      String[] labels = { "Name", "Time", "Notes" };
      char[] mnemonics = { 'N', 'T', 'N' };
      int[] widths = { 15, 15, 15 };
      String[] descs = { "Name", "Time", "Notes" };

      // left section
      JLabel myLabel = new JLabel("Appointments: ");

      // middle section
      lPanel = new ListPanel();

      // right section
      tPanel = new TextPanel(labels, mnemonics, widths, descs);

      bindObservers();

      add(myLabel, BorderLayout.WEST);
      add(lPanel, BorderLayout.CENTER);
      add(tPanel, BorderLayout.EAST);

      setVisible(true);
   }

   private void bindObservers() {
      // Update the AppointmentBook with a new/removed Appointment
      lObs = new ListObserver(lPanel.getListObservable(),
                              appBook);
      lPanel.addListObserver(lObs);

      // Update the TextForm based on selected Appointment in
      // the ListView
      lsObs = new SelectionObserver(lPanel.getSelectionObservable(),
                                    tPanel);
      lPanel.addSelectionObserver(lsObs);
   }

   public void setApptList(String selDate) {
      lPanel.setSelection(selDate, appBook.getAppts(selDate));
   }
}
