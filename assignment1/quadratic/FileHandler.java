package quadratic;
import java.io.*;
import java.util.Vector;

public class FileHandler{
	private String inFile, outFile;
	private Vector<String> inLines;
	private FileReader fileReader;

	public FileHandler(){
		inFile = "input.txt";
		outFile = "output.txt";
		inLines = new Vector<String>();
	}

	public FileHandler(String in, String out){
		inFile = in;
		outFile = out;
		inLines = new Vector<String>();
	}

	public Vector<String> read(){
		Vector<String> input = new Vector<String>();
		try{
			input = tryRead();
		}
		catch(Exception e){
			System.out.println("Exception " + e + " for " + inFile);
		}
		finally{
         System.out.println("Closing: " + inFile);
			if (fileReader != null){
            try{
            	fileReader.close();
            }
				catch(IOException ex){
					//////////////////
				}
      	}
		}
		return input;
	}

	public void writeVec(Vector<String> outLines){
		write("");
		for(String line : outLines)
			writeAppend(line);
	}

	public void writeAppendVec(Vector<String> outLines){
		int len = outLines.size(), ct = 0, width = 0;
		String out = "";
		for(String lines : outLines){
			writeAppend(lines);
		}
	}

	public Boolean write(String line){
		try{
			tryWrite(line);
		}
		catch(IOException ex){
			System.out.println("Error writing to file, " + outFile);
			return false;
      }
		finally{
			return true;
		}
	}

	public Boolean writeAppend(String line){
		try{
			tryWriteAppend(line);
		}
		catch(IOException ex){
			System.out.println("Error writing to file, " + outFile);
			return false;
      }
		finally{
			return true;
		}
	}

	private Vector<String> tryRead() throws Exception{
		String line = null;
		FileReader fileReader = new FileReader(inFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while((line = bufferedReader.readLine()) != null)
			inLines.addElement(line);
		return inLines;
	}

	private void tryWrite(String line) throws IOException{
		FileWriter fileWriter = new FileWriter(outFile);
      PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.write(line);
		printWriter.close();
	}

	private void tryWriteAppend(String line) throws IOException{
		BufferedWriter printWriter =
			new BufferedWriter(new FileWriter(outFile, true));
		printWriter.append(line);
		printWriter.close();
	}
}
