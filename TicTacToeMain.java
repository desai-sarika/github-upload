import java.util.Scanner;

public class TicTacToeMain {
   public static void main(String[] args){
      Scanner scnr = new Scanner(System.in);
      System.out.println("Welcome to TicTacToe!");
      System.out.println("Here are the rules:");
      System.out.println("\tYou need three in a row to win (vertically, horizontally, or diagonally)");
      System.out.println("\tThe game starts with an empty 3 x 3 board");
      System.out.println("\tEach turn you can place one of your markers in an open space of your choosing");
      System.out.println("\tBy entering the corresponding letter// ");
      System.out.println("\tThe game ends when one player has three markers in a row");
      System.out.println("\tOr when no more moves are possible");
      
      boolean gameOver = false;
      TicTacToeBoard game = new TicTacToeBoard();
      char whichPlayer = 'X';
      char placementSpot;
      char winner;
      
      while (!gameOver) {
         game.printBoard();
         System.out.println("It's player " + whichPlayer + "'s turn!");
         System.out.println("Where would you like to place your marker?");
         placementSpot = scnr.next().charAt(0);
         
         while (!game.isLocationOpen(placementSpot)) {
            System.out.println("Please enter a valid location");
            placementSpot = scnr.next().charAt(0);
         }
         
         game.placeMarker(whichPlayer, placementSpot);
         
         winner = game.win();
         
         if (winner != ' ') {
            System.out.println("Player " + winner + " wins!");
            gameOver = true;
         }
         else if (game.tie()) {
            System.out.println("It's a tie!");
            gameOver = true;
         }
         
         whichPlayer = game.switchPlayerTurn(whichPlayer);
      }
      game.printBoard();
   }
}