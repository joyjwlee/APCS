//Lee
//Lab 7 - Loops With Methods
//Determine eligibility for extracurricular activities
//Extensions: user inputs money wanted || random number guessing game

import java.util.*;

public class Lab7_LoopsWithMethods {
    public static void main (String[] args) {
        Lab7_LoopsWithMethods obj = new Lab7_LoopsWithMethods();
        obj.doStuff();
    } // ends method main

    public void doStuff() {
        Scanner input = new Scanner( System.in );
        System.out.println( "\n=================================================================");
        System.out.println( "Enter a number and I will tell you if it is prime or not: " );
        int number = input.nextInt();
        
        boolean isPrime = checkPrime( number );         // method #1
        if ( isPrime ) System.out.println( "Your number, " + number + ", is prime!" );
        else System.out.println( "Your number, " + number + ", is composite!" );

        System.out.println( "\n=================================================================\n");
        calculateAverage();                             // method #2

        System.out.println( "\n=================================================================\n");;
        System.out.println( "Enter target amount: " );
        int target = input.nextInt();
        System.out.println( "Enter an annual contribution towards saving $" + target + ": ");
        int contribution = input.nextInt();
        System.out.println( "Enter an annual interest rate: " );
        double rate = input.nextDouble();
        printInvestmentTable( contribution, rate, target );     // method #3
        
        System.out.println( "\n=================================================================\n");;
        System.out.println( "Time to play the random number guessing game!" );
        System.out.println( "Enter lower bound: " );
        int lowerBound = input.nextInt();
        System.out.println( "Enter upper bound: " );
        int upperBound = input.nextInt();
        guessingGame( lowerBound, upperBound );        // method #4
    } // ends method doStuff
    
    //Precondition: number is user-entereed integer
    //Postcondition: Return true if prime; false otherwise
    public boolean checkPrime( int number ) {
        int x = 2;
        while ( x <= Math.sqrt(number) ) {
            if ( number%x == 0 ) return false;
            x++;
        }
        return true;
    } // ends method checkPrime
    
    //Precondition: method called to calculate average
    //Postcondition: average of user-entered scores with lowest score dropped is printed
    public void calculateAverage() {
        Scanner input = new Scanner( System.in );
        int counter = 0;
        int grade = 0;
        int sum = 0;
        int smallest = Integer.MAX_VALUE;
        while ( grade != -1 ) {
            System.out.println("Enter grade between 0 and 100 (-1 when finished): ");
            grade = input.nextInt();
            sum += grade;
            if (grade != -1 && grade <= smallest) smallest = grade;
            counter++;
        }
        sum++;
        counter--;
        double avg = sum / (double) counter;
        System.out.println("Your average grade with all scores is:\t\t\t" + avg);
        avg = (sum - smallest) / (double) (counter - 1);
        System.out.println("Your average grade with the lowest score dropped is:\t" + avg);
    } // ends method calculateAverage
    
    //Precondition: contribution and rate are user-entered values
    //Postcondition: printed table of earned interest and balance until target amount of money is reached
    public void printInvestmentTable( int contribution, double rate, int target ) {
        int year = 1;
        int total = contribution;
        double interestEarned = 0;
        int newTotal = total;
        System.out.println( "Year \tContribution \tTotal \tInterest Earned \tNew Total" );
        while ( total <= target ) {
            interestEarned = ( ( Math.pow( 1+(rate/100), (double)year) ) * contribution ) - contribution;
            newTotal = total + (int)interestEarned;
            System.out.println(year + "\t" + contribution + "\t\t" + total + "\t" + (int)interestEarned + "\t\t\t" + newTotal);
            total = newTotal + contribution;
            year++;
        }
    } // ends methods printInvestmentTable
    
    //Precondition: contribution and rate are user-entered values
    //Postcondition: printed table of earned interest and balance until target amount of money is reached
    public void guessingGame( int min, int max ) {
        Scanner input = new Scanner( System.in );
        Random ran = new Random();
        int answer = ran.nextInt((max - min) + 1) + min;
        int guess;
        boolean isCorrect = false;
        while ( isCorrect == false) {
            System.out.println( "Enter your guess: ");
            guess =  input.nextInt();
            if ( guess > answer) System.out.println( "Your number is too high!" );
            else if ( guess < answer) System.out.println( "Your number is too low!" );
            else{
                System.out.println( "You are correct!" );
                isCorrect = true;
            }
        }
    } // ends methods printInvestmentTable
} // end class Lab7_LoopsWithMethods