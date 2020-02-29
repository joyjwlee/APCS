import java.util.*;
import java.io.*;

public class Clump {
    // Static Variable
    boolean[][] board = new boolean[25][25];
    int[] dr = { -1, 0, 1, 0 };
    int[] dc = { 0, 1, 0, -1 };

    // Pre: nothing
    // Post: main method for program
    public void go() {
        try {
            final Scanner input = new Scanner(new File("digital.txt"));
            final int num = input.nextInt();
            int row, col;
            for (int i = 0; i < num; i++) {
                row = input.nextInt();
                col = input.nextInt();
                board[row][col] = true;
            }
            printClump();
            Scanner sc = new Scanner(System.in);
            int r, c;
            while (!noClumps()) {
                System.out.println("\nPlease enter a row and column to erase a clump: ");
                r = sc.nextInt();
                c = sc.nextInt();
                dfs(r, c);
                printClump();
            }
        } catch (final FileNotFoundException ex) {
        }
    }

    // Pre: nothing
    // Post: prints clump array
    public void printClump() {
        System.out.print("\n=======================\nThe Status of Clumps:\n=======================\n   ");
        for (int i = 1; i <= 20; i++) {
            System.out.print(i % 10);
        }
        System.out.println();
        for (int i = 1; i <= 20; i++) {
            if (i < 10) {
                System.out.print(" ");
            }
            System.out.print(i + " ");
            for (int j = 1; j <= 20; j++) {
                if (board[i][j]) {
                    System.out.print("@");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    // Pre: nothing
    // Post: returns boolean if there are no clumps
    public boolean noClumps() {
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Pre: coordinates, r and c
    // Post: removes clump with r and c
    // Simple DFS floodfill
    public void dfs(int r, int c) {
        if (board[r][c]) {
            board[r][c] = false;
            for (int i = 0; i < 4; i++) {
                int nextR = r + dr[i];
                int nextC = c + dc[i];
                if (board[nextR][nextC]) {
                    dfs(nextR, nextC);
                }
            }
        }
    }
}