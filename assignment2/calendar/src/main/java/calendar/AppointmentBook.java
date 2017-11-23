package calendar;

import java.util.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.*;

public class AppointmentBook
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

   AppointmentBook() {
      myBook = new HashMap<String, ArrayList<Appointment>>();
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
