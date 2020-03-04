public class EightQueens {
    // N by N grid with N queens to be placed
    final int N = 8;
    boolean board[][] = new boolean[N][N];

    // Pre: nothing
    // Post: prints board with N queens solution or solution DNE
    public void go() {
        if (solve(0) == false) {
            System.out.print("Solution does not exist");
        } else {
            printBoard();
        }
    }

    // Pre: nothing
    // Post: prints board with N queens solution
    void printBoard() {
        System.out.print("\n==================\n   The " + N + " Queens:\n==================\n   ");
        for (int i = 0; i < N; i++) {
            System.out.print(i % 10);
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            if (i < 10) {
                System.out.print(" ");
            }
            System.out.print(i + " ");
            for (int j = 0; j < N; j++) {
                if (board[i][j]) {
                    System.out.print("Q");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    // Pre: current column we are in
    // Post: boolean for backtracking to see if placing a queen works
    boolean solve(final int col) {
        // If all queens are placed return true
        if (col == N) {
            return true;
        }

        // Just look at this column, loop through rows
        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                // Place queen and see if it results in a solution
                board[i][col] = true;
                if (solve(col + 1) == true) {
                    return true;
                }
                // If it doesn't result in solution, backtrack and try next queen
                board[i][col] = false;
            }
        }

        // If queen can't be placed anywhere in this column, return false; no solution
        return false;
    }

    // Pre: row, col
    // Post: boolean determining if queen is safe or not
    boolean isSafe(final int row, final int col) {
        // Only need to check left side, since queens are placed left to right
        // Same row to the left
        for (int i = 0; i < col; i++) {
            if (board[row][i]) {
                return false;
            }
        }
        // Up and left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        // Down and left diagonal
        for (int i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        // If none can attack, good to go
        return true;
    }
}