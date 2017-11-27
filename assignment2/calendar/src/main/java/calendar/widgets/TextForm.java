package calendar;

import java.awt.*;
import javax.swing.*;

class TextForm extends JPanel 
{
   private JTextField[] fields;
   private int numFields;

   // Create a form with the specified labels, tooltips, and sizes.
   public TextForm(String[] labels, char[] mnemonics, int[] widths, String[] tips) {
      super(new BorderLayout());
      numFields = labels.length;
      // Create field and labels for text input
      JPanel labelPanel = new JPanel(new GridLayout(numFields, 1));
      JPanel fieldPanel = new JPanel(new GridLayout(numFields, 1));
      add(labelPanel, BorderLayout.WEST);
      add(fieldPanel, BorderLayout.CENTER);
      fields = new JTextField[numFields];

      for (int i = 0; i < numFields; i += 1) {
         fields[i] = new JTextField();
         if (i < tips.length)
            fields[i].setToolTipText(tips[i]);
         if (i < widths.length)
            fields[i].setColumns(widths[i]);

         JLabel lab = new JLabel(labels[i], JLabel.RIGHT);
         lab.setLabelFor(fields[i]);
         if (i < mnemonics.length)
            lab.setDisplayedMnemonic(mnemonics[i]);

         labelPanel.add(lab);
         JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
         p.add(fields[i]);
         fieldPanel.add(p);
      }
   }

   public String getText(int i) {
      return (fields[i].getText());
   }

   public void setText(int i, String text) {
      fields[i].setText(text);
   }

   public void clear() {
      // Clear all items to show an
      // empty display
      for (int i = 0; i < numFields; i++)
         fields[i].setText("");
   }
}
