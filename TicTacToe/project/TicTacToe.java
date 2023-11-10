package project;
import java.util.*;
public class TicTacToe
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Board gameBoard = new Board();
        Referee ref = new Referee();
        Computer computer = new Computer();
        

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Input 1 for 1 player or 2 for 2 player");
        while (!in.hasNextInt())
        {
            System.out.println("Invalid! Input 1 for 1 player or 2 for 2 player");
            in.next();
        }
        int numOfPlayers = in.nextInt();
        
        while (true)
        {
            if (numOfPlayers == 1)
            {
                System.out.println("Enter your name, Player 1:");
                String name = in.next();
                System.out.println("Enter your gamepiece, Player 1:");
                char gamePiece = in.next().charAt(0);
                Player p1 = new Player(name, gamePiece);
                
                while (true)
                {
                    p1.playerTurn(gameBoard, ref, p1.getGamePiece());
                    gameBoard.displayBoard();
                    System.err.println();
                    if (ref.checkWinner(gameBoard, p1.getPlayerName(), p1.getGamePiece())) 
                    {
                        break;
                    }

                    computer.computerTurn(gameBoard, ref);
                    gameBoard.displayBoard();
                    System.err.println();
                    if (ref.checkWinner(gameBoard, computer.getPlayerName(), computer.getGamePiece())) 
                    {
                        break;
                    }
                }
                break;
            }

            if (numOfPlayers == 2)
            {
                System.out.println("Enter your name, Player 1:");
                String name = in.next();
                System.out.println("Enter your gamepiece, Player 1:");
                char gamePiece = in.next().charAt(0);
                Player p1 = new Player(name, gamePiece);

                System.out.println("Enter your name, Player 2:");
                name = in.next();
                System.out.println("Enter your gamepiece, Player 2:");
                gamePiece = in.next().charAt(0);
                Player p2 = new Player(name, gamePiece);
                
                while (true)
                {
                    p1.playerTurn(gameBoard, ref, p1.getGamePiece());
                    gameBoard.displayBoard();
                    System.err.println();
                    if (ref.checkWinner(gameBoard, p1.getPlayerName(), p1.getGamePiece())) 
                    {
                        break;
                    }

                    p2.playerTurn(gameBoard, ref, p2.getGamePiece());
                    gameBoard.displayBoard();
                    System.err.println();
                    if (ref.checkWinner(gameBoard, p2.getPlayerName(), p2.getGamePiece())) 
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
        in.close();
    }
}