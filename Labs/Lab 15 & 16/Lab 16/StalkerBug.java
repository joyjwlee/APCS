import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class StalkerBug extends Bug{
    private Bug prey;
    
    public StalkerBug(Bug target){
        prey = target;
    }
    
    public void act(){
        Location here = getLocation();
        Location preyLoc = prey.getLocation();
        int dir = here.getDirectionToward(preyLoc);
        Location next = here.getAdjacentLocation(dir);
        Grid<Actor> gr = getGrid();
        Actor neighbor = gr.get(next);
        setDirection(dir);
        if(gr.isValid(next) && neighbor == null){
            moveTo(next);
            Flower flower = new Flower(getColor());
            flower.putSelfInGrid(gr, here);
        }
    }
}