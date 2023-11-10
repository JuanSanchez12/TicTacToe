package project;

import java.util.*;

public class Player
{
    Scanner in = new Scanner(System.in);
    private String playerName;
    private char gamePiece;

    public Player()
    {
        playerName = "";
        gamePiece = 'x';
    }

    public Player(String playerName, char gamePiece)
    {
        this.playerName = playerName;
        this.gamePiece = gamePiece;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public char getGamePiece()
    {
        return gamePiece;
    }

    public void playerTurn(Board gameBoard, Referee ref, char gamePiece) 
    {
        int row = 0;
        int column = 0;
        this.gamePiece = gamePiece;

        while (true)
        {
            System.out.println("Make your Move, " + playerName);
            int move = in.nextInt();

            if (move == 1) {row = 0; column = 0;}

            else if (move == 2) {row = 0; column = 1;}

            else if (move == 3) {row = 0; column = 2;}

            else if (move == 4) {row = 1; column = 0;}

            else if (move == 5) {row = 1; column = 1;}

            else if (move == 6) {row = 1; column = 2;}

            else if (move == 7) {row = 2; column = 0;}

            else if (move == 8) {row = 2; column = 1;}

            else if (move == 9) {row = 2; column = 2;}

            if (ref.validMove(gameBoard.getBoard(), row, column))
            {
                break;
            }
            
            else
            {
                System.out.println("Invalid! Try different move.");
                gameBoard.displayBoard();
            }
        }

        gameBoard.placePiece(row, column, gamePiece);
    }

}