package calendar;

import java.util.logging.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Observable;

public class TextPanel extends JPanel
{
   private final static Logger LOGGER = Logger.getLogger(" ");
   private TextForm myForm;

   TextPanel(String[] labels, char[] mnemonics,
             int[] widths, String[] descs) {
      initPanel(labels, mnemonics, widths, descs);
   }

   private void initPanel(String[] labels, char[] mnemonics,
                          int[] widths, String[] descs) {
      myForm = new TextForm(labels, mnemonics, widths, descs);
      add(myForm);
   }

   public void setApptForm(Appointment appt) {
      myForm.setText(0, appt.getName());
      myForm.setText(1, appt.getTime());
      myForm.setText(2, appt.getNotes());
      LOGGER.info("Setting appt in TextPanel.");
   }
}
