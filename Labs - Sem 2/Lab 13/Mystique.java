import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class Mystique extends Critter {
    public Mystique() {
        super();
    }

    // Randomly selects neighbor and becomes that color
    public void processActors(ArrayList<Actor> actors) {
        // Call the turn method
        turn();
        // Filter only for bugs
        ArrayList<Actor> bugs = new ArrayList<Actor>();
        for (Actor a : actors) {
            if (a instanceof Bug) {
                bugs.add(a);
            }
        }
        // Randomly selects one
        int n = bugs.size();
        if (n == 0) {
            return;
        }
        Actor other = bugs.get((int) (Math.random() * n));
        setColor(other.getColor());
    }

    // Randomly set the direction
    public void turn() {
        setDirection((int) (Math.random() * 360));
    }
}
