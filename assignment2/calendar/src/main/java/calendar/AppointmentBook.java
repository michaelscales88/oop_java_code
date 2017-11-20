package calendar;

import java.awt.*;
import javax.swing.*;

public class AppointmentBook extends JPanel
{
   private JLabel myLabel;
   private JScrollPane myScrollArea;

   AppointmentBook() {
      initPanel();
   }

   private void initPanel() {
      setPreferredSize(new Dimension(800, 600));
      myLabel = new JLabel("Appointments: ");

      String[] examples = {"Something", "Something else", "etc etc."};
      JList<String> myList = new JList<>(examples);
      myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      myList.setLayoutOrientation(JList.VERTICAL);
      myList.setVisibleRowCount(5);
      myList.setVisible(true);
      myList.setBounds(50, 150, 75, 90);
      myScrollArea = new JScrollPane();
      myScrollArea.setViewportView(myList);
      add(myLabel);
      add(myScrollArea);
      setVisible(true);
   }
}
