import java.io.*;
import java.util.*;

public class Main {
  static int[][] sudoku = new int[9][9];
  
  public static boolean solveSudoku(int row, int col) {
    if(col == 9) {
      return solveSudoku(row + 1, 0);
    }
    
    if(row == 9) {
      printSudoku();
      System.exit(0);
    }
    
    if (sudoku[row][col] == 0) {
      for (int num = 1; num <= 9; num++) {
        if (isValid(row, col, num)) {
          sudoku[row][col] = num;
          if(solveSudoku(row, col + 1)) {
            return true;
          }
          sudoku[row][col] = 0;
        }
      }
      return false;
    }
    
    return solveSudoku(row, col+1);
  }
  
  public static boolean isValid(int row, int col, int num) {
    for(int i=0; i<9; i++) {
      if (sudoku[row][i] == num || sudoku[i][col] == num) {
        return false;
      }
    }
    
    int startRow = (row / 3) * 3;
    int startCol = (col / 3) * 3;
    
    for(int i=0; i<3; i++) {
      for(int j=0; j<3; j++) {
        if (sudoku[startRow + i][startCol + j] == num) {
          return false;
        }
      }
    }
    
    return true;
  }
  
  public static void printSudoku() {
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<9; i++) {
      for(int j=0; j<9; j++) {
        sb.append(sudoku[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    for(int i=0; i<9; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0; j<9; j++) {
        sudoku[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    solveSudoku(0, 0);
    
  }
}