package dictionary;

import java.io.IOException;
import java.util.logging.*;

public class Dictionary 
{
   private final static Logger LOGGER = Logger.getLogger(Dictionary.class.getName())

   public void runTest(String[] raw_lines)
   {
      LOGGER.info("Logging begins...");
      for (String line : raw_lines) 
         LOGGER.info(line);
      String[] tokens = raw_lines[0].split(" => ");
      LinkNode a_node = new LinkNode(tokens[0], tokens[1]);
      a_node.print_key_val();
      LOGGER.info("Logging ended.");
   }

   public static void main(String[] args) throws IOException
   {
      // Configure logger and handler
      Handler fh = new FileHandler("dictionary/test.log", true);
      fh.setFormatter(new SimpleFormatter());
      LOGGER.addHandler(fh);
      LOGGER.setLevel(Level.INFO);

      // Parse CLI arguments
      String file_name = args[0];
      int array_size = Integer.parseInt(args[1]);

      // Create a dictionary and run the test
      Dictionary dict = new Dictionary();
      String[] raw_lines = FileOpener.open_file(file_name, array_size);
      dict.runTest(raw_lines);

      // Close log file
      fh.flush();
      fh.close();
   }
}
