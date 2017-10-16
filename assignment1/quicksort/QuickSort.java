package quicksort;

public class QuickSort {

    private String file_name;
    private int size;

    QuickSort(String file_name, int size)
    {
        this.size = size;
        this.file_name = file_name;
    }

    private void print(int[] my_numbers)
    {
        System.out.print("My numbers: [ ");
        for (int number : my_numbers) {
            System.out.print(number + " ");
        }
        System.out.println("]");
    }

    void quick_sort(int[] my_numbers, int left, int right)
    {
        if (my_numbers == null || my_numbers.length == 0) return;
        if (left >= right) return;
        int pivot_idx = (left + (right - left)) / 2;
        int i = left, j = right;
        while (i <= j)
        {
            // Find where lhs value larger than pivot
            while (my_numbers[i] < my_numbers[pivot_idx]) i++;
            // Find where the rhs value is smaller than pivot
            while (my_numbers[j] > my_numbers[pivot_idx]) j--;

            if (i <= j)
            {
                int temp = my_numbers[i];
                my_numbers[i] = my_numbers[j];
                my_numbers[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j)
            quick_sort(my_numbers, left, j);

        if (right > i)
            quick_sort(my_numbers, i, right);
    }

    void sort_asc()
    {
        int[] my_numbers = FileOpener.open_file(file_name, size);
        print(my_numbers);
        quick_sort(my_numbers,0, size - 1);
        print(my_numbers);
    }

    public static void main(String[] args)
    {
        QuickSort s1 = new QuickSort(args[0], Integer.parseInt(args[1]));
        s1.sort_asc();
    }
}
