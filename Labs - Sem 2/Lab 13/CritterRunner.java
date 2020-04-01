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

        Critter c = new Critter();
        world.add(c);

        Critter d = new Critter();
        world.add(d);

        Bug bob = new Bug();
        world.add(bob);

        Bug dee = new Bug(Color.YELLOW);
        world.add(dee);

        Bug fred = new Bug(Color.GREEN);
        world.add(fred);

        Rock r = new Rock();
        world.add(r);

        world.show();
    }

}