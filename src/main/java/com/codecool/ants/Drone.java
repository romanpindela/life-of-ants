package com.codecool.ants;

import com.codecool.ants.geometry.Position;

public class Drone extends Ant{
    private static final String MSG_MATING_TEXT_SUCCESS = "ALLEEELUJJAAAAAAAAAAAAAAAAAAAAAAAAAAAAA :)";
    private static final String MSG_MATING_TEXT_FAILED = ":(";

    private int MATING_COUNTDOWN = 10;
    private boolean isMating;
    public Drone(AntType antType) {
        super(antType);
        isMating = false;
    }

    private void resetMatingCountdown(){
        MATING_COUNTDOWN = 10;
        isMating = false;
        setPosition(this.colony.getRandomPosition());
    }

    private void continueMating(){
        if (MATING_COUNTDOWN == 0){
            resetMatingCountdown();
            colony.queen.resetCounter();
        }
        MATING_COUNTDOWN--;
    }


    @Override
    void move() {
        if (isMating){
            continueMating();

        } else if (!position.equals(colony.queen.getPosition())){
                moveCloserToQueen();
        } else {
            tryMating();
        }
    }

    private void tryMating() {
        if (colony.queen.isInGoodMoodForMating()) {
            isMating = true;
            System.out.println(MSG_MATING_TEXT_SUCCESS);
        } else {
            resetMatingCountdown();
            System.out.println(MSG_MATING_TEXT_FAILED);
            setPosition(this.colony.getRandomPosition());
        }
    }

    private void moveCloserToQueen() {
        Position nextPosition;
        nextPosition = Position.oneStepTowardPosition(
                position,
                colony.queen.getPosition()
        );
        if (this.colony.checkPossiblePosition(nextPosition)) {
            this.setPosition(nextPosition);
        }
    }
}
