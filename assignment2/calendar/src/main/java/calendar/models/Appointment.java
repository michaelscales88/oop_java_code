package calendar;

import java.util.ArrayList;
import java.util.Arrays;

public class Appointment
{
   private String time = "";
   private String name = "";
   private String notes = "";

   Appointment() {}

   Appointment(String name, String time, String notes) {
      this.name = name;
      this.time = time;
      this.notes = notes;
   }

   public void updateAppt(String name, String time, String notes) {
      this.name = name;
      this.time = time;
      this.notes = notes;
   }

   public String getName() {
      return name;
   }

   public String getTime() {
      return time;
   }

   public String getNotes() {
      return notes;
   }

   public boolean isBlank() {
      return (name.equals("")
              && time.equals("")
              && notes.equals(""));
   }
}
