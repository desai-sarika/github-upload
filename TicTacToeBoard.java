public class TicTacToeBoard {
   private final int BOARD_SIZE = 3;
   private char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
   
   public TicTacToeBoard() {
      char spaceVal = 'a';
      for (int i = 0; i < BOARD_SIZE; i++) {
         for (int j = 0; j < BOARD_SIZE; j++) {
            board[i][j] = spaceVal;
            spaceVal++;
         }
      }
   }
   
   public void printBoard() {
      System.out.println();
      for (int i = 0; i < BOARD_SIZE; i++) {
         System.out.print("   ");
         for (int j = 0; j < BOARD_SIZE; j++) {
            System.out.print(board[i][j] + "   ");
         }
         System.out.println();
         System.out.println();
      }
   }
   

   public char switchPlayerTurn(char whichPlayer) {
      switch (whichPlayer) {
         case 'X':
            whichPlayer = 'O';
            break;
         case 'O':
            whichPlayer = 'X';
            break;
      }
      return whichPlayer;
   }
   
   public boolean isLocationOpen(char chosenLocation) {
      for (int i = 0; i < BOARD_SIZE; i++) {
         for (int j = 0; j < BOARD_SIZE; j++) {
            if (board[i][j] == chosenLocation) {
               return true;
            }
         }
      }
      return false;
   }
   
   public void placeMarker(char playerMarker, char markerLocation) {
      for (int i = 0; i < BOARD_SIZE; i++) {
         for (int j = 0; j < BOARD_SIZE; j++) {
            if (board[i][j] == markerLocation) {
               board[i][j] = playerMarker;
               return;
            }
         }
      }
   }
   
   public boolean areTheseThreeEqual(char thingOne, char thingTwo, char thingThree) {
      boolean equal = false;
      if (thingOne == thingTwo && thingTwo == thingThree) {
         equal = true;
      }
      return equal;
   }
   
   public boolean tie() {
      for (char aThroughI = 'a'; aThroughI <= 'i'; aThroughI++) {
         for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
               if (board[i][j] == aThroughI) {
                  return false;
               }
            }
         }
      }
      return true;
   }
   
   //check every possible winning combination. if true return winner char, if false return space
   public char win() { 
      if (areTheseThreeEqual(board[0][0], board[1][1], board[2][2])) {
         return board[0][0];
      }
      else if (areTheseThreeEqual(board[0][2], board[1][1], board[2][0])) {
         return board[0][2];
      }
      else if (areTheseThreeEqual(board[0][1], board[1][1], board[2][1])) {
         return board[0][1];
      }
      else if (areTheseThreeEqual(board[1][0], board[1][1], board[1][2])) {
         return board[1][0];
      }
      else if (areTheseThreeEqual(board[0][0], board[0][1], board[0][2])) {
         return board[0][0];
      }
      else if (areTheseThreeEqual(board[0][0], board[1][0], board[2][0])) {
         return board[0][0];
      }
      else if (areTheseThreeEqual(board[0][2], board[1][2], board[2][2])) {
         return board[0][2];
      }
      else if (areTheseThreeEqual(board[2][0], board[2][1], board[2][2])) {
         return board[2][0];
      }
      else {
         return ' ';
      }
   }
}