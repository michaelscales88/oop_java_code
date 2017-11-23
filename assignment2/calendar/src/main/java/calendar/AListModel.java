package calendar;

import java.util.ArrayList;
import java.util.logging.*;
import java.awt.*;
import javax.swing.*;

public class AListModel
{
   private final static Logger LOGGER = Logger.getLogger(" ");
   JList list;
   DefaultListModel<String> model;

   AListModel() {
      initWidget();
   }

   private void initWidget() {
      model = new DefaultListModel();

      // JList settings
      list = new JList(model);
      list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      list.setLayoutOrientation(JList.VERTICAL);
      list.setVisibleRowCount(5);
      list.setBounds(50, 150, 75, 90);
   }

   public void updateModel(ArrayList<String> newList) {
      model = new DefaultListModel<>();
      for (String s: newList)
         model.addElement(s);
   }

   public void removeItem(Integer remIdx) {
      if (remIdx < model.getSize()) model.remove(remIdx);
      else
         LOGGER.info("Cannot remove item. Item does not exist.");
   }

   public void addItem(String addItem) {
      if (model.contains(addItem))
         LOGGER.info("Cannot add item. Item already exists.");
      else model.addElement(addItem);
   }

   public Integer getSize() {
      return model.getSize();
   }

   public JList getList() {
      return list;
   }
}
