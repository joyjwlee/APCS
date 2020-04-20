import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class J1 extends Critter {
    // Start at 1 for mod3
    int numMoves = 1;

    public J1() {
        super();
    }

    // Collects locations of all critters that are not me
    public ArrayList<Actor> getActors() {
        int r = getLocation().getRow();
        int c = getLocation().getCol();

        Grid<Actor> gr = getGrid();
        ArrayList<Actor> toKill = new ArrayList<Actor>();
        for (int i = 0; i < gr.getNumRows(); i++) {
            for (int j = 0; j < gr.getNumCols(); j++) {
                if (i != r && j != c) {
                    Location loc = new Location(i, j);
                    Actor potential = gr.get(loc);
                    if (potential instanceof Critter && !(potential instanceof J1)) {
                        toKill.add(potential);
                    }
                }
            }
        }
        return toKill;
    }

    // Kill every move, randomly select
    public void processActors(ArrayList<Actor> actors) {
        int n = actors.size();
        if (n != 0) {
            int r = (int) (Math.random() * n);
            actors.get(r).removeSelfFromGrid();
        }
    }

    // Collects all available locations in the grid
    public ArrayList<Location> getMoveLocations() {
        Grid<Actor> gr = getGrid();
        ArrayList<Location> free = new ArrayList<Location>();
        for (int i = 0; i < gr.getNumRows(); i++) {
            for (int j = 0; j < gr.getNumCols(); j++) {
                Location loc = new Location(i, j);
                Actor neighbor = gr.get(loc);
                if (gr.isValid(loc) && !(neighbor instanceof Critter)) {
                    free.add(loc);
                }
            }
        }
        return free;
    }

    // Get first in array for advantage
    public Location selectMoveLocation(ArrayList<Location> locs) {
        Location pos = getLocation();
        Location copyPos = getLocation();
        boolean firstTaken = false;

        // Get the best position
        if (locs.size() > 0) {
            Location pot = locs.get(0);
            if ((pot.getRow() < pos.getRow()) || ((pot.getRow() == pos.getRow()) && (pot.getCol() < pos.getCol()))) {
                pos = pot;
                firstTaken = true;
            }
        }

        // Every 3 moves each one creates an offspring
        Grid<Actor> gr = getGrid();
        J1 copy = new J1();
        if (numMoves % 3 == 0) {
            // First is taken
            if (!firstTaken && locs.size() > 0) {
                copy.putSelfInGrid(gr, locs.get(0));
            }
            // Otherwise get second
            else {
                if (locs.size() > 1) {
                    copy.putSelfInGrid(gr, locs.get(1));
                }
            }
        }
        numMoves++;

        // Attempt 2
        /*
         * boolean firstTaken = false; //Update position to return if(locs.size() > 0) {
         * //Get first position pos = locs.get(0); firstTaken = true; } int r =
         * getLocation().getRow(); int c = getLocation().getCol(); if (r == 0 && c == 0)
         * { //If already in top left, set it to that pos = getLocation(); firstTaken =
         * false; }
         * 
         * //Now get position for copy if(!firstTaken && locs.size() > 0){ copyPos =
         * locs.get(0); } else if (firstTaken && locs.size() > 1){ copyPos =
         * locs.get(1); }
         */

        // Attempt 1
        /*
         * int n = locs.size(); int r = getLocation().getRow(); int c =
         * getLocation().getCol(); if (n == 0 || (r == 0 && c == 0)) { return
         * getLocation(); } return locs.get(0);
         */

        return pos;
    }
}