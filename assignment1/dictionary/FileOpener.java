package dictionary;
import java.io.*;

class FileOpener {

   static String[] open_file(String file_name, int read_chars)
   {
      String[] lines = new String[read_chars];
      int idx = 0;
      System.out.println("Trying to open" + file_name);
      FileReader fileReader = null;
      try {
         fileReader = new FileReader(file_name);
         BufferedReader bufferedReader = new BufferedReader(fileReader);
         String line;
         while ((line = bufferedReader.readLine()) != null)
         {
            lines[idx] = line;
            idx++;
         }
      } catch (Exception e) {
         System.out.println("Exception " + e + " for " + file_name);
      } finally {
         System.out.println("Closing: " + file_name);
         if (fileReader != null) {
            try {
               fileReader.close();
            } catch (IOException ex) {
            // ignore ... any significant errors should already have been
            // reported via an IOException from the final flush.
            }
         }
      }
      return lines;
   }
}
