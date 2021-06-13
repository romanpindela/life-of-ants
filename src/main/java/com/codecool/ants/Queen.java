package com.codecool.ants;

import java.util.concurrent.ThreadLocalRandom;

public class Queen extends Ant{
    private int goodMoodCountdown;
    private final int  GOOD_MOOD_TIMER_LOW = 10;
    private final int  GOOD_MOOD_TIMER_HIGH = 20;

    public Queen(AntType antType) {
        super(antType);
        resetCounter();
    }

    public void resetCounter() {
        goodMoodCountdown = ThreadLocalRandom.current().nextInt(
                GOOD_MOOD_TIMER_LOW,
                GOOD_MOOD_TIMER_HIGH
        );
    }

    public boolean isInGoodMoodForMating(){
        return goodMoodCountdown == 0;
    }


    @Override
    void move() {
        if(goodMoodCountdown > 0){
            goodMoodCountdown--;
        }
    }
}
