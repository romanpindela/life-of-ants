package com.codecool.ants.geometry;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public enum Direction {
        NORTH(0, 1), EAST(1, 0), SOUTH(0, -1), WEST(-1, 0);

    int x;
    int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Direction getRandomDirection(){
        Direction[] values =  Direction.values();
        int i = ThreadLocalRandom.current().nextInt(values.length);
        return values[i];
    }

    public static Direction turnLeft(Direction lastTurnLeftDirection){
        List<Direction> directions = Arrays.asList(Direction.values());
        int nextLeftDirection = (directions.indexOf(lastTurnLeftDirection) + 1 ) % 4;
        return directions.get(nextLeftDirection);
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }






    }
