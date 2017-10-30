package quicksort;

import java.io.IOException;
import java.util.logging.*;

public class QuickSort
{
   private final static Logger LOGGER = Logger.getLogger(QuickSort.class.getName());
   private int[] my_nums;
   private Printer printer = new Printer();

   private void swap(int i, int j)
   {
      int temp = my_nums[i];
      my_nums[i] = my_nums[j];
      my_nums[j] = temp;
   }

   private int partition(int first, int last)
   {
      int pivot = my_nums[first], i = first, j = last;
      while (true)
      {
         // Find where lhs value larger than pivot
         while (my_nums[i] < pivot) i++;
         // Find where the rhs value is smaller than pivot
         while (my_nums[j] > pivot) j--;

         if (i < j) swap(i, j);
         else return j;
      }
   }

   private void quick_sort(int left, int right)
   {
      if (left < right)
      {
         int mid = partition(left, right);
         quick_sort(left, mid);
         quick_sort(mid + 1, right);
      }
   }

   public void sort_asc(int[] numbers)
   {
      if (numbers == null || numbers.length == 0) return;
      my_nums = numbers;
      printer.print(my_nums);
      quick_sort(0, my_nums.length - 1);
      printer.print(my_nums);
   }

   public static void main(String[] args) throws IOException
   {
      // Configure logger and handler
      Handler fh = new FileHandler("quicksort/test.log", true);
      fh.setFormatter(new SimpleFormatter());
      LOGGER.addHandler(fh);
      LOGGER.setLevel(Level.INFO);
      LOGGER.info("Logging begins...");

      long start_time, end_time, duration;
      QuickSort s1 = new QuickSort();

      // Parse CLI arguments
      int[] numbers = FileOpener.open_file(args[0], Integer.parseInt(args[1]));

      // Test sort ascending
      start_time = System.nanoTime();
      s1.sort_asc(numbers);
      end_time = System.nanoTime();
      duration = (end_time - start_time);
      System.out.println("Duration: " + duration / 1000000 + " ms");

      LOGGER.info("Logging ended.");
      // Close log file
      fh.flush();
      fh.close();
   }
}
