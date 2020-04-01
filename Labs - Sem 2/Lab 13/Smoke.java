import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class Smoke extends Rock {
    public int life = 0;

    public Smoke(Color smokeColor) {
        super(smokeColor);
    }

    public void act() {
        life++;
        if (life > 10) {
            this.removeSelfFromGrid();
        }
    }
}