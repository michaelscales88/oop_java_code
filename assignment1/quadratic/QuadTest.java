package quadratic;
import java.util.Vector;
import java.util.StringTokenizer;

public class QuadTest{
	Vector<String> input, output;
	FileHandler fileHandler;
	Quadratic quad;

	private QuadTest(String in, String out){
		fileHandler = new FileHandler(in, out);
		input = fileHandler.read();
		output = new Vector<>();
	}

	private Double[] read(String line){
		Double[] abc = new Double[3];
		StringTokenizer st = new StringTokenizer(line," ");
		int ct = 0;
     	while(st.hasMoreTokens()){
			abc[ct] = Double.parseDouble(st.nextToken());
			ct++;
		}
		return abc;
	}

	private void runTest(){
		int ct = 0, len = input.size();
		// = new Double[3];

		while(ct < len){
			Double[] abc = (read(input.get(ct)));
			Quadratic test = new Quadratic(abc);

			test.calculate();
			test.displayResults();
			test.verifyResults();

			output.addAll(test.getResults());
			output.addElement("\n");

			ct++;
		}
	}

	private void writeOutputToFile(){
		fileHandler.writeVec(output);
	}

	public static void main(String[] args){
		QuadTest test = new QuadTest(args[0], args[1]);
		test.runTest();
		test.writeOutputToFile();
	}
}
