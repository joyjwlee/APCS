import java.util.*;

public class Lab7Driver {
    static String str;
    static int n;
    static char a = 'A', b = 'B', c = 'C';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lab7 lab = new Lab7();

        System.out.println("\n==========================================\n");
        System.out.println("Enter a string to check if it's a palindrome: ");
        str = sc.next();
        if (lab.isPalindrome(str)) {
            System.out.println(str + " is a palindrome");
        } else {
            System.out.println(str + " is not a palindrome");
        }

        System.out.println("\n==========================================\n");
        System.out.println("Enter a string if it is in alphabetical order: ");
        str = sc.next();
        if (lab.isAlphabetical(str)) {
            System.out.println(str + " is alphabetical");
        } else {
            System.out.println(str + " is not alphabetical");
        }

        System.out.println("\n==========================================\n");
        System.out.println("Enter number of disks for Disks of Datang: ");
        n = sc.nextInt();
        System.out.println("Enter starting peg name (one character!): ");
        a = sc.next().charAt(0);
        System.out.println("Enter destination peg name (one character!): ");
        b = sc.next().charAt(0);
        System.out.println("Enter \"other\" peg name (one character!): ");
        c = sc.next().charAt(0);
        System.out.println("\nCool, here's how to solve it\n");
        lab.datang(n, a, b, c);
    }
}