package matrix;
import java.util.*;
import java.io.*;

class MatrixTest{
	static class MatrixIO{
		FileHandler fileHandler;
		Vector<String> input, output;

		private Matrix matrix1, matrix2, result;

		public MatrixIO(String in){
			matrix1 = new Matrix();
			matrix2 = new Matrix();
			fileHandler = new FileHandler(in, "matrix.out");
			input = fileHandler.read();
			output = new Vector<String>();
		}

		public void setMatrix(String[] newRowsCols){
			matrix1.newMatrix(newRowsCols[0], newRowsCols[1]);
			matrix2.newMatrix(newRowsCols[2], newRowsCols[3]);
		}

		public void newValues(){
			matrix1.randValues();
			matrix2.randValues();
		}

		private void add(){
			result = new Matrix(matrix1.add(matrix2));
			output.addAll(matrix1.showValues());
			output.addElement("\naddition with\n");
			output.addAll(matrix2.showValues());
			output.addElement("\nequals\n");
			output.addAll(result.showValues());
		}

		private void multiply(){
			result = new Matrix(matrix1.multiply(matrix2));
			output.addAll(matrix1.showValues());
			output.addElement("\nmultiplied by\n");
			output.addAll(matrix2.showValues());
			output.addElement("\nequals\n");
			output.addAll(result.showValues());
		}

		public void processIO(){
			String[] inputDimensions = new String[4];
			int len = input.size(), ct = 0;
			String in = "", mul = "multiply", ad = "add";

			while(ct < len){
				in = input.get(ct);

				if(in.length() == 1)
					inputDimensions[(ct % 4)] = in;
				else if((in.length() != mul.length()) ||
						  (in.length() != ad.length())){
					setMatrix(inputDimensions);
					if(in.equals(mul))
						multiply();
					if(in.equals(ad))
						add();
				}
				else{
					output.addElement("Input file improperly formatted...");
					ct = len;
				}
				ct++;
			}
		}

		public void writeOutputToFile(){
			fileHandler.writeVec(output);
		}
	}

	public static void main(String[] args){
		MatrixIO test = new MatrixIO(args[0]);
		test.processIO();
		test.writeOutputToFile();
	}
}
