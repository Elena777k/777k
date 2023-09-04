public class App {


    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        GameLogic gameLogic = new GameLogic();
        Player humanPlayer = new HumanPlayer();
        Player computerPlayer = new ComputerPlayer();

        while (true) {
            gameBoard.display();
            int move = humanPlayer.makeMove(gameBoard.getBox());
            gameBoard.update(move, gameLogic.getCurrentPlayer());

            if (gameLogic.checkWin(gameBoard.getBox())) {
                gameBoard.display();
                System.out.println("You won the game! Thanks for playing!");
                break;
            } else if (gameLogic.isBoardFull(gameBoard.getBox())) {
                gameBoard.display();
                System.out.println("It's a draw! Thanks for playing!");
                break;
            }
            gameLogic.switchPlayer();

            move = computerPlayer.makeMove(gameBoard.getBox());
            gameBoard.update(move, gameLogic.getCurrentPlayer());

            if (gameLogic.checkWin(gameBoard.getBox())) {
                gameBoard.display();
                System.out.println("You lost the game! Thanks for playing!");
                break;
            }
            gameLogic.switchPlayer();
        }
    }
}






