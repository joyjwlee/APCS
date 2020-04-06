import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class J1 extends Critter {
    // Starts at 1 for 0mod3
    int numMoves = 1;

    public J1() {
        super();
    }

    // Collects locations of all critters
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
                    if (potential instanceof Critter) {
                        toKill.add(potential);
                    }
                }
            }
        }
        return toKill;
    }

    // Kill only once every 3 moves
    public void processActors(ArrayList<Actor> actors) {
        numMoves++;
        int n = actors.size();
        if (numMoves % 3 == 0 && n != 0) {
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
}