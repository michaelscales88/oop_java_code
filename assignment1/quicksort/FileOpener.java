package quicksort;
import java.io.*;
import java.util.Vector;

public class FileOpener
{
   private String inFile;
   private Vector<Integer> inLines;
   private FileReader fileReader;

   public FileOpener()
   {
      inFile = "input.txt";
      inLines = new Vector<Integer>();
   }

   public FileOpener(String in, String out)
   {
      inFile = in;
      inLines = new Vector<Integer>();
   }

   public int[] read()
   {
      Vector<Integer> input = new Vector<Integer>();
      try
      {
         input = tryRead();
      }
      catch(Exception e)
      {
         System.out.println("Exception " + e + " for " + inFile);
      }
      finally
      {
         System.out.println("Closing: " + inFile);
         if (fileReader != null){
            try
            {
               fileReader.close();
            }
            catch(IOException ex)
            {
               //////////////////
            }
         }
      }
      return convert_vector(input);
   }

   public int[] convert_vector(Vector<Integer> vec)
   {
      int[] con_vec = new int[vec.size()];
      int i = 0;
      for (Integer v: vec) {
         con_vec[i] = v;
         i++;
      }
      return con_vec;
   }

   private Vector<Integer> tryRead() throws Exception
   {
      String line = null;
      FileReader fileReader = new FileReader(inFile);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      while((line = bufferedReader.readLine()) != null)
         inLines.add(Integer.parseInt(line));
      return inLines;
   }
}
