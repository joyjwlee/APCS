import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class Exponential extends Critter {
    int numCopies = 3;
    ArrayList<Location> copiesPlaced = new ArrayList<Location>();

    public Exponential() {
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

    // Make copies of itself
    public void makeMove(Location loc) {
        Grid<Actor> gr = getGrid();
        ArrayList<Location> locs = getMoveLocations();

        // Gets current location and remove for now
        Location curr = getLocation();
        this.removeSelfFromGrid();

        // Generates up to number of copies of itself
        for (int i = 0; i < numCopies; i++) {
            Exponential copy = new Exponential();
            int n = locs.size();
            if (n == 0) {
                copy.putSelfInGrid(gr, curr);
                break;
            }
            int r = (int) (Math.random() * n);
            copy.putSelfInGrid(gr, locs.get(r));
            locs.remove(r);
        }
    }
}