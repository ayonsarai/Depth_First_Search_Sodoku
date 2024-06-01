# Depth_First_Search_Sodoku

# Algorithm: 
DFS(Graph, start_node):

create a stack S

mark start_node as visited

push start_node onto S


while S is not empty:

current_node = pop S

process current_node


for each neighbor of current_node:

if neighbor is not visited:

mark neighbor as visited

push neighbor onto S

# Algorithm Steps:

Find the first empty cell.

Try filling the cell with digits from 1 to 9.

For each digit, check if it is valid (i.e., it does not violate the Sudoku rules).

Recursively attempt to fill in the next empty cell with the same approach.

If a solution is found, return true.

If no valid digit leads to a solution, reset the cell and backtrack.


Explanation:

# Initialization:

The main method initializes a Sudoku board with some cells filled and calls the solveSudoku method.

# DFS Process:

findEmptyCell locates the first empty cell.

isValid checks if placing a number in the cell respects the Sudoku constraints (row, column, and 3x3 subgrid).

If a valid number is found, it is placed in the cell, and the method recursively attempts to solve the rest of the board.

If placing a number doesn't lead to a solution, the cell is reset to 0, triggering backtracking.

# Helper Functions:

findEmptyCell searches for an empty cell in the board.

isValid verifies the validity of placing a number in a given cell.

printBoard prints the board in a readable format.


# This implementation efficiently solves the Sudoku puzzle using DFS and backtracking.
