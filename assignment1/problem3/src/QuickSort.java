package src;

public class QuickSort {

    private int[] my_numbers;
    int size;

    QuickSort(String file_name, int size)
    {
        this.size = size;
        my_numbers = FileOpener.open_file(file_name, size);
    }

    static void print(int[] numbers)
    {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    void partition(int[] numbers)
    {
        int pivot_idx = size / 2,
            rightmark = size,
            leftmark = 0,
            tmp;

        // Track partition
        while (leftmark < rightmark) {
            // Find larger number on left
            while (numbers[leftmark] < numbers[pivot_idx]) { leftmark++; }
            // Find larger number on right
            while (numbers[rightmark] < numbers[pivot_idx]) { rightmark--; }

        }

        QuickSort.print(numbers);
    }

    void sort_asc() {
        int pivot_idx = 0;

//        for (;pivot_idx < 20; pivot_idx++) {
//            System.out.println(numbers[pivot_idx]);
//        }
        QuickSort.print(this.my_numbers);
    }

    public static void main(String[] args) {
        QuickSort s1 = new QuickSort(args[0], Integer.parseInt(args[1]));
        s1.sort_asc();
//        QuickSort.partition(numbers);
    }
}
