package project;

public class Referee
{
    private boolean isValid;
    
    public Referee()
    {
        isValid = true;
    }

    public boolean validMove(char[][] gameBoard, int row, int column)
    {
        if (gameBoard[row][column] == '_') 
        {
            return isValid;
        }

        return !isValid;
    }

    public boolean checkWinner(Board gameBoard, String playerName, char gamePiece) {
		
		if (checkGameBoard(gameBoard, gamePiece))
        {	
			System.out.println(playerName + " wins!");
            gameBoard.displayBoard();
            System.err.println();
			return isValid;
		}
		
		for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                if (gameBoard.getBoard()[row][col] == '_')
                {
                    return !isValid;
                }
            }
        }

		System.out.println("The game ended as a draw!");
        gameBoard.displayBoard();
		return isValid;
	}

    public boolean checkGameBoard(Board gameBoard, char gamePiece)
    {
		if ((gameBoard.getBoard()[0][0] == gamePiece && gameBoard.getBoard()[0][1] == gamePiece && gameBoard.getBoard()[0][2] == gamePiece) ||
			(gameBoard.getBoard()[1][0] == gamePiece && gameBoard.getBoard()[1][1] == gamePiece && gameBoard.getBoard()[1][2] == gamePiece) ||
			(gameBoard.getBoard()[2][0] == gamePiece && gameBoard.getBoard()[2][1] == gamePiece && gameBoard.getBoard()[2][2] == gamePiece) ||
			
			(gameBoard.getBoard()[0][0] == gamePiece && gameBoard.getBoard()[1][0] == gamePiece && gameBoard.getBoard()[2][0] == gamePiece) ||
			(gameBoard.getBoard()[0][1] == gamePiece && gameBoard.getBoard()[1][1] == gamePiece && gameBoard.getBoard()[2][1] == gamePiece) ||
			(gameBoard.getBoard()[0][2] == gamePiece && gameBoard.getBoard()[1][2] == gamePiece && gameBoard.getBoard()[2][2] == gamePiece) ||
			
			(gameBoard.getBoard()[0][0] == gamePiece && gameBoard.getBoard()[1][1] == gamePiece && gameBoard.getBoard()[2][2] == gamePiece) ||
			(gameBoard.getBoard()[0][2] == gamePiece && gameBoard.getBoard()[1][1] == gamePiece && gameBoard.getBoard()[2][0] == gamePiece) )
        {
			return isValid;
		}

		return !isValid;
	}
}