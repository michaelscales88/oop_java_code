package problem3.example;
import java.io.*;

class FileOpener {
    private String file_name;

    FileOpener(String file_name) {
        this.file_name = file_name;
    }

    int[] open_file() {
        int[] numbers = {};
        System.out.println(this.file_name);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(this.file_name);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
//                numbers.add(Integer.parseInt(line));
                System.out.println(Integer.parseInt(line));
            }
        }
        catch (Exception e) {
            System.out.println(this.file_name);
        }
        finally {
            System.out.println("Closing: " + this.file_name);
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    // ignore ... any significant errors should already have been
                    // reported via an IOException from the final flush.
                }
            }
        }
        return numbers;
    }

}
