public class GameLogic {
    private char currentPlayer;

    public GameLogic() {
        currentPlayer = 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean checkWin(char[] board) {

        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] condition : winConditions) {
            if (board[condition[0]] == currentPlayer && board[condition[1]] == currentPlayer && board[condition[2]] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    public boolean isBoardFull(char[] board) {

        for (char cell : board) {
            if (cell != 'X' && cell != 'O') {
                return false;
            }
        }
        return true;
    }
}
