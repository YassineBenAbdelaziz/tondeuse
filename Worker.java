public class Worker {
    
    private FileReader fileReader;


    public Worker(FileReader fileReader) {
        this.fileReader = fileReader;

    }

    public void solve() {
        try {

            String line = this.fileReader.readLine();
            if (line == null) {
                System.out.println("No data to process");
                return;
            }

            String[] size = line.split(" ");
            int X_MAX = Integer.parseInt(size[0]);
            int Y_MAX = Integer.parseInt(size[1]);

            while( true ) {
                String position = this.fileReader.readLine();
                if (position == null) {
                    break;
                }

                String instructions = this.fileReader.readLine();
                if (instructions == null) {
                    System.out.println("Error : Missing instructions");
                    return;
                }

                Tondeuse tondeuse = new Tondeuse(position, instructions, X_MAX, Y_MAX);
                System.out.println(tondeuse.execute());
            }
            
            
            fileReader.close();

        } catch (NumberFormatException e) {
            System.out.println("Error : Expected a number");
        } catch ( ArrayIndexOutOfBoundsException e) {
            System.out.println("Error : Missing data");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }



}
