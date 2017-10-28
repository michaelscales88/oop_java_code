package dictionary;

public class KeyNode
{
   protected final String key;
   protected ValueNode head_node;
   protected KeyNode link = null;
   protected int num_vals;

   public KeyNode(String key, ValueNode head_node)
   {
      this.key = key;
      this.head_node = head_node;
      num_vals = 1;
   }

   public void add_link(KeyNode link)
   {
      this.link = link;
   }

   public void add_unique_value(ValueNode new_value)
   {
      ValueNode cursor = head_node;
      // Check the first node
      if (cursor.value.equals(new_value.value)) return;
      // Check subsequent nodes
      while (cursor.link != null)
      {
         if (cursor.value.equals(new_value.value)) return;
         cursor = cursor.link;
      }
      cursor.add_link(new_value);
      num_vals++;
   }

   public void print_values()
   {
      // Traverse and print
      ValueNode cursor = head_node;
      System.out.print(key + ": ");
      do
      {
         System.out.print(cursor.value);
         if (cursor.link == null) System.out.println(".");
         else System.out.print(", ");
         cursor = cursor.link;
      } while (cursor != null);
   }
}
