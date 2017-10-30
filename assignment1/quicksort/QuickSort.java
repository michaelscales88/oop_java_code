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

   void test_non_partition(int[] numbers)
   {
      long start_time, end_time, duration;
      System.out.println("Non-partioned Quicksort:  ");
      System.out.println(" ");

      start_time = System.currentTimeMillis();
      no_partition_sort(numbers);
      end_time = System.currentTimeMillis();
      duration = (end_time - start_time);

      System.out.println("Duration: " + duration + " ms");
      System.out.println(" ");
      System.out.println(" ");
   }

   void test_partition(int[] numbers)
   {
      long start_time, end_time, duration;
      System.out.println("Partioned Quicksort:  ");
      System.out.println(" ");

      start_time = System.currentTimeMillis();
      partition_sort(numbers);
      end_time = System.currentTimeMillis();
      duration = (end_time - start_time);

      System.out.println("Duration: " + duration + " ms");
      System.out.println(" ");
      System.out.println(" ");

   }

   public static void main(String[] args) throws IOException
   {
      // Configure logger and handler
      Handler fh = new FileHandler("quicksort/quicksort.log", true);
      fh.setFormatter(new SimpleFormatter());
      LOGGER.addHandler(fh);
      LOGGER.setLevel(Level.INFO);
      LOGGER.info("Logging begins...");

      FileOpener rdr = new FileOpener(args[0], "quicksort/quicksort.out");
      QuickSort s1 = new QuickSort();

      // Parse CLI arguments
      int[] nums1 = rdr.read();
      int[] nums2 = nums1.clone();

      // Less efficient example of quicksort
      LOGGER.info("Start non-partitioned Quicksort.");
      s1.test_non_partition(nums1);
      LOGGER.info("Completed non-partitioned Quicksort.");

      // Most efficient example of quicksort
      LOGGER.info("Start partitioned Quicksort.");
      s1.test_partition(nums2);
      LOGGER.info("Completed partitioned Quicksort.");

      LOGGER.info("Logging ended.");
      // Close log file
      fh.flush();
      fh.close();
   }
}
