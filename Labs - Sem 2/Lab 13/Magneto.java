import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class Magneto extends Critter {
    public Magneto() {
        super();
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

    // Moves all of the rocks
    public void processActors(ArrayList<Actor> actors) {
        Grid<Actor> gr = getGrid();
        Location curr = getLocation();

        // Loop through all locations for rock
        for (int i = 0; i < gr.getNumRows(); i++) {
            for (int j = 0; j < gr.getNumCols(); j++) {
                Location loc = new Location(i, j);
                Actor neighbor = gr.get(loc);
                // If it's a rock, move it if possible
                if (neighbor instanceof Rock) {
                    moveRock(neighbor, curr, loc);
                }
            }
        }
    }

    public void moveRock(Actor toMove, Location curr, Location rock) {
        int rockR = rock.getRow();
        int rockC = rock.getCol();
        int newR = rockR, newC = rockC;
        // Above
        if (rockR < curr.getRow()) {
            // Left
            if (rockC < curr.getCol()) {
                if (isValid(rockR + 1, rockC)) {
                    newR = rockR + 1;
                    newC = rockC;
                }
                if (isValid(rockR, rockC + 1)) {
                    newR = rockR;
                    newC = rockC + 1;
                }
                if (isValid(rockR + 1, rockC + 1)) {
                    newR = rockR + 1;
                    newC = rockC + 1;
                }
            }
            // Right
            else if (rockC > curr.getCol()) {
                if (isValid(rockR + 1, rockC)) {
                    newR = rockR + 1;
                    newC = rockC;
                }
                if (isValid(rockR, rockC - 1)) {
                    newR = rockR;
                    newC = rockC - 1;
                }
                if (isValid(rockR + 1, rockC - 1)) {
                    newR = rockR + 1;
                    newC = rockC - 1;
                }
            }
        }
        // Below
        else if (rockR > curr.getRow()) {
            // Left
            if (rockC < curr.getCol()) {
                if (isValid(rockR - 1, rockC)) {
                    newR = rockR - 1;
                    newC = rockC;
                }
                if (isValid(rockR, rockC + 1)) {
                    newR = rockR;
                    newC = rockC + 1;
                }
                if (isValid(rockR - 1, rockC + 1)) {
                    newR = rockR - 1;
                    newC = rockC + 1;
                }
            }
            // Right
            else if (rockC > curr.getCol()) {
                if (isValid(rockR - 1, rockC)) {
                    newR = rockR - 1;
                    newC = rockC;
                }
                if (isValid(rockR, rockC - 1)) {
                    newR = rockR;
                    newC = rockC - 1;
                }
                if (isValid(rockR - 1, rockC - 1)) {
                    newR = rockR - 1;
                    newC = rockC - 1;
                }
            }
        }
        toMove.moveTo(new Location(newR, newC));
    }

    public boolean isValid(int i, int j) {
        Grid<Actor> gr = getGrid();
        Actor neighbor = gr.get(new Location(i, j));
        if (gr.isValid(new Location(i, j)) && !(neighbor instanceof Actor)) {
            return true;
        }
        return false;
    }
}