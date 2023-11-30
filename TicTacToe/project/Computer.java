package project;

public class Computer extends Player
{
  private char computerPiece;

    public Computer() 
    {
        super("Computer", 'o');
        computerPiece = 'o';
    }

    public void computerTurn(Board gameBoard)
    {
      int row = 0;
      int column = 0;
  
      while (true)
      {
          int move = (int) (Math.random()*10);
  
          if (move == 1) {row = 0; column = 0;}
          else if (move == 2) {row = 0; column = 1;}
          else if (move == 3) {row = 0; column = 2;}
          else if (move == 4) {row = 1; column = 0;}
          else if (move == 5) {row = 1; column = 1;}
          else if (move == 6) {row = 1; column = 2;}
          else if (move == 7) {row = 2; column = 0;}
          else if (move == 8) {row = 2; column = 1;}
          else if (move == 9) {row = 2; column = 2;}
  
          if (gameBoard.validMove(row, column))
          {
            System.out.println("Computer entered " + move);
            break;
          }
      }
  
      gameBoard.placePiece(row, column, computerPiece);
  }

}
