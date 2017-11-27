package calendar;

import java.util.Observer;
import java.util.Observable;

public class SelectionObserver implements Observer
{
   private TextPanel tPanel;
   private ObservedSelection ov;

   public SelectionObserver(ObservedSelection ov, TextPanel textPanel) {
      this.tPanel = textPanel;
      this.ov = ov;
   }

   public void update(Observable obs, Object obj) {
      if (obs == ov) {
         // Update textpanel with the currently 
         // selected appointment
         tPanel.setApptForm(ov.getAppt());
      }
   }
}
