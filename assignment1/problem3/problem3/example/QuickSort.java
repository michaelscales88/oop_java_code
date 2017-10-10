package problem3.example;

public class QuickSort {

    public static void main(String[] args) {
        FileOpener reader = new FileOpener(args[0]);
        int[] numbers = reader.open_file();
        for (int number: numbers) {
            System.out.println(number);
        }
    }
}
