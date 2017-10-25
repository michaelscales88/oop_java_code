package dictionary;

import java.io.IOException;
import java.util.logging.*;
import java.util.Arrays;

public class Dictionary 
{
   private final static Logger LOGGER = Logger.getLogger(Dictionary.class.getName());

   private KeyNode head_node = null;
   private int num_keys = 0;
   private int num_values = 0;

   private void runTest(String[] raw_lines)
   {
      LOGGER.info("Logging begins...");
      //for (String line : raw_lines) 
        // LOGGER.info(line);
      String[] tokens = raw_lines[0].split(" => ");
      for (String value: Arrays.copyOfRange(tokens, 1, tokens.length))
            add_kv_pair(tokens[0], value);
      LOGGER.info("Printing values");
      print();
      LOGGER.info("Logging ended.");
   }

   private void add_kv_pair(String key, String value)
   {
      System.out.println("Adding key/value: " + key + "/" + value);
      if (head_node == null) 
      {
         head_node = new KeyNode(key, new ValueNode(value));
         num_keys++;
         num_values++;
      }
      else {
         // Find the key
         KeyNode cursor = head_node;

         while (cursor.link != null
                && cursor.key != key)
         {
            cursor = cursor.link;
         }

         if (cursor.key == key)
         {
            cursor.add_unique_value(new ValueNode(value));
            num_values++;
         } else {
            cursor.add_link(new KeyNode(key, new ValueNode(value)));
            num_keys++; num_values++;
         }
      }
   }

   public void print()
   {
      if (head_node == null) return;
      System.out.println("Num Keys/Values: " + num_keys + "/" + num_values);
      KeyNode cursor = head_node;
      cursor.print_values();
      while (cursor.link != null)
      {
         cursor.link.print_values();
         cursor = cursor.link;
      }
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
