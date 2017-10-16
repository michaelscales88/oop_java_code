package dictionary;

public class Dictionary 
{

   public static void main(String[] args)
   {
      System.out.println("Hello World");
      String[] raw_lines = FileOpener.open_file(args[0], Integer.parseInt(args[1]));
      for (String line : raw_lines) 
         System.out.println(line);

   }
}
