package numbers;
import java.util.Vector;

class NumbersDriver{

	static class TestIO extends FileHandler{
		FileHandler fileHandler = new FileHandler(inFile, outFile);
		Vector<String> input, output;
		int nextElement;

		public TestIO(){
			super("input.txt", "output.txt");
			input = fileHandler.read();
			output = new Vector<>();
			nextElement = 0;
		}

		public TestIO(String in, String out){
			super(in, out);
			input = fileHandler.read();
			output = new Vector<>();
			nextElement = 0;
		}

		public void writeTitle(String title){
			fileHandler.writeAppendString(title);
		}

		public int getNextInput(){
			return Integer.parseInt(input.get(nextElement++));
		}

		public void resetInput(){
			nextElement = 0;
		}

		public void writeResults(Vector<String> results)
			throws NumberFormatException{
			if(fileHandler.writeAppend(results))
				System.out.println("Output successfully written.");
		}

		public Boolean testNotDone(){
			return (nextElement < input.size());
		}
	}

	public static void incTest(TestIO test){
		Increase increase = new Increase();
		test.writeTitle("\nIncrease test case I/O...");
		while(test.testNotDone()){
			try{
				increase = new Increase(test.getNextInput());
				test.writeResults(increase.getList());
			}
			catch(NumberFormatException e){
				System.out.println("Please provide integers only.");
			}
		}
		test.resetInput();
	}

	public static void binTest(TestIO test){
		Binary binary = new Binary();
		test.writeTitle("\nBinary test case I/O...");
		while(test.testNotDone()){
			try{
				binary = new Binary(test.getNextInput());
				test.writeResults(binary.getList());
			}
			catch(NumberFormatException e){
				System.out.println("Please provide integers only.");
			}
		}
		test.resetInput();
	}

	public static void main(String[] args){
		String inFile = args[0], outFile = args[1];
		TestIO test = new TestIO(inFile, outFile);
		incTest(test);
		binTest(test);
	}
}
