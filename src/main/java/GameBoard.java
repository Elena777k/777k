public class GameBoard {
    private final char[] box;

    public GameBoard() {
        box = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public void display() {
        System.out.println("Enter box number to select. Enjoy!");
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");

        for (char i = 0; i < box.length; i++) {
            if (box[i] == 'O' || box[i] == 'X') break;
            else box[i] = ' ';
        }
    }

    public void update(int move, char currentPlayer) {
        box[move] = currentPlayer;
    }

    public char[] getBox() {
        return box;
    }
}

