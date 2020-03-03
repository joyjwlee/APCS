public class KnightsTour {
    // Static Variables
    final int rows = 8;
    final int cols = 8;
    int[][] board = new int[rows][cols];

    // dR dC array for knight
    final int dR[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
    final int dC[] = { 2, 1, -1, -2, -2, -1, 1, 2 };

    // Pre: nothing
    // Post: main method for program
    public void go() {
        System.out.print("\n=======================\nThe Knight's Tour:\n=======================\n   ");
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print("\t" + i);
        }
        System.out.println();

        // Set entire board to -1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = -1;
            }
        }

        // Start at 0,0 and set it to 0
        board[0][0] = 0;
        // Start search at 0,0 and set move to 1
        knightPath(0, 0, 1);
        // Once done, print the path
        printPath();
    }

    // Pre: current coordinates and number of moves
    // Post: update board with number of moves and boolean if board is filled
    public boolean knightPath(final int r, final int c, final int moves) {
        // Return true if visited all locations
        if (moves == rows * cols) {
            return true;
        }

        // Loop through all possible locations for knight
        for (int i = 0; i < 8; i++) {
            final int nextR = r + dR[i];
            final int nextC = c + dC[i];
            // If we can visit
            if (canVisit(nextR, nextC)) {
                // Set current position to moves
                board[nextR][nextC] = moves;
                // If it yields in a solution, return true for recursive call
                if (knightPath(nextR, nextC, moves + 1)) {
                    return true;
                }
                // Otherwise reset position back to -1
                else {
                    board[nextR][nextC] = -1;
                }
            }
        }

        // If this doesn't work, return false
        return false;
    }

    // Pre: coordinates, r and c
    // Post: boolean denoting if it's in/out of bounds and visisted/unvisited
    public boolean canVisit(final int r, final int c) {
        if (r >= 0 && r < rows && c >= 0 && c < cols && board[r][c] == -1) {
            return true;
        } else {
            return false;
        }
    }

    // Pre: Nothing
    // Post: Prints the entire board with move #'s
    public void printPath() {
        for (int i = 0; i < rows; i++) {
            System.out.print(i);
            for (int j = 0; j < cols; j++) {
                System.out.print("\t" + board[i][j]);
            }
            System.out.println();
        }
    }
}