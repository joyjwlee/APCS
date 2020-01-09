//Lee
//Lab 3 - Coins
//Determine the change and coins
//Extensions: determine bills || random number guess for 1 cent discount || determine if person paid enough

import java.util.Scanner;
import java.util.Random;
public class Lab3_Coins
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        double price, paid, change, dollars, cents; //For input values
        int changeInt, dollarsInt, centsInt; //For integers to use for calculations
        int quarters, dimes, nickels, pennies; //For coins
        int ones, twos, fives, tens, twenties, fifties, hundreds; //For bills
                
        //Inputs
        System.out.println( "Purchase Price: " );
        price = input.nextDouble();
        System.out.println( "Cash Tendered: " );
        paid = input.nextDouble();
        
        if (paid >= price){
            //Random Number Guessing
            System.out.println( "Guess a random number from 1 to 10: (inclusive)" );
            int guess = input.nextInt();
            Random rand = new Random();
            int randomNum = rand.nextInt(10) + 1;
            boolean correct = false;
            if(guess == randomNum) {
                System.out.println( "You guessed it correctly! You have a 1 cent discount!" );
                System.out.println( "" );
                correct = true;
            } else {
                System.out.println( "Sorry, wrong guess. Better luck next time!" );
                System.out.println( "The right answer was " + randomNum);
                System.out.println( "" );
            }
            
            //Calculations - Cents - Dollars
            change = (paid - price) * 100;
            changeInt = (int) change;
            dollars = change / 100;
            dollarsInt = (int) dollars;
            cents = change % 100;
            centsInt = (int) cents;
            
            if(correct){
                centsInt--;
            }        
            quarters = centsInt / 25;
            dimes = ( centsInt - quarters * 25 ) / 10;
            nickels = ( centsInt - quarters * 25 - dimes * 10 ) / 5;
            pennies = centsInt % 5;
            
            hundreds = dollarsInt / 100;
            fifties = ( dollarsInt - hundreds * 100 ) / 50;
            twenties = ( dollarsInt - hundreds * 100 - fifties * 50 ) / 20;
            tens = ( dollarsInt - hundreds * 100 - fifties * 50 - twenties * 20 ) / 10;
            fives = ( dollarsInt - hundreds * 100 - fifties * 50 - twenties * 20 - tens * 10) / 5;
            twos = ( dollarsInt%5 )/2;
            ones = ( dollarsInt%5 )%2;
            
            //Outputs
            System.out.println( "Your change is " + dollarsInt + " dollars and " + centsInt + " cents" );
            System.out.println( "" );        
            System.out.println( centsInt + " cents is returned as: " );
            System.out.println( quarters + " quarters" );
            System.out.println( dimes + " dimes" );
            System.out.println( nickels + " nickels" );
            System.out.println( pennies + " pennies" );
            System.out.println( "" );
            System.out.println( dollarsInt + " dollars is returned as: " );
            System.out.println( hundreds + " hundreds" );
            System.out.println( fifties + " fifties" );
            System.out.println( twenties + " twenties" );
            System.out.println( tens + " tens" );
            System.out.println( fives + " fives" );
            System.out.println( twos + " twos" );
            System.out.println( ones + " ones" );
        } else {
            System.out.println( "You did not pay enough!!" );
        }
    }
}