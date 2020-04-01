import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class Nightcrawler extends Critter {
    public Nightcrawler() {
        super();
    }

    // Collects all available locations in the grid
    public ArrayList<Location> getMoveLocations() {
        Grid<Actor> gr = getGrid();
        ArrayList<Location> free = new ArrayList<Location>();
        for (int i = 0; i < gr.getNumRows(); i++) {
            for (int j = 0; j < gr.getNumCols(); j++) {
                Location loc = new Location(i, j);
                Actor neighbor = gr.get(loc);
                if (gr.isValid(loc) && !(neighbor instanceof Actor)) {
                    free.add(loc);
                }
            }
        }
        return free;
    }

    // Moves and leaves smoke
    public void makeMove(Location loc) {
        // Gets current location then move
        Location curr = getLocation();
        moveTo(loc);
        // With formerly current location, place smoke
        Grid<Actor> gr = getGrid();
        Smoke trail = new Smoke(Color.PINK);
        trail.putSelfInGrid(gr, curr);
    }
}