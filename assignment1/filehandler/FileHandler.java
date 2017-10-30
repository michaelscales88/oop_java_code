//package filehandler;
package numbers;
import java.io.*;
import java.util.Vector;
//import java.lang.Exception;

public class FileHandler{
	String inFile, outFile;
	Vector<String> inLines;
	FileReader fileReader;

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
            // ignore ... any significant errors should already have been
            // reported via an IOException from the final flush.
            }
				//fileReader.close();
      	}
		}
		return input;
	}

	public Boolean write(Vector<String> outLines){
		try{
			tryWrite(outLines);
		}
		catch(IOException ex){
			System.out.println("Error writing to file, " + outFile);
			return false;
      }
		finally{
			return true;
		}
	}

	public Boolean writeAppend(Vector<String> outLines){
		try{
			tryWriteAppend(outLines);
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
		fileReader = new FileReader(inFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while((line = bufferedReader.readLine()) != null)
			inLines.addElement(line);
		return inLines;
	}

	private void tryWrite(Vector<String> outLines) throws IOException{
		FileWriter fileWriter = new FileWriter(outFile);
      PrintWriter printWriter = new PrintWriter(fileWriter);
		int len = outLines.size(), ct = 0;
		while(ct < len){
			printWriter.print(outLines.get(ct));
			ct++;
		}
		printWriter.close();
	}

	private void tryWriteAppend(Vector<String> outLines) throws IOException{
		BufferedWriter printWriter = new BufferedWriter(new FileWriter(outFile, true));
		int len = outLines.size(), ct = 0;
		while(ct < len){
			printWriter.append(outLines.get(ct) + " ");
			ct++;
		}
		printWriter.append("\n");
		printWriter.close();
	}
}
