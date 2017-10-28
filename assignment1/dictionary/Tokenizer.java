package dictionary;

public class Tokenizer
{ 
   public static String[] tokenize(String raw_line, String delim)
   {
      return (raw_line.split(delim));
   }
}
