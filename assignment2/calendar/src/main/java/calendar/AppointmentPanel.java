package calendar;

import java.awt.*;
import javax.swing.*;

public class AppointmentPanel extends JPanel
{
   private AppointmentBook appBook;
   private JPanel panel;
   private ListModelPanel listModel;

   AppointmentPanel(AppointmentBook appBook) {
      this.appBook = appBook;
      initPanel();
   }

   private void initPanel() {
      // left section
      JLabel myLabel = new JLabel("Appointments: ");
      add(myLabel, BorderLayout.WEST);

      // middle section
      listModel = new ListModelPanel();
      add(listModel, BorderLayout.CENTER);

      // right section
      String[] labels = { "First Name", "Middle Initial", "Last Name", "Age" };
      char[] mnemonics = { 'F', 'M', 'L', 'A' };
      int[] widths = { 15, 1, 15, 3 };
      String[] descs = { "First Name", "Middle Initial", "Last Name", "Age" };
      final TextForm form = new TextForm(labels, mnemonics, widths, descs);
      add(form, BorderLayout.EAST);
      setVisible(true);
   }

   public void setList(String selDate) {
      listModel.setSelection(selDate);
   }
}
