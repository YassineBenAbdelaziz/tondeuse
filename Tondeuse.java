public class Tondeuse {
    
    private int X_MAX;
    private int Y_MAX;
    private int currentX;
    private int currentY;
    private char currentOrientation;
    private String instructions;


    public Tondeuse(String position, String instructions, int X_MAX, int Y_MAX)  {

        String[] splittedString = position.split(" ");
        
        this.instructions = instructions;
        this.X_MAX = X_MAX;
        this.Y_MAX = Y_MAX;
        this.currentX = Integer.parseInt(splittedString[0]);
        this.currentY = Integer.parseInt(splittedString[1]);
        this.currentOrientation = splittedString[2].charAt(0);
    }



    public String execute() {

        for (int i = 0; i < instructions.length(); i++) {
            char instruction = instructions.charAt(i);
            this.executeInstruction(instruction);
        }

        return this.currentX + " " + this.currentY + " " + this.currentOrientation;

    }

    private void executeInstruction(char instruction ) {
        switch (instruction) {
            case 'D':
                this.turnRight();
                break;
            case 'G':
                this.turnLeft();
                break;
            case 'A':
                this.moveForward();
                break;
            default:
                throw new RuntimeException("Unknown instruction");
                
        }
    }


    private void turnLeft() {
        switch (this.currentOrientation) {
            case 'N':
                this.currentOrientation = 'W';
                break;
            case 'E':
                this.currentOrientation = 'N';
                break;
            case 'S':
                this.currentOrientation = 'E';
                break;
            case 'W':
                this.currentOrientation = 'S';
                break;
            default:
                throw new RuntimeException("Unknown orientation");
                
        }
    }


    private void turnRight() {
        switch (this.currentOrientation) {
            case 'N':
                this.currentOrientation = 'E';
                break;
            case 'E':
                this.currentOrientation = 'S';
                break;
            case 'S':
                this.currentOrientation = 'W';
                break;
            case 'W':
                this.currentOrientation = 'N';
                break;
            default:
                throw new RuntimeException("Unknown orientation");
                
        }
    }


    private void moveForward() {
        switch (this.currentOrientation) {
            case 'N':
                if (this.currentY <= this.Y_MAX) {
                    this.currentY++;
                }
                break;
            case 'E':
                if (this.currentX <= this.X_MAX) {
                    this.currentX++;
                }
                break;
            case 'S':
                if (this.currentY > 0) {
                    this.currentY--;
                }
                break;
            case 'W':
                if (this.currentX > 0) {
                    this.currentX--;
                }
                break;
            default:
                throw new RuntimeException("Unknown orientation");
        }
    }


}
