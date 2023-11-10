package project;

import java.util.*;

public class Board 
{
    Scanner in = new Scanner(System.in);
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
}