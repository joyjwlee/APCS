import java.util.*;

public class Recursion {
    public int sumOfFirstNNumbers(int n) {
        if (n == 1)
            return 1;
        return n + sumOfFirstNNumbers(n - 1);
    }

    public int factorial(int num) {
        if (num == 1)
            return 1;
        return num * factorial(num - 1);
    }

    public int fibValue(int loc) {
        if (loc == 1 || loc == 0)
            return 1;
        return fibValue(loc - 1) + fibValue(loc - 2);
    }

    public int collatz(int num) {
        if (num == 1)
            return 0;
        else if (num % 2 == 0)
            return 1 + collatz(num / 2);
        else
            return 1 + collatz(3 * num + 1);
    }
}