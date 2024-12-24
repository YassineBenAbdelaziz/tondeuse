

public class Main {
    public static void main(String[] args) {

        if ( args.length != 1 ) {
            System.out.println("Usage: java Tondeuse <filename>");
            return;
        }

        String fileName = args[0];
        FileReader fileReader = new FileReader(fileName);
        
        Worker worker = new Worker(fileReader);

        worker.solve();


    }
}