package dictionary;

public class LinkNode
{
   private String key;
   private String value;

   public LinkNode(String key, String value)
   {
      this.key = key;
      this.value = value;
   }

   public void print_key_val()
   {
      System.out.println("k: " + key);
      System.out.println("v: " + value);
   }
}
