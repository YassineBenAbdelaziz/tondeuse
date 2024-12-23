

public class Tondeuse {
    public static void main(String[] args) {
       if ( args.length != 1 ) {
           System.out.println("Usage: java Tondeuse <filename>");
           return;
       }

        String fileName = args[0];
        FileReader fileReader = new FileReader(fileName);
        

        while( true ) {
            String line = fileReader.readLine();
            if (line == null)
                break;

            System.out.println(line);
        }

        fileReader.close();

    }
}