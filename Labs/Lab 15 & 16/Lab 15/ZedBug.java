import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class ZedBug extends Bug{
    private int length;
    private int traveled;
    private int turnIndicator;

    public ZedBug(int sizeOfZed){
        length = sizeOfZed;
        traveled = 0;
        turnIndicator = 1;
    }

    public void act(){
        if( traveled < length && canMove() ){
            move();
            traveled++;
        } else {
            traveled = 0;
            switch (turnIndicator%6) {
                case 0:
                    setDirection( getDirection() + 180 );
                    break;
                case 1:
                    setDirection( getDirection() + 135);
                    break;
                case 2:
                    setDirection( getDirection() - 135);
                    break;
                case 3:
                    setDirection( getDirection() + 180 );
                    break;
                case 4:
                    setDirection( getDirection() + 135);
                    break;
                case 5:
                    setDirection( getDirection() - 135);
                    break;
            }
            turnIndicator++;
        }
    }
}