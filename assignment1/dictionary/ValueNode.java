package dictionary;

public class ValueNode
{
   protected final String value;
   protected ValueNode link = null;

   public ValueNode(String value)
   {
      this.value = value;
   }

   public void add_link(ValueNode link)
   {
      this.link = link;
   }

   public void print_key_val()
   {
      System.out.println("v: " + value);
   }
}
