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


   private void p_quick_sort(int left, int right)
   {
      if (left < right)
      {
         int mid = partition(left, right);
         p_quick_sort(left, mid);
         p_quick_sort(mid + 1, right);
      }
   }

   private void quick_sort(int left, int right)
   {
      int i = left, j = right;
      int pivot = my_nums[left + (right - left) / 2];

      while (i <= j)
      {
         while (my_nums[i] < pivot) i++;
         while (my_nums[j] > pivot) j--;

         if (i <= j)
         {
            swap(i, j);
            i++;
            j--;
         }
      }

      if (left < j)
         quick_sort(left, j);
      if (right > i)
         quick_sort(i, right);
   }

   public void partition_sort(int[] numbers)
   {
      if (numbers == null || numbers.length == 0) return;
      my_nums = numbers;
      printer.print(my_nums);
      p_quick_sort(0, my_nums.length - 1);
      printer.print(my_nums);
   }

   public void no_partition_sort(int[] numbers)
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

      // Test sort ascending partition
      start_time = System.currentTimeMillis();
      s1.no_partition_sort(numbers);
      end_time = System.currentTimeMillis();
      duration = (end_time - start_time);
      System.out.println("Duration: " + duration + " ms");

      // Test sort ascending partition
      start_time = System.currentTimeMillis();
      s1.partition_sort(numbers);
      end_time = System.currentTimeMillis();
      duration = (end_time - start_time);
      System.out.println("Duration: " + duration + " ms");

      LOGGER.info("Logging ended.");
      // Close log file
      fh.flush();
      fh.close();
   }
}
