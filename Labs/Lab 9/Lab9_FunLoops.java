//Lee
//Lab 9 - Fun Loops
//Using loops to find LCM, print an integer in reverse, and find an n number of magic squares
//Extensions: random colors for circle

import java.util.*;
public class Lab9_FunLoops {
    public void go() {
        Scanner input = new Scanner(System.in);
        System.out.println( "\n=================================================================");
        System.out.println("Enter two numbers and I will find the LCM and GCF: ");
        int first = input.nextInt();
        int second = input.nextInt();
        int lcm = findLCM(first, second); // I did not use the GCF recursive method for LCM
        int gcf = findGCF(first, second); // GCF, however, does use recursion; it's an extension
        System.out.println("The LCM of " + first + " and " + second + " is " + lcm);
        System.out.println("The GCF of " + first + " and " + second + " is " + gcf);

        System.out.println( "\n=================================================================");
        System.out.println("Enter an integer to be reversed: ");
        int forward = input.nextInt();
        int backward = reverse(forward);
        System.out.println("" + forward + " reversed is " + backward);

        System.out.println( "\n=================================================================");
        System.out.println("How many magic squares do you want to find?");
        int number = input.nextInt();
        magicSquares(number);
    }

    // Pre: x and y > 0
    // Post: returns the least common multiple of x and y
    public int findLCM(int x, int y) { 
        int multiple = 1;
        while( (multiple%x != 0) || (multiple%y != 0) ){
            multiple++;
        }
        return multiple;
    }

    // Recursive application of Euclidean algorithm to find GCF
    public int findGCF(int w, int z) { 
        if (w == 0) return z;
        return findGCF(z % w, w);
    }

    // Pre: x and y > 0
    // Post: returns the least common multiple of x and y via GCF, not used in this code
    public int recursiveFindLCM(int x, int y) { 
        return (x*y)/findGCF(x, y); 
    }

    // Pre: get integer number
    // Post: returns an integer backwards, which is number in reverse
    public int reverse( int number ) {
        int digit, backwards = 0;
        for( ; number != 0; number /= 10) {
            digit = number % 10;
            backwards = backwards * 10 + digit;
        }
        return backwards;
    }

    // Pre: get how many magic squares to print from user
    // Post: prints out that many number of magic squares
    public void magicSquares( int howMany ) {
        int number = 0, printed = 0;
        for (int i = 0; printed < howMany; i++) {
            number += i;
            if( isSquare( number ) && number != 0 && number != 1 ) {
                System.out.println(number + " is a magic square");
                printed++;
            }
        }
    }

    // Pre: gets an integer from magicSquares
    // Post: returns whether or not if the number is a square number
    public boolean isSquare( int potential ) {
        for (int i = 1; i * i <= potential; i++) {
            if ((potential % i == 0) && (potential / i == i)) return true;
        }
        return false;
        /* double root = Math.sqrt( potential );
         * return ( (root - (int)root ) == 0 ); //Math.floor(root) or cast as integer
         */
    }
}