import java.util.*;
import java.io.*;
//For the purpose of this lab, I will just use 20 as the ranges in the for loops

public class LifeDude {
    // Static Variable
    boolean[][] life = new boolean[25][25];
    boolean[][] nextLife = new boolean[25][25];

    // Pre: nothing
    // Post: main method for program
    public void go() {
        try {
            final Scanner input = new Scanner(new File("life100.txt"));
            final int num = input.nextInt();
            int row, col;
            for (int i = 0; i < num; i++) {
                row = input.nextInt();
                col = input.nextInt();
                life[row][col] = true;
            }
            // Go to next generation 5 times
            for (int i = 0; i < 5; i++) {
                nextGen();
            }
            printLife();
            printLifeStatus();
        } catch (final FileNotFoundException ex) {
        }
    }

    // Pre: nothing
    // Post: prints life array
    public void printLife() {
        System.out.print("\nThe Status of Life:\n\t");
        for (int i = 1; i <= 20; i++) {
            System.out.print(i % 10);
        }
        System.out.println();
        for (int i = 1; i <= 20; i++) {
            System.out.print(i % 10 + "\t");
            for (int j = 1; j <= 20; j++) {
                if (life[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Pre: nothing
    // Post: prints status of life
    public void printLifeStatus() {
        int row = 0, col = 0, tot = 0;
        for (int i = 1; i <= 20; i++) {
            if (life[10][i]) {
                row++;
            }
            if (life[i][10]) {
                col++;
            }
        }
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (life[i][j]) {
                    tot++;
                }
            }
        }
        System.out.println("Number in Row 10 ---> " + row);
        System.out.println("Number in Column 10 ---> " + col);
        System.out.println("Number of living organisms ---> " + tot);
    }

    // Pre: nothing
    // Post: updates life array to next generation
    public void nextGen() {
        // Get info from current, update it to next
        // Loop through each position
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                // Count number of neighbors
                int neighbors = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        // If something exists and it's not itself
                        if (life[k][l] && !(i == k && j == l)) {
                            neighbors++;
                        }
                    }
                }
                // With number of neighbors update next
                if (neighbors == 3) {
                    nextLife[i][j] = true;
                } else if (neighbors == 0 || neighbors == 1 || neighbors >= 4) {
                    nextLife[i][j] = false;
                } else {
                    nextLife[i][j] = life[i][j];
                }
            }
        }
        // With updated values from next paste it into life array
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                life[i][j] = nextLife[i][j];
            }
        }
    }
}