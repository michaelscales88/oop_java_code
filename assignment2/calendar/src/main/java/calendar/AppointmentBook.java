package calendar;

import java.util.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.*;

public class AppointmentBook extends JPanel
{
   private class Appointment
   {
      private final String name;

      Appointment(String time) {
         name = time;
      }

      public void printName() {
         System.out.println(name);
      }
   }

   private final HashMap<String, ArrayList<AppointmentBook.Appointment>> myBook;
   private JLabel myLabel;
   private JScrollPane myScrollArea;

   AppointmentBook() {
      myBook = new HashMap<String, ArrayList<Appointment>>();
      initPanel();
   }

   private void initPanel() {
      //setPreferredSize(new Dimension(800, 600));

      // left section
      myLabel = new JLabel("Appointments: ");
      add(myLabel, BorderLayout.WEST);

      // middle section
      JList<String> myList = new JList<>();
      myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      myList.setLayoutOrientation(JList.VERTICAL);
      myList.setVisibleRowCount(5);
      myList.setVisible(true);
      myList.setBounds(50, 150, 75, 90);
      myScrollArea = new JScrollPane();
      myScrollArea.setViewportView(myList);
      add(myScrollArea, BorderLayout.CENTER);

      // right section
      String[] labels = { "First Name", "Middle Initial", "Last Name", "Age" };
      char[] mnemonics = { 'F', 'M', 'L', 'A' };
      int[] widths = { 15, 1, 15, 3 };
      String[] descs = { "First Name", "Middle Initial", "Last Name", "Age" };
      final TextForm form = new TextForm(labels, mnemonics, widths, descs);
      add(form, BorderLayout.EAST);
      setVisible(true);
   }

   public void runTest() {
      String[] examples = {"Something", "Something else", "etc etc."};
      addAppointment("30", new Appointment(examples[0]));
      addAppointment("30", new Appointment(examples[1]));
      addAppointment("30", new Appointment(examples[2]));
      for (Appointment appt : myBook.get("30"))
         appt.printName();
   }

   private ArrayList<Appointment> getAppointments(String key) {
      ArrayList<Appointment> currAppts;
      if (myBook.containsKey(key)) currAppts = myBook.get(key);
      else currAppts = new ArrayList<Appointment>();
      return currAppts;
   }

   private void addAppointment(String key, Appointment appt) {
      ArrayList<Appointment> currAppts = getAppointments(key);
      currAppts.add(appt);
      myBook.put(key, currAppts);
   }
}
