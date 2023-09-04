public class ComputerPlayer implements Player {
    public int makeMove(char[] board) {

        int move;
        do {
            move = (int) (Math.random() * (9 - 1 + 1) + 1);
        } while (board[move] == 'X' || board[move] == 'O');
        return move;
    }
}

