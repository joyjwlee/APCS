//Lee
//Lab 8 - Pictures
//Use for loops to print out a multiplication table, make a pyramid, and draw a *colorful* circle
//Extensions: random colors for circle

import java.util.*;
import gpdraw.*;
import java.awt.*;

public class Lab8_Pictures {
    private DrawingTool myPencil;
    private SketchPad myPaper;

    public Lab8_Pictures() {
        myPaper = new SketchPad( 500, 500 );
        myPencil = new DrawingTool( myPaper );

        int r, g, b;
        Random rand = new Random();

        for(int i = 0; i < 360; i++) {
            r = rand.nextInt(255);
            g = rand.nextInt(255);
            b = rand.nextInt(255);

            myPencil.setColor(new Color( r, g, b ));

            myPencil.forward(200);
            myPencil.forward(-200);
            myPencil.turn(1);
        }        
    }

    public static void main (String[] args) {
        Lab8_Pictures obj = new Lab8_Pictures();
        obj.doStuff();
    } // ends method main

    public void doStuff() {
        Scanner input = new Scanner( System.in );

        //Multiplication Table
        System.out.println( "\n=================================================================");
        System.out.println( "Enter table height: " );
        int xDim = input.nextInt();
        System.out.println( "Enter table width: " );
        int yDim = input.nextInt();
        printTable( xDim, yDim );

        System.out.println( "\n=================================================================\n");
        System.out.println( "Enter pyramid height: " );
        int pyramid = input.nextInt();
        makePyramid( pyramid );
    } // ends method doStuff

    //Precondition: dimensions are user-entered integers
    //Postcondition: prints out a multiplication table based on those dimensions
    public void printTable( int xDim, int yDim ) {
        System.out.print("\t");
        for(int i = 1; i <= yDim; i++) {
            System.out.print( i + "\t");
        }
        System.out.println("");

        for(int i = 1; i <= xDim; i++) {
            System.out.print( i + "\t");
            for(int j = 1; j <= yDim; j++) {
                System.out.print( (i*j) + "\t");
            }
            System.out.println("");
        }
    }

    //Precondition: height is user-entered integers
    //Postcondition: prints out a pyramid accordingly to height
    public void makePyramid( int height ) {
        for(int i = 0; i < height; i++) {
            //print spaces
            for(int j = height - 1 - i; j >= 0; j--) {
                System.out.print(" ");
            }
            //print asterisks
            for(int j = 1; j <= 2*i+1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}