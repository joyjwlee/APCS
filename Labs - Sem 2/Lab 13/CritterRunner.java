/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;

public class CritterRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();

        Mystique a = new Mystique();
        world.add(a);

        // Mystique b = new Mystique();
        // world.add(b);

        Nightcrawler c = new Nightcrawler();
        world.add(c);

        // Nightcrawler d = new Nightcrawler();
        // world.add(d);

        Magneto e = new Magneto();
        world.add(e);

        Bug b1 = new Bug();
        world.add(b1);

        Bug b2 = new Bug(Color.YELLOW);
        world.add(b2);

        Bug b3 = new Bug(Color.GREEN);
        world.add(b3);

        Rock r1 = new Rock();
        world.add(r1);

        Rock r2 = new Rock();
        world.add(r2);

        Rock r3 = new Rock();
        world.add(r3);

        world.show();
    }
}