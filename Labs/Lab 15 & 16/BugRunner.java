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

/**
 * This class runs a world that contains a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        
        /*
        Bug bob = new Bug();
        world.add( bob );
        Bug sally = new Bug( Color.GREEN );
        world.add( sally );

        //DONE
        DiamondBug db = new DiamondBug();
        world.add( db );
        db.moveTo( new Location(0,4) );
        db.setDirection( Location.SOUTHEAST );

        //DONE
        BoxBug bb8 = new BoxBug( 8 );
        world.add( bb8 );
        bb8.moveTo( new Location(8,1) );
        BoxBug bb1 = new BoxBug( 6 );
        world.add( bb1 );
        bb1.moveTo( new Location(7,2) );

        //DONE
        SpiralBug spB = new SpiralBug();
        world.add(spB);
        spB.moveTo( new Location(0,0) );
        spB.setDirection( 90 );

        //DONE
        ZedBug zb = new ZedBug( 9 );
        world.add(zb);
        zb.moveTo( new Location(0,0) );
        zb.setDirection( 90 );
        
        //DONE
        JumperBug jb = new JumperBug( 8 );
        world.add( jb );
        jb.moveTo( new Location(8,1) );
        Rock r1 = new Rock();
        world.add(r1);
        r1.moveTo( new Location(6,1) );
        Rock r2 = new Rock();
        world.add(r2);
        r2.moveTo( new Location(2,1) );
        Rock r3 = new Rock();
        world.add(r3);
        r3.moveTo( new Location(5,1) );
        
        
        UselessBug noUse = new UselessBug();
        world.add( noUse );
        noUse.moveTo( new Location(9,9) );
        
        StalkerBug stB = new StalkerBug(noUse);
        world.add(stB);
        stB.moveTo( new Location(0,0) );
        stB.setDirection( 90 );*/
        
        world.show();
    }
}