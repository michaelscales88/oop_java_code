package calendar;

import org.jdatepicker.AbstractDateModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateModel extends AbstractDateModel<String> 
{

   private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

   public DateModel(String value) {
      super();
      setValue(value);
   }

   @Override
   protected String fromCalendar(Calendar from) {
      return sdf.format(from.getTime());
   }

   @Override
   protected Calendar toCalendar(String from) {
      try {
         Calendar c = Calendar.getInstance();
         c.setTime(sdf.parse(from));
         return c;
      } catch (ParseException e) {
         throw new RuntimeException(e);
      }
   }
}
