import java.util.*;

public class AsteriskRegions {
    // Objective: Find number of asterisk regions
    // static final int MAX = 1001; //1000 is upper bound of N and M
    static int N, M;

    public static void main(final String args[]) {
        for (int b = 1; b <= 6; b++) {// Read in N and M
            System.out.println("\n\n===Test " + b + "===");
            final Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            M = sc.nextInt();

            // Now read in character array
            final char[][] arr = new char[N][M];
            for (int i = 0; i < N; i++) {
                String temp;
                temp = sc.next();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = temp.charAt(j);
                }
            }

            System.out.println("Print character array: ");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            int counter = 0;
            for (int i = 0; i < N; i++) {
                boolean cInc = false;
                for (int j = 0; j < M; j++) {
                    if (cInc && arr[i][j] == '*' && (j != 0) && (i != 0 && arr[i - 1][j] == '*')) {
                        counter--;
                        System.out.println("Counter decreased\tCoordinates: (" + i + ", " + j + ")");
                    }

                    if (arr[i][j] == '*' && (j == 0 || arr[i][j - 1] == '.') && (i == 0 || arr[i - 1][j] == '.')) {
                        counter++;
                        cInc = true;
                        System.out.println("Counter increased\tCoordinates: (" + i + ", " + j + ")");
                    } else if (arr[i][j] == '.')
                        cInc = false;
                }
            }

            // Output answer
            System.out.println("==> " + counter);
        }
    }
}