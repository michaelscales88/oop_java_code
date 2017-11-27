package calendar;

import java.util.logging.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListPanel extends JPanel
{
   private ListView listView;
   private ObservedList obsList;
   private ObservedSelection obsSelect;
   private String currDate;
   private JButton addBtn;
   private JButton remBtn;
   private InputPanel iPanel;
   private HashMap<String, Appointment> currAppts;

   ListPanel() {
      initPanel();
   }

   private void initPanel() {
      // Fields for our form which correlate with 
      // fields in the appBook
      String[] labels = { "Name", "Time", "Notes" };
      char[] mnemonics = { 'N', 'T', 'N' };
      int[] widths = { 15, 15, 15 };
      String[] descs = { "Name", "Time", "Notes" };

      iPanel = new InputPanel(labels, mnemonics, widths, descs);
      setLayout(new BorderLayout());
      listView = new ListView();
      JScrollPane pane = new JScrollPane(listView.getList());

      // Update the AppointmentBook with added or
      // removed Appointments
      obsList = new ObservedList();
      // Update the TextForm to show the contents
      // of the selected Appointment in the ListView
      obsSelect = new ObservedSelection();

      addBtn = new JButton("Add");
      remBtn = new JButton("Remove");

      bindListeners();

      add(pane, BorderLayout.NORTH);
      add(addBtn, BorderLayout.WEST);
      add(remBtn, BorderLayout.EAST);
   }

   private void bindListeners() {
      addBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // Popup menu takes input values to create 
            // a new Appointment
            iPanel.showPanel();
            Appointment appt = iPanel.getAppt();
            if (!appt.isBlank()) addAppt(appt);
            else AppointmentCalendar.log("Discarding blank appointment.");
         }
      });
      remBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // Remove the Appointment that is stored
            // in our hashmap
            Object currVal = listView.currentValue();
            if (currVal != null) remAppt(currAppts.get(currVal.toString()));
            else AppointmentCalendar.log("Cannot remove item from empty list.");
         }
      });
      listView.getList().addListSelectionListener(new ListSelectionListener() {
         @Override
         public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
               // Set the TextForm with the selected item in
               // the ListView, or a blank form if non exists.
               if (!listView.getList().isSelectionEmpty()) {
                  String currVal = listView.currentValue().toString();
                  obsSelect.setValues(currAppts.get(currVal));
               } else {
                  AppointmentCalendar.log("Empty view. Selecting empty appt.");
                  obsSelect.setValues(new Appointment());
               }
            }
         }
      });
   }

   public void addAppt(Appointment appt) {
      // Maintain AppBook invariant by
      // add/remove/modifying the View,
      // AppointmentBook, and current Appts.
      currAppts.put(appt.getName(), appt);
      listView.addItem(appt.getName());
      obsList.setValues("Add", currDate, appt);
      AppointmentCalendar.log("Added appt in ListPanel.");
   }

   public void remAppt(Appointment appt) {
      // Maintain AppBook invariant by
      // add/remove/modifying the View,
      // AppointmentBook, and current Appts.
      currAppts.remove(appt.getName());
      listView.remItem(appt.getName());
      obsList.setValues("Remove", currDate, appt);
      AppointmentCalendar.log("Removed appt in ListPanel.");
   }

   public void setSelection(String date, ArrayList<Appointment> selection) {
      // Clear all the items in the view and set
      // with the new selection for the date
      listView.clearView();
      // currDate allows us to update the appbook
      // when we modify the view
      currDate = date;
      // hash the appts so we can add/remove elements
      // from the appbook based on the item in the view
      currAppts = new HashMap<>();
      for (Appointment appt: selection) {
         listView.addItem(appt.getName());
         currAppts.put(appt.getName(), appt);
      }
      AppointmentCalendar.log("Set the selection for ListPanel for: " + currDate);
   }

   /*
    * Get observable for creating their observers
    */
   public ObservedList getListObservable() {
      return obsList;
   }

   public ObservedSelection getSelectionObservable() {
      return obsSelect;
   }

   /*
    * Set observers for the observables
    */
   public void addListObserver(ListObserver obs) {
      obsList.addObserver(obs);
   }

   public void addSelectionObserver(SelectionObserver obs) {
      obsSelect.addObserver(obs);
   }

}
