package com.codecool.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

public class Soldier extends Ant {
    public Soldier(AntType antType) {
        super(antType);
    }
    private Direction lastStepDirection;
    private int stepsCounter;

    public Soldier(AntType antType, Direction lastStepDirection) {
        super(antType);
        this.lastStepDirection = Direction.getRandomDirection();
        stepsCounter = 0;
    }

    @Override
    void move() {
        Position newPosition;
        if (stepsCounter < 4) {
            stepsCounter += 1;
            lastStepDirection = Direction.turnLeft(lastStepDirection);

        } else {
            lastStepDirection = Direction.getRandomDirection();
            stepsCounter = 0;
        }

        newPosition = position.addDirection(lastStepDirection);

        if (this.getColony().checkPossiblePosition(newPosition)){
            this.setPosition( newPosition );
        }
    }

}
