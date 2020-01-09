import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class BoxBug extends Bug{
    private int traveled, length;
    
    public BoxBug(int size){
        traveled = 1;
        length = size;
    }
    
    public void act(){
        if( traveled < length && canMove() ){
            move();
            traveled++;
        }
        else{
            turn();
            turn();
            traveled = 1;
        }
    }
}