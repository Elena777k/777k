import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner scanner;

    public HumanPlayer() {
        scanner = new Scanner(System.in);
    }


    public int makeMove(char[] board) {

        while (true) {
            if (scanner.hasNextInt()) {
                int move = scanner.nextInt() - 1;
                if (move >= 0 && move < 9 && board[move] != 'X' && board[move] != 'O') {
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
}

