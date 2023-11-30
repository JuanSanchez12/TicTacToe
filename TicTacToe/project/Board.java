package project;

import java.util.*;

public class Board 
{
    Scanner in = new Scanner(System.in);
    private boolean isValid = true;
    private char[][] board;

    public Board()
    {
        board = new char[3][3];
        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                board[row][col] = '_';
            }
        }
    }

    public char placePiece(int row, int column, char gamePiece)
    {
        board [row][column] = gamePiece;
        return board [row][column];
    }

    public char[][] getBoard()
    {
        return board;
    }

    public void displayBoard()
    {
        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                System.out.print(board[row][col]);
                if (col < 2)
                {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    public boolean validMove(int row, int column)
    {
        if (getBoard()[row][column] == '_') 
        {
            return isValid;
        }

        return !isValid;
    }

    public boolean checkWinner(String playerName, char gamePiece) {
		
		if (checkGameBoard(gamePiece))
        {	
			System.out.println(playerName + " wins!");
            displayBoard();
            System.err.println();
			return isValid;
		}
		
		for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                if (getBoard()[row][col] == '_')
                {
                    return !isValid;
                }
            }
        }

		System.out.println("The game ended as a draw!");
        displayBoard();
		return isValid;
	}

    public boolean checkGameBoard(char gamePiece)
    {
		if ((getBoard()[0][0] == gamePiece && getBoard()[0][1] == gamePiece && getBoard()[0][2] == gamePiece) ||
			(getBoard()[1][0] == gamePiece && getBoard()[1][1] == gamePiece && getBoard()[1][2] == gamePiece) ||
			(getBoard()[2][0] == gamePiece && getBoard()[2][1] == gamePiece && getBoard()[2][2] == gamePiece) ||
			
			(getBoard()[0][0] == gamePiece && getBoard()[1][0] == gamePiece && getBoard()[2][0] == gamePiece) ||
			(getBoard()[0][1] == gamePiece && getBoard()[1][1] == gamePiece && getBoard()[2][1] == gamePiece) ||
			(getBoard()[0][2] == gamePiece && getBoard()[1][2] == gamePiece && getBoard()[2][2] == gamePiece) ||
			
			(getBoard()[0][0] == gamePiece && getBoard()[1][1] == gamePiece && getBoard()[2][2] == gamePiece) ||
			(getBoard()[0][2] == gamePiece && getBoard()[1][1] == gamePiece && getBoard()[2][0] == gamePiece) )
        {
			return isValid;
		}

		return !isValid;
	}
}