import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int gen = n % 7;
        System.out.println("Generated number: " + gen);
        System.out.print("Generated day is: ");
        if (gen == 0) {
            System.out.print("Sunday");
        } else if (gen == 1) {
            System.out.print("Monday");
        } else if (gen == 2) {
            System.out.print("Tuesday");
        } else if (gen == 3) {
            System.out.print("Wednesday");
        } else if (gen == 4) {
            System.out.print("Thursday");
        } else if (gen == 5) {
            System.out.print("Friday");
        } else if (gen == 6) {
            System.out.print("Saturday");
        }
    }
}