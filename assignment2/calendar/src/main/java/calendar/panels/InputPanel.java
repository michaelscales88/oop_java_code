package calendar;

import java.util.logging.*;
import javax.swing.*;

public class InputPanel
{
   private final static Logger LOGGER = Logger.getLogger(" ");
   private TextForm myForm;
   private int result;

   InputPanel(String[] labels, char[] mnemonics,
              int[] widths, String[] descs) {
      initPanel(labels, mnemonics, widths, descs);
   }

   private void initPanel(String[] labels, char[] mnemonics,
                          int[] widths, String[] descs) {
      myForm = new TextForm(labels, mnemonics, widths, descs);
   }

   public void showPanel() {
      // Reset the input panel for a new set of inputs
      myForm.clear();
      result = JOptionPane.OK_CANCEL_OPTION;
      result = JOptionPane.showConfirmDialog(null, myForm,
                                             "Enter appointment information.",
                                             JOptionPane.OK_CANCEL_OPTION);
   }

   public Appointment getAppt() {
      Appointment appt = new Appointment();
      if (result == JOptionPane.OK_OPTION) {
         String name = myForm.getText(0);
         String time = myForm.getText(1);
         String notes = myForm.getText(2);
         appt.updateAppt(name, time, notes);
      }
      return appt;
   }
}
