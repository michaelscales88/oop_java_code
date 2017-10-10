package problem3.example;

public class QuickSort {

    public static void main(String[] args) {
        int[] numbers = FileOpener.open_file(args[0], Integer.parseInt(args[1]));
        for (int number: numbers) {
            System.out.println(number);
        }
    }
}
