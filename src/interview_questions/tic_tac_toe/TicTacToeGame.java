package interview_questions.tic_tac_toe;

import org.antlr.v4.runtime.misc.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
  Deque<Player> players;
  Board gameboard;
  Player winner;

  void initializeGame() {
    players = new LinkedList<>();
    // Add player 1
    PlayingPiece pieceX = new PlayingPieceX(PieceType.X);
    Player player1 = new Player("Player 1", pieceX);

    // Add player 2
    PlayingPiece pieceO = new PlayingPieceX(PieceType.O);
    Player player2 = new Player("Player 2", pieceO);

    players.add(player1);
    players.add(player2);

    gameboard = new Board(3);
  }

  GameStatus startGame() {
    boolean noWinner = true;
    while (noWinner) {
      // Remove current player and keep him at last
      Player currentPlayer = players.removeFirst();

      // print the free space from the board
      gameboard.printBoard();
      List<Pair<Integer, Integer>> freeSpaces = gameboard.getFreeCells();
      if (freeSpaces.isEmpty()) {
        noWinner = false;
        continue;
      }

      // Take input dimension from the user
      System.out.print("Player: " + currentPlayer.name + " - Please enter [row, column]: ");
      Scanner inputScanner = new Scanner(System.in);
      String s = inputScanner.nextLine();
      String[] values = s.split(",");
      int row = Integer.valueOf(values[0]);
      int col = Integer.valueOf(values[1]);

      boolean isPiecePlaced = gameboard.addPiece(row, col, currentPlayer.playingPiece);
      // Check if the row, col dimension is full or not
      if (!isPiecePlaced) {
        System.out.println("Incorrect position chosen, try again!");
        players.addFirst(currentPlayer);
        continue;
      }
      players.addLast(currentPlayer);
      // Check if row, col, diagonal, anti-diagonal rows are having the same piece
      boolean isWinner = checkGameStatus(row, col, currentPlayer.playingPiece, gameboard.size);
      if (isWinner) {
        gameboard.printBoard();
        winner = currentPlayer;
        return GameStatus.WIN;
      }
    }
    return GameStatus.DRAW;
  }

  private boolean checkGameStatus(int row, int col, PlayingPiece playingPiece, int size) {
    boolean rowMatch = true;
    boolean columnMatch = true;
    boolean diagonalMatch = true;
    boolean antiDiagonalMatch = true;
    // Check row is having all the playing pieces
    for (int i = 0; i < size; i++) {
      if (gameboard.board[row][i] == null
          || gameboard.board[row][i].pieceType != playingPiece.pieceType) {
        rowMatch = false;
        break;
      }
    }

    // Check column is having all the playing pieces
    for (int i = 0; i < size; i++) {
      if (gameboard.board[i][col] == null
          || gameboard.board[i][col].pieceType != playingPiece.pieceType) {
        columnMatch = false;
        break;
      }
    }

    // Check diagonal is having all the playing pieces
    for (int i = 0; i < size; i++) {
      if (gameboard.board[i][i] == null
          || gameboard.board[i][i].pieceType != playingPiece.pieceType) {
        diagonalMatch = false;
        break;
      }
    }

    // Check anti-diagonal is having all the playing pieces
    for (int i = 0, j = size - 1; i < size; i++, j--) {
      if (gameboard.board[i][j] == null
          || gameboard.board[i][j].pieceType != playingPiece.pieceType) {
        antiDiagonalMatch = false;
        break;
      }
    }
    return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
  }
}
