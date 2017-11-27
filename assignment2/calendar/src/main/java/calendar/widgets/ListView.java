package calendar;

import java.util.ArrayList;
import java.util.logging.*;
import java.awt.*;
import javax.swing.*;

public class ListView 
{
   private JList list;
   private DefaultListModel<String> model;

   ListView() {
      initView();
   }

   private void initView() {
      model = new DefaultListModel();

      // JList settings
      list = new JList(model);
      list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      list.setLayoutOrientation(JList.VERTICAL);
      list.setVisibleRowCount(5);
      list.setBounds(50, 150, 75, 90);
   }

   public void addItem(String item) {
      if (model.contains(item)) AppointmentCalendar.log("Cannot add item. \n" +
                                                        "Item already exists.");
      else model.addElement(item);
   }

   public void remItem(String item) {
      if (model.contains(item)) model.removeElement(item);
      else AppointmentCalendar.log("Cannot remove item. \n" +
                                   "Item does not exist.");
   }

   public JList getList() {
      return list;
   }

   public void clearView() {
      // Clear the view for a new selection
      model.clear();
   }

   public Object currentValue() {
      return list.getSelectedValue();
   }
}
