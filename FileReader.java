import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class FileReader {

    private Scanner fileReader;

    public FileReader(String fileName) {
        init(fileName);
    }



    public void init(String fileName) {
        try {
            File file = new File(fileName);
            this.fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading file");
      }
    }

    public String readLine() {
        if (this.fileReader != null && this.fileReader.hasNextLine()) {
            return this.fileReader.nextLine();
        }
        return null;
    }

    public void close() {
      if (this.fileReader != null) {
          this.fileReader.close();
          this.fileReader = null;
      }
  }

}
