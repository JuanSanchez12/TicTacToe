package project;
import java.util.*;
public class TicTacToe
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");
        TicTacToeGame();

        while (true)
        {
            System.out.println("Do you want to play again?");
            String playAgainAnswer = in.next();

            if (playAgainAnswer.equals("yes") || playAgainAnswer.equals("Yes"))
            {
               TicTacToeGame();
            }
            else if(playAgainAnswer.equals("no") || playAgainAnswer.equals("No"))
            {
                System.out.println("Thank you for Playing!");
                break;
            }
            else
            {
                System.out.println("Invalid Answer! Do you want to play again?");
                playAgainAnswer = in.next();
            }
        }
        in.close();
    }

    public static void TicTacToeGame()
    {
        Scanner in = new Scanner(System.in);
        Board gameBoard = new Board();
        Computer computer = new Computer();

        System.out.println("Input 1 for 1 player or 2 for 2 player");
        int numOfPlayers = in.nextInt();
        
        while (true)
        {
            if (numOfPlayers == 1)
            {
                Player p1 = Player.playerInfo(in, "Player 1:");
                
                while (true)
                {
                    p1.playerTurn(gameBoard, p1.getGamePiece());
                    gameBoard.displayBoard();
                    System.out.println();
                    if (gameBoard.checkWinner(p1.getPlayerName(), p1.getGamePiece())) 
                    {
                        break;
                    }

                    computer.computerTurn(gameBoard);
                    gameBoard.displayBoard();
                    System.out.println();
                    if (gameBoard.checkWinner(computer.getPlayerName(), computer.getGamePiece())) 
                    {
                        break;
                    }
                }
                break;
            }

            if (numOfPlayers == 2)
            {
                Player p1 = Player.playerInfo(in, "Player 1:");
                Player p2 = Player.playerInfo(in, "Player 2:");
                
                while (true)
                {
                    p1.playerTurn(gameBoard, p1.getGamePiece());
                    gameBoard.displayBoard();
                    System.out.println();
                    if (gameBoard.checkWinner(p1.getPlayerName(), p1.getGamePiece())) 
                    {
                        break;
                    }

                    p2.playerTurn(gameBoard, p2.getGamePiece());
                    gameBoard.displayBoard();
                    System.out.println();
                    if (gameBoard.checkWinner(p2.getPlayerName(), p2.getGamePiece())) 
                    {
                        break;
                    }
                }
                break;
            }

            if (numOfPlayers != 1 || numOfPlayers != 2) 
            {
                System.out.println("Invalid! Input 1 for 1 player or 2 for 2 player");
                numOfPlayers = in.nextInt();
            }
        }
    }
}