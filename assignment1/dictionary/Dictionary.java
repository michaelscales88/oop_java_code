package dictionary;

import java.io.IOException;
import java.util.logging.*;
import java.util.Arrays;

public class Dictionary 
{
   private final static Logger LOGGER = Logger.getLogger(Dictionary.class.getName());
   private KeyNode head_node = null;
   private int num_keys = 0;
   private int num_vals = 0;
   private String[] tokens;

   private void load(String[] raw_lines)
   {
      String key, raw_vals;
      for (String raw_line: raw_lines)
      {
         if (raw_line != null)
         {
            tokens = Tokenizer.tokenize(raw_line, " => ");
            key = tokens[0];
            raw_vals = tokens[1];
            add_kv_pair(key, raw_vals);
         }
      }
   }

   public KeyNode get(String key)
   {
      KeyNode cursor = head_node;
      boolean found = false;
      do
      {
         if (cursor.key.equals(key))
         {
            found = true;
            break;
         }
         cursor = cursor.link;
      } while (cursor != null);
      if (found) return cursor;
      System.out.println("Key not found.");
      return null;
   }

   private void make_head(String key, String value)
   {
      head_node = new KeyNode(key, new ValueNode(value));
      num_keys++;
      num_vals++;
   }

   private void add_key(KeyNode cursor, String key, String value)
   {
      // Add first instance of key to the tail
      cursor.add_link(new KeyNode(key, new ValueNode(value)));
      num_keys++;
      num_vals++;
   }

   private void add_val(KeyNode cursor, String value)
   {
      // Store value in existing key
      cursor.add_unique_value(new ValueNode(value));
      num_vals++;
   }

   private void del_key(String key)
   {
      KeyNode cursor = head_node, prev_node = null;
      while (cursor != null)
      {
         if (cursor.key.equals(key))
         {
            if (cursor == head_node) head_node = cursor.link;
            else prev_node.link = cursor.link;
            num_keys--;
            num_vals -= cursor.num_vals;
            break;
         }
         prev_node = cursor;
         cursor = cursor.link;
      }
   }

   private void add_kv_pair(String key, String raw_vals)
   {
      for (String value: Tokenizer.tokenize(raw_vals, ", "))
      {
         // Make the first key-value pair in the linked list
         if (head_node == null) make_head(key, value);
         else {
            KeyNode cursor = head_node;
            // Find the key
            while (cursor.link != null
                   && cursor.key != key) cursor = cursor.link;
            // Add value to existing KeyNode
            if (cursor.key.equals(key)) add_val(cursor, value);
            // Create a new KeyNode and ValueNode
            else add_key(cursor, key, value);
         }
      }
   }

   public void print()
   {
      System.out.println("Num Keys/Values: " + num_keys + "/" + num_vals);
      KeyNode cursor = head_node;
      while (cursor != null)
      {
         cursor.print_values();
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
      LOGGER.info("Logging begins...");
      // Parse CLI arguments
      String file_name = args[0];
      int array_size = Integer.parseInt(args[1]);

      // Create a dictionary and run the test
      Dictionary dict = new Dictionary();
      String[] raw_lines = FileOpener.open_file(file_name, array_size);

      // Load file
      LOGGER.info("Begin loading keys/values...");
      dict.load(raw_lines);
      LOGGER.info("Completed loading keys and values");

      // Show all key value pairs
      LOGGER.info("Begin printing all key/value pairs.");
      dict.print();
      LOGGER.info("Completed printing key/value pairs.");

      // Find key and print values
      LOGGER.info("Begin search for key");
      KeyNode k_node = null;
      k_node = dict.get("apple");
      if (k_node != null) k_node.print_values();
      k_node = dict.get("bob");
      if (k_node != null) k_node.print_values();
      LOGGER.info("Completed search for key.");

      LOGGER.info("Completed search for key.");
      dict.del_key("apple");
      dict.print();
      LOGGER.info("Completed search for key.");
      LOGGER.info("Logging ended.");
      // Close log file
      fh.flush();
      fh.close();
   }
}
