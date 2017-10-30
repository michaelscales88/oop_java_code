package dictionary;

import java.io.IOException;
import java.util.logging.*;

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
      // null value represents non existent key
      System.out.println("Key not found.");
      return null;
   }

   private void make_head(String key, String value)
   {
      // Make the first instance of a KeyNode
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
            // Replace the head_node if key is the first node
            if (cursor == head_node) head_node = cursor.link;
            // Remove the link to key to  delete
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
                   && !cursor.key.equals(key)) cursor = cursor.link;
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
      System.out.println(" ");
      KeyNode cursor = head_node;
      while (cursor != null)
      {
         cursor.print_values();
         cursor = cursor.link;
      }
   }

   public void query(String key)
   {
      KeyNode k_node = get(key);
      if (k_node != null) k_node.print_values();
      else System.out.println("Key not found. No values to print");
   }

   public static void main(String[] args) throws IOException
   {
      // Configure logger and handler
      Handler fh = new FileHandler("dictionary/dictionary.log", true);
      fh.setFormatter(new SimpleFormatter());
      LOGGER.addHandler(fh);
      LOGGER.setLevel(Level.INFO);
      LOGGER.info("Logging begins...");

      // Parse CLI arguments
      String file_name = args[0];

      FileOpener rdr = new FileOpener(args[0], "dictionary/dictionary.out");
      String[] raw_lines = rdr.read();

      // Create a dictionary and run the test
      Dictionary dict = new Dictionary();

      // Load file
      LOGGER.info("Begin loading keys/values...");
      dict.load(raw_lines);
      LOGGER.info("Completed loading keys and values.");

      // Print/traverse test
      LOGGER.info("Begin printing all key/value pairs.");
      System.out.println("Printing entire dict: ");
      System.out.println(" ");
      dict.print();
      System.out.println(" ");
      System.out.println(" ");
      LOGGER.info("Completed printing key/value pairs.");

      // Search test
      LOGGER.info("Begin search for key.");
      System.out.println("Testing present word: apple.");
      dict.query("apple");
      System.out.println(" ");
      System.out.println("Testing not present word: bob.");
      dict.query("bob");
      System.out.println(" ");
      System.out.println("Completed searching for bob and apple.");
      System.out.println(" ");
      System.out.println(" ");

      LOGGER.info("Completed key search.");

      // Delete test
      LOGGER.info("Testing dictionary delete key.");
      System.out.println("Deleting key 'apple'.");
      dict.del_key("apple");
      System.out.println(" ");
      System.out.println("Print showing that apple was removed.");
      System.out.println(" ");
      dict.print();
      System.out.println(" ");
      System.out.println("Completed testing delete.");
      LOGGER.info("Completed delete test.");
      LOGGER.info("Logging ended.");

      // Close log file
      fh.flush();
      fh.close();
   }
}
