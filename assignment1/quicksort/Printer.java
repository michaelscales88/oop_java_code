package quicksort;

public class Printer
{
   public void print(int[] numbers)
    {
        System.out.print("My numbers: [ ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("]");
    }
}
