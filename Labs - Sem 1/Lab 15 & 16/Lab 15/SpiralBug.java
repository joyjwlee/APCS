import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class SpiralBug extends Bug{
    private int length;
    private int traveled;
    private int turnIndicator;
    private boolean traveled3;

    public SpiralBug(){
        length = 9;
        traveled = 0;
        turnIndicator = 0;
        traveled3 = false;
    }

    public boolean canMove(){
        Grid<Actor> gr = getGrid();
        if(gr == null) return false;
        Location curr = getLocation();
        Location next = curr.getAdjacentLocation(getDirection());
        if(!gr.isValid(next)) return false;
        Actor neighbor = gr.get(next);
        return neighbor == null;
    }
}