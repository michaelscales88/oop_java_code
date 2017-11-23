package calendar;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ListModelPanel extends JPanel
{
   //private final static Logger LOGGER = Logger.getLogger(" ");
   private AListModel model;
   Integer counter = 0;

   ListModelPanel() {
      setLayout(new BorderLayout());
      model = new AListModel();
      JScrollPane pane = new JScrollPane(model.getList());

      JButton addBtn = new JButton("Add");
      JButton remBtn = new JButton("Remove");
      addBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            model.addItem("Element " + counter);
            counter++;
         }
      });
      remBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (model.getSize() > 0)
               model.removeItem(model.getList().getSelectedIndex());
         }
      });

      add(pane, BorderLayout.NORTH);
      add(addBtn, BorderLayout.WEST);
      add(remBtn, BorderLayout.EAST);
   }

   public void setSelection(String selDate) {
      System.out.println(selDate);
   }
}
