package calendar;

import java.util.logging.*;
import java.util.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.*;

public class AppointmentBook
{
   private final static Logger LOGGER = Logger.getLogger(" ");
   private final HashMap<String, ArrayList<Appointment>> myBook;

   AppointmentBook() {
      myBook = new HashMap<String, ArrayList<Appointment>>();
   }

   /*
    * Getters
    */
   public ArrayList<Appointment> getAppts(String key) {
      // Get an ArrayList of appoints if the key exists
      // or return an empty ArrayList.
      ArrayList<Appointment> currAppts;
      if (myBook.containsKey(key)) currAppts = myBook.get(key);
      else currAppts = new ArrayList<Appointment>();
      return currAppts;
   }

   /*
    * Setters
    */
   public void addAppt(String key, Appointment appt) {
      // Add an appointment to the ArrayList for the key.
      ArrayList<Appointment> currAppts = getAppts(key);
      currAppts.add(appt);
      myBook.put(key, currAppts);
      LOGGER.info("Added an appt for: " + key);
   }

   public void remAppt(String key, Appointment appt) {
      // Remove the appointment if it exists.
      if (myBook.containsKey(key)
          && myBook.get(key).contains(appt)) {
         myBook.get(key).remove(appt);
         LOGGER.info("Removed an appt for: " + key);
      } else LOGGER.info("Item does not exist");
   }
}
