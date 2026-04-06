package interview_questions.tic_tac_toe;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.Pair;

public class Board {
  int size;
  public PlayingPiece[][] board;

  public Board(int size) {
    board = new PlayingPiece[size][size];
    this.size = size;
  }

  public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
    if (board[row][column] != null) {
      return false;
    }
    board[row][column] = playingPiece;
    return true;
  }

  public List<Pair<Integer, Integer>> getFreeCells() {
    List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (board[i][j] == null) {
          Pair<Integer, Integer> freeCell = new Pair<>(i, j);
          freeCells.add(freeCell);
        }
      }
    }
    return freeCells;
  }

  public void printBoard() {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (board[i][j] != null) {
          System.out.print(board[i][j].pieceType.name() + "   ");
        } else {
          System.out.print("    ");
        }
        System.out.print(" | ");
      }
      System.out.println();
    }
  }
}
