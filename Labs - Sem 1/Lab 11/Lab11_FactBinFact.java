//Lee
//Lab 11 - Fact Bin Fact
//To find a number's factorial, its form in a different base, and it's prime factors
//Extensions: asks how many of each thing a person wants to do || asks a specific base for conversion

import java.util.*;
public class Lab11_FactBinFact {
    public static void main (String[] args) {
        Lab11_FactBinFact obj = new Lab11_FactBinFact();
        obj.mainDriver();
    }

    public void mainDriver() {
        Scanner input = new Scanner(System.in);
        int num;
        int iterations;

        //Factorial
        System.out.println("\n=================================================================");
        System.out.println("For how many numbers do you want to find the factorial?");
        iterations = input.nextInt();
        for(int i = 0; i < iterations; i++){
            System.out.print("\nEnter an integer to find its factorial: ");
            num = input.nextInt();
            System.out.print("The factorial of " + num + " is " + findFactorial( num ));
        }
        System.out.println();

        //Decimal to Binary
        System.out.println("\n=================================================================");
        System.out.println("For how many numbers do you want to convert the base?");
        iterations = input.nextInt();
        for(int i = 0; i < iterations; i++){
            System.out.print("\nEnter an integer in decimal: ");
            num = input.nextInt();
            System.out.print("Enter the base you want to convert it to (2~9, inclusive): ");
            int base = input.nextInt();
            System.out.print(num + " in base " + base + " is: " + changeBase( num, base ));
        }
        System.out.println();

        //Prime Factors
        System.out.println("\n=================================================================");
        System.out.println("For how many numbers do you want to find the factors?");
        iterations = input.nextInt();
        for(int i = 0; i < iterations; i++){
            System.out.print("\nEnter an integer to find its prime factors: ");
            int findFactors = input.nextInt();
            findPrimeFactors( findFactors );
        }
    }

    //Pre: an integer > 0
    //Post: the factorial of that integer
    public int findFactorial( int x ){
        int factorialVal = 1;
        while( x > 1 ){
            factorialVal *= x;
            x--;
        }
        return factorialVal;
    }

    //Pre: an integer in decimal and a base to convert it to from 2 to 9
    //Post: the factorial of that integer in the specified base
    public int changeBase( int x, int base ){
        int place = 1;
        int converted = 0;
        while (x != 0){
            int digit = x%base;
            converted += digit*place;
            x /= base;
            place *= 10;
        }
        return converted;
    }

    //Pre: an integer
    //Post: the prime factors of that number
    public void findPrimeFactors( int x ){
        System.out.print("The prime factors of " + x + " are: ");
        for(int i = 2; i < x; i++) {
            while( x%i == 0 ) {
                if( checkPrime(x) ){
                    System.out.print(i);
                    x /= i;
                } else{
                    System.out.print(i + ", ");
                    x /= i;
                }
            }
        }
        //In case x is a prime
        if(x > 2) System.out.print(x);
    }

    //Pre: an integer
    //Post: true if is prime, false if is not prime
    public boolean checkPrime( int number ) {
        int x = 2;
        while ( x <= Math.sqrt(number) ) {
            if ( number%x == 0 ) return false;
            x++;
        }
        return true;
    }
}