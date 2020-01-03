import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class JumperBug extends Bug{
    private int traveled, length;
    
    public JumperBug(int size){
        traveled = 1;
        length = size;
    }
    
    public void act(){
        Location curr = getLocation();
        Location away1 = curr.getAdjacentLocation( getDirection() );
        Location away2 = away1.getAdjacentLocation( getDirection() );
        
        if( traveled < length && canMove() ){
            move();
            traveled++;
        } else if(traveled < length && 0 <= away2.getRow() && away2.getRow() <= 9 && 0 <= away2.getCol() && away2.getCol() <= 9) {
            if( canJump(away2) ){
                jump( away2 );
            } else {
                turn();
                turn();
                traveled = 1;
            }
        } else {
            turn();
            turn();
            traveled = 1;
        }
    }
    
    public boolean canJump(Location away2){
        Grid<Actor> gr = getGrid();
        Actor neighbor = gr.get(away2);
        if(gr.isValid(away2) && !(neighbor instanceof Rock) && !(neighbor instanceof Bug)){
            return true;
        }
        return false;
    }
    
    public void jump(Location away2){
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Flower flower = new Flower(getColor());
        moveTo( away2 );
        traveled += 2;
        flower.putSelfInGrid(gr, loc);
    }
}