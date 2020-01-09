//Lee
//Lab 4 - House
//Learn to use DrawingTool and SketchPad class
import gpdraw.*;
import java.awt.*;
public class Lab4_House{
    private DrawingTool myPencil;
    private SketchPad myPaper;
    
    public Lab4_House(){
        myPaper = new SketchPad( 600, 600 );
        myPencil = new DrawingTool ( myPaper );
    }
    
    public void draw(){
        /*Ground
        myPencil.up();
        myPencil.move(0, -250);
        myPencil.down();
        myPencil.setColor( new Color(102, 255, 102) );
        myPencil.fillRect(600, 50);
        myPencil.setColor( new Color(0, 0, 0) );
        myPencil.fillRect(30, 30);*/
        
        //Ground
        myPencil.up();
        myPencil.move(-300, -250);
        myPencil.down();
        myPencil.move(300, -250);
        
        //Top Left
        myPencil.up();
        myPencil.move(0,125);
        myPencil.down();
        myPencil.move(0, -25);
        myPencil.move(-200, -25);
        myPencil.move(-200, 125);
        myPencil.move(-100, 225);
        myPencil.move(25, 100);
        myPencil.move(25, 125);
        myPencil.move(-100, 250);
        myPencil.move(-225, 125);
        myPencil.move(-225, 100);
        myPencil.move(-200, 125);
        
        //Top Right
        myPencil.up();
        myPencil.move(0, 0);
        myPencil.down();
        myPencil.move(250, 0);
        myPencil.move(250, 175);
        myPencil.move(275, 150);
        myPencil.move(275, 175);
        myPencil.move(125, 300);
        myPencil.move(-13, 163);
        myPencil.move(0, 150);
        myPencil.move(125, 275);
        myPencil.move(250, 175);
        
        //Bottom Roof
        myPencil.up();
        myPencil.move(-200, 0);
        myPencil.down();
        myPencil.move(-275, -75);
        myPencil.move(275, -75);
        myPencil.move(250, 0);
        
        //Pillars
        myPencil.up();
        myPencil.move(-250, -75);
        myPencil.down();
        myPencil.move(-250, -200);
        myPencil.move(-275, -200);
        myPencil.move(-275, -250);
        myPencil.move(-200, -250);
        myPencil.move(-200, -200);
        myPencil.move(-225, -200);
        myPencil.move(-225, -75);
        
        myPencil.up();
        myPencil.move(0, -75);
        myPencil.down();
        myPencil.move(0, -200);
        myPencil.move(-25, -200);
        myPencil.move(-25, -250);
        myPencil.move(50, -250);
        myPencil.move(50, -200);
        myPencil.move(25, -200);
        myPencil.move(25, -75);
        
        myPencil.up();
        myPencil.move(250, -75);
        myPencil.down();
        myPencil.move(250, -200);
        myPencil.move(275, -200);
        myPencil.move(275, -250);
        myPencil.move(250, -250);
        myPencil.move(200, -250);
        myPencil.move(200, -200);
        myPencil.move(225, -200);
        myPencil.move(225, -75);
        
        //Garage Door
        for(int i = 0; i < 6; i++){
            int move = 25;
            myPencil.up();
            myPencil.move(-175, -250 + move * i);
            myPencil.down();
            myPencil.move(-50, -250 + move * i);
        }
        myPencil.up();
        myPencil.move(-175, -250);
        myPencil.down();
        myPencil.move(-175, -125);
        myPencil.up();
        myPencil.move(-50, -250);
        myPencil.down();
        myPencil.move(-50, -125);
        
        //Door and Knob
        myPencil.up();
        myPencil.move(200, -250);
        myPencil.down();
        myPencil.move(200, -100);
        myPencil.move(150, -100);
        myPencil.move(150, -250);
        myPencil.up();
        myPencil.move(190, -175);
        myPencil.down();
        myPencil.drawCircle(5.0);
        
        //Windows - Bottom, Left, then Right
        //myPencil.setColor( new Color(51, 153, 255) );
        myPencil.up();
        myPencil.move(50, -100);
        myPencil.down();
        myPencil.move(50, -175);
        myPencil.move(125, -175);
        myPencil.move(125, -100);
        myPencil.move(50, -100);
        myPencil.up();
        myPencil.move(87.5, -100);
        myPencil.down();
        myPencil.move(87.5, -175);
        myPencil.up();
        myPencil.move(50, -137.5);
        myPencil.down();
        myPencil.move(125, -137.5);
        
        myPencil.up();
        myPencil.move(-175, 0);
        myPencil.down();
        myPencil.move(-25, 0);
        myPencil.move(-25, 125);
        myPencil.move(-175, 125);
        myPencil.move(-175, 0);
        myPencil.up();
        myPencil.move(-25, 62.5);
        myPencil.down();
        myPencil.move(-175, 62.5);
        myPencil.up();
        myPencil.move(-100, 0);
        myPencil.down();
        myPencil.move(-100, 125);
        
        myPencil.up();
        myPencil.move(50, 25);
        myPencil.down();
        myPencil.move(225, 25);
        myPencil.move(225, 150);
        myPencil.move(50, 150);
        myPencil.move(50, 25);
        myPencil.up();
        myPencil.move(50, 87.5);
        myPencil.down();
        myPencil.move(225, 87.5);
        myPencil.up();
        myPencil.move(137.5, 25);
        myPencil.down();
        myPencil.move(137.5, 150);
    }
}