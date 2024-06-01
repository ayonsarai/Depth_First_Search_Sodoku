/* Sarai Ayon
 * 6/1/2024
 * CS 240 Data base structures and algorithms 
 * Algorithms HW 8 pick an example of where Depth First Search would be an ideal application and write a suitable algorithm for it.
 * In this example, I used DFS to fill in the cells of a Sudoku puzzle. The puzzle is a 9x9 grid where each cell may contain a digit from 1 to 9, 
 * and some cells are initially empty (denoted by 0). The goal is to fill in the empty cells such that each row, column, and 3x3 subgrid contains
 * all the digits from 1 to 9 exactly once. */

//Depth First Search (DFS) is an algorithm for traversing or searching tree or graph data structures.
// It starts at the tree root, and explores as far as possible along each branch before backtracking.
//DFS is an ideal application for solving puzzles such as Sudoku, where we need to explore all possible solutions.
//The algorithm is implemented using recursion.

//The solveSudoku() method is the main driver method that solves the Sudoku puzzle.
public class DFSSodoku {
//The main() method initializes the Sudoku board and calls the solveSudoku() method to solve the puzzle.
    public static void main(String[] args) {
        int[][] board = { // 0 represents empty cells
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        }; // Solution exists

//The solveSudoku() method is the main driver method that solves the Sudoku puzzle.
        if (solveSudoku(board)) { // Solve the puzzle
            printBoard(board); // Print the solution
        } else { 
            System.out.println("No solution exists.");
        }// Print message if no solution exists
    } // end of main method

    public static boolean solveSudoku(int[][] board) { // Solve the Sudoku puzzle
        int[] emptyCell = findEmptyCell(board); // Find an empty cell
        if (emptyCell == null) { // No empty cells found
            return true; // Puzzle solved
        } // end of if statement
        int row = emptyCell[0]; // Get row of empty cell
        int col = emptyCell[1]; // Get column of empty cell

// Try filling the empty cell with digits from 1 to 9
        for (int num = 1; num <= 9; num++) { // Try each digit
            if (isValid(board, row, col, num)) { // Check if digit is valid
                board[row][col] = num; // Place the digit
                if (solveSudoku(board)) { // Recursively solve the puzzle
                    return true; // Puzzle solved
                } // end of if statement
                board[row][col] = 0; // Reset cell and backtrack
            } // end of if statement
        } // end of for loop

        return false; // Trigger backtracking
    } // end of solveSudoku method

    // Find the next empty cell in the Sudoku board
    private static int[] findEmptyCell(int[][] board) { // Find an empty cell
        for (int row = 0; row < 9; row++) { // Iterate over each cell
            for (int col = 0; col < 9; col++) { // Iterate over each cell
                if (board[row][col] == 0) { // Empty cell found
                    return new int[]{row, col}; // Return row and column
                } // end of if statement
            } // end of for loop
        } // end of for loop
        return null; // No empty cells found
    } // end of findEmptyCell method

    // Check if a digit can be placed in a cell
    private static boolean isValid(int[][] board, int row, int col, int num) { // Check if digit is valid
        for (int i = 0; i < 9; i++) { // Check row and column
            if (board[row][i] == num || board[i][col] == num || // Check row and column
                board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) { // Check 3x3 subgrid
                return false; // Digit is not valid
            } // end of if statement
        } // end of for loop
        return true; // Digit is valid
    } // end of isValid method

    // Print the Sudoku board
    private static void printBoard(int[][] board) { // Print the Sudoku board
        for (int row = 0; row < 9; row++) { // Iterate over each row
            for (int col = 0; col < 9; col++) { // Iterate over each column
                System.out.print(board[row][col] + " "); // Print cell value
            } // end of for loop
            System.out.println(); // Move to next row
        } // end of for loop
    } // end of printBoard method
} // end of class

    
