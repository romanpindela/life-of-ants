package com.codecool.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

public class Worker extends Ant{
    public Worker(AntType antType) {
        super(antType);
    }

    @Override
    void move() {
        Position newPosition;
        Direction direction;
//        do {
            direction = Direction.getRandomDirection();

             newPosition = position.addDirection(direction);
//        }
//        while (this.getColony().checkPossiblePosition(newPosition));
        if (this.getColony().checkPossiblePosition(newPosition)){
            this.setPosition( newPosition );
        }

    }
}
