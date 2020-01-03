//Lee
//Lab 5 - Check Mail
//Determine if the package can shipped first class or not
//Extensions: TBD

import java.util.*;
public class Lab5_CheckMail {
    public static void main( String[] args ) {
        Scanner input = new Scanner(System.in);
        double dim1, dim2, dim3, length, girth, weight;
        
        //Input values
        System.out.println("Please input the weight: ");
        weight = input.nextDouble();
        System.out.println("Please input the first dimension: ");
        dim1 = input.nextDouble();
        System.out.println("Please input the second dimension: ");
        dim2 = input.nextDouble();
        System.out.println("Please input the last dimension: ");
        dim3 = input.nextDouble();
        
        //Find largest ==> length
        if (dim1 >= dim2 && dim1 >= dim2) length = dim1;
        else if (dim2 >= dim1 && dim2 >= dim3) length = dim2;
        else length = dim3;
        
        
        //Find girth
        girth = (dim1 + dim2 + dim3 - length) * 2;
        
        //Determine Output
        if (weight > 70.0 && (length + girth) > 100.0) System.out.println("Package is too large and too heavy.");
        else if (weight > 70.0 && (length + girth) <= 100.0) System.out.println("Package is too heavy.");
        else if (weight<= 70.0 && (length + girth) > 100.0) System.out.println("Package is too large.");
        else System.out.println("Package may be shipped first class.");
    }
}