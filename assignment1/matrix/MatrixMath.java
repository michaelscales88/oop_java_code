package matrix;
import java.util.*;

public class MatrixMath{

	private Matrix[] matrixSet = new Matrix[2];

	public int menu(){
		int CHOICE_LOW = 1, CHOICE_HIGH = 7;

		System.out.print(											  "\n" +
			"Welcome to the Matrix Creator!"					+ "\n" +
			"-----------------------------------------"	+ "\n" +
			"1. Generate 2 matricies of size (N x M)."	+ "\n" +
			"2. Assign random values."							+ "\n" +
			"3. Display matrix values."						+ "\n" +
			"4. Add matricies and display result."			+ "\n" +
			"5. Multiply matricies and display result."	+ "\n" +
			"6. Quit."												+ "\n\n");

		return getEntry(CHOICE_LOW, CHOICE_HIGH);
	}

	public boolean choice(int option){
		int rows = 1, cols = 1, MIN_SIZE = 2, MAX_SIZE = 20;
		String nullMessage = "Matricies have not yet been generated.";

		switch(option){
			case 1:
				System.out.println
					("\nEnter integer 2-20");
				for( int x = 0; x < matrixSet.length; x++ ){
					System.out.print
						("Matrix " + (x+1) + "\n" + "Enter Rows ");
					rows = getEntry(MIN_SIZE, MAX_SIZE);

					System.out.print("Enter Columns ");
					cols = getEntry(MIN_SIZE, MAX_SIZE);

					matrixSet[x] = new Matrix(rows, cols);
				}
				break;
			case 2:
				try{
					for(Matrix x : matrixSet)
						x.randValues();
				}
				catch(NullPointerException e){
					System.out.println(nullMessage);
				}
				break;
			case 3:
				try{
					displaySet();
				}
				catch(NullPointerException e){
					System.out.println(nullMessage);
				}
				break;
			case 4:
				try{
					new Matrix(matrixSet[0].add(matrixSet[1])).showValues();
				}
				catch(NullPointerException e){
					System.out.println(nullMessage);
				}
				break;
			case 5:
				try{
					new Matrix(matrixSet[0].multiply(matrixSet[1])).showValues();
				}
				catch(NullPointerException e){
					System.out.println(nullMessage);
				}
				break;
			case 6:
			default:
				return true;
		}
		return false;
	}

	private int getEntry(int lowerBound, int upperBound){
		Scanner reader = new Scanner(System.in);
		MyException bounds = new MyException
			(String.format("Please enter integer from %d to %d ",
			lowerBound, upperBound));

		int entry = 0;
		boolean prompt = true;
		while( prompt ){
			try{
				System.out.print("-> ");
	    		entry = reader.nextInt();
				if((entry > upperBound) || (entry < lowerBound))
					throw bounds;
				prompt = false;
			}
			catch(MyException e){
				System.out.println(e.getMessage());
			}
			catch(NumberFormatException e){
				System.out.print("Please enter valid integer ");
				reader.next();
			}
			catch(InputMismatchException e){
	    		System.out.print("Please enter valid integer ");
				reader.next();
			}
		}
		return entry;
	}

	private void displaySet(){
		for(Matrix x : matrixSet)
			x.showValues();
	}

	public static void main(String[] args){
		MatrixMath doMath = new MatrixMath();
		while(!doMath.choice(doMath.menu())){};
	}
}
