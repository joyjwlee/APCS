import java.util.*;

public class RecursionDriver {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Recursion rec = new Recursion();
        System.out.println("========================================");
        System.out.println("Enter n to find sum of first n numbers: ");
        n = sc.nextInt();
        System.out.println("Sum of first " + n + " numbers is: " + rec.sumOfFirstNNumbers(n));

        System.out.println("========================================");
        System.out.println("Enter n to find its factorial: ");
        n = sc.nextInt();
        System.out.println("The factorial of " + n + " is: " + rec.factorial(n));

        System.out.println("========================================");
        System.out.println("Enter n to find its fibonacci: ");
        n = sc.nextInt();
        System.out.println("The fibonacci of " + n + " is: " + rec.fibValue(n));

        System.out.println("========================================");
        System.out.println("Enter n to find number of Collatz iterations: ");
        n = sc.nextInt();
        System.out.println("The number of iterations for " + n + " is: " + rec.collatz(n));
    }
}