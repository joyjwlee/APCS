import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class J1 extends Critter {
    public J1() {
        super();
    }

    // Collects all locations with nothing surrounding it
    public ArrayList<Location> getMoveLocations() {
        Grid<Actor> gr = getGrid();
        ArrayList<Location> free = new ArrayList<Location>();
        // Loop through every location
        for (int i = 0; i < gr.getNumRows(); i++) {
            for (int j = 0; j < gr.getNumCols(); j++) {
                Location curr = new Location(i, j);
                int numNeighbors = 0;
                // Loop through all neighbors
                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        int r = i + k;
                        int c = j + l;
                        Location around = new Location(r, c);
                        if (gr.isValid(around)) {
                            Actor neighbor = gr.get(around);
                            if (neighbor instanceof Actor) {
                                numNeighbors++;
                            }
                        }
                    }
                }
                // If there are none surrounding it, good to go
                if (numNeighbors == 0) {
                    free.add(curr);
                }
            }
        }
        return free;
    }

    // If it can't go anywhere, remove itself
    public void makeMove(Location loc) {
        ArrayList<Location> moveLocs = getMoveLocations();
        if (loc == null || moveLocs.size() == 0) {
            removeSelfFromGrid();
        } else {
            moveTo(loc);
        }
    }
}
