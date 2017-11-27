package calendar;

import java.util.logging.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Window;

public class ButtonPanel extends JPanel
{
   private JButton hideBtn;
   private JButton closeBtn;
   //private final static Logger LOGGER = Logger.getLogger(" ");

   ButtonPanel() {
      initPanel();
   }

   private void initPanel() {
      // panel layout
      setBackground(Color.gray);
      hideBtn = new JButton("Hide/Show");
      hideBtn.setBounds(50, 375, 250, 50);
      closeBtn = new JButton("Close");
      closeBtn.setBounds(50, 375, 250, 50);


      // panel logic
      closeBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            closeWindow();
         }
      });

      add(hideBtn);
      add(closeBtn);
      setVisible(true);
   }

   public void closeWindow() {
      // Dispatch event to exit the program
      Window win = SwingUtilities.windowForComponent(this);
      win.dispatchEvent(new WindowEvent(win, WindowEvent.WINDOW_CLOSING));
   }

   public void linkPanel(JPanel panel) {
      hideBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            panel.setVisible(!panel.isVisible());
         }
      });
   }
}
