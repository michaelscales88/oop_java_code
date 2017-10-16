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
			"3. Manual value entry."							+ "\n" +
			"4. Display matrix values."						+ "\n" +
			"5. Add matricies and display result."			+ "\n" +
			"6. Multiply matricies and display result."	+ "\n" +
			"7. Quit."												+ "\n\n");

		return getEntry(CHOICE_LOW, CHOICE_HIGH);
	}

	public boolean choice(int option){
		int rows = 1, cols = 1, MIN_SIZE = 2, MAX_SIZE = 20;

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
				for(Matrix x : matrixSet)
					x.randValues();
				break;
			case 3:
				if((rows > 1) && (cols > 1)){
					for( int i = 0; i < matrixSet.length; i++ ){
						System.out.println("Matrix " + i );
						for( int x = 0; x < rows; x++ )
							for( int y = 0; y < cols; y++ )
								matrixSet[i].setValue(x, y, getEntry(0, 99));
					}
				}
				displaySet();
				break;
			case 4:
				displaySet();
				break;
			case 5:
				try{
					new Matrix(matrixSet[0].add(matrixSet[1])).showValues();
					//matrixSet[0].showValues();
				}
				catch(NullPointerException e){
					System.out.println("Matricies have not yet been created.");
				}
				break;
			case 6:
				try{
					new Matrix(matrixSet[0].multiply(matrixSet[1])).showValues();
					//matrixSet[0].showValues();
				}
				catch(NullPointerException e){
					System.out.println("Matricies have not yet been created.");
				}
				break;
			case 7:
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
