//Lee
//Lab 2 - Birthday
//Determine which day we are born on

import java.util.Scanner; //Scanner allows you to access input from a user
public class Lab2_Birthday
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in); //Creates a scanner object
        
        //Inputs
        System.out.println("Please enter the month (3 for March, 13 for January): ");
        int month = input.nextInt();
        System.out.println("Please enter the date: ");
        int date = input.nextInt();
        System.out.println("Please enter the year (subtract 1 for Jan/Feb): ");
        int year = input.nextInt();
        
        //Calculations
        int firstTwo = year/100;
        int lastTwo = year%100;
        int monthVariation = 13 * (month + 1) / 5;
        
        int leapYear = lastTwo / 4;
        int leapCentury = firstTwo / 4 - 2 * firstTwo;
        int day = date + lastTwo + monthVariation + leapYear + leapCentury;
        day += 70;
        day %= 7;
        
        //Outputs
        System.out.println("0 is Saturday");
        System.out.println("1 is Sunday");
        System.out.println("2 is Monday");
        System.out.println("3 is Tuesday");
        System.out.println("4 is Wednesday");
        System.out.println("5 is Thursday");
        System.out.println("6 is Friday");        
        System.out.println(month + "-" + date + "-" + year + " falls on " + day);
    }
}