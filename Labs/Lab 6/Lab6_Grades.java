//Lee
//Lab 6 - Grades
//Determine eligibility for extracurricular activities
//Extensions: ONLY accept values A~E, F, a~e, or f

import java.util.*;
public class Lab6_Grades {
    public static void main( String[] args ) {
        Scanner input = new Scanner(System.in);
        char grade = 'A';
        int gradeAscii = (int) grade;
        
        double averageGPA, totalPoints = 0;
        int numberOfClasses = 0;
        boolean hasAnF = false;
        
        while( (65 <= gradeAscii && gradeAscii <= 68) || (gradeAscii == 70) || (97 <= gradeAscii && gradeAscii <= 100) || (gradeAscii == 102) ) {
            //Input the Letter Grade
            System.out.println("Please enter your Letter Grade (enter anything else to stop): ");
            grade = input.next().charAt(0);
            gradeAscii = (int) grade;
            
            //Check if there are any F's
            if( gradeAscii == 70 || gradeAscii == 102 ) hasAnF = true;
            
            //Determine how many Points to add
            if( gradeAscii == 65 || gradeAscii == 97 ) totalPoints += 4.0; // Get an A
            else if( gradeAscii == 66 || gradeAscii == 98 ) totalPoints += 3.0; //Get a B
            else if( gradeAscii == 67 || gradeAscii == 99 ) totalPoints += 2.0; //Get a C
            else if( gradeAscii == 68 || gradeAscii == 100 ) totalPoints += 1.0; //Get a D
            else if( gradeAscii == 70 || gradeAscii == 102 ) totalPoints += 0.0; //Get an F
            
            //Add one to total classes
            numberOfClasses++;
        }
        
        //Finalize Calculation
        numberOfClasses--;
        averageGPA = totalPoints / numberOfClasses;
        
        //Output
        System.out.print("GPA = " + averageGPA + " || ");        
        if(numberOfClasses < 4 ) System.out.println("Ineligible, student is taking fewer than four classes");
        else if( averageGPA < 2.0 && hasAnF ) System.out.println("Ineligible, GPA is below 2.0 and student has at least one F grade");
        else if( averageGPA < 2.0 ) System.out.println("Ineligible, GPA is below 2.0");
        else if( hasAnF )  System.out.println("Ineligible, GPA is at or above 2.0 but student has at least one F grade");        
        else System.out.println("Eligible");
    }
}