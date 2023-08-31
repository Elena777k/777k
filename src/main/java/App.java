import java.util.Scanner;

public class App {

    byte input;
    byte rand;
    private final char[] box;
    private byte currentPlayer;
    private final Scanner scanner;

    public App() {
        box = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        input = 'X';
        rand = 'O';
        currentPlayer = input;
        scanner = new Scanner(System.in);
    }

    public void play() {

        while (true) {

            boxAvailable();
            int move = getPlayerMove();
            box[move] = (char) currentPlayer;

            if (whenWinner()) {
                boxAvailable();
                System.out.println("You won the game! Thanks for playing!");
                break;


            } else if (isBoardFull()) {
                boxAvailable();
                System.out.println("It's a draw! Thanks for playing!");

                break;
            }
            switchPlayer();

            move = (byte) (Math.random() * (9 - 1 + 1) + 1);
            while (box[move - 1] == 'X' || box[move - 1] == 'O') {
                move = (byte) (Math.random() * (9 - 1 + 1) + 1);
            }
            box[move - 1] = 'O';

            if (whenWinner()) {
                boxAvailable();
                System.out.println("You lost the game! Thanks for playing!");
                break;
            }
        }
        scanner.close();
    }

    private void boxAvailable() {
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

    private int getPlayerMove() {
        while (true) {

            if (scanner.hasNextInt()) {
                int move = scanner.nextInt() - 1;
                if (move >= 0 && move < 9 && box[move] != 'X' && box[move] != 'O') {
                    currentPlayer = 'X';

                    return move;
                } else {
                    System.out.println("That one is already in use. Enter another.");
                }
            } else {
                System.out.println("Invalid input. Enter a valid number.");
                scanner.next();
            }
        }
    }

    private boolean whenWinner() {
        int[][] winCombin = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] combin : winCombin) {
            if (box[combin[0]] == currentPlayer && box[combin[1]] == currentPlayer && box[combin[2]] == currentPlayer) {
                return true;
            }
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                return false;
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == input ? rand : input);
    }

    public static void main(String[] args) {
        App game = new App();
        game.play();
    }
}