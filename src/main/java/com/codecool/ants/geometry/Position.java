package com.codecool.ants.geometry;

import com.codecool.ants.Colony;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.abs;
import static java.lang.Math.random;

public class Position {

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position addDirection(Direction d){
        return new Position(
                x + d.getX(),
                y + d.getY()
        );
    }

    public static Position oneStepTowardPosition(Position from, Position to){
        int newX, newY;
        if (from.x != to.x){
            newX = from.x + (from.x > to.x ? -1 : 1);
        } else { newX = to.x; }

       if (from.y != to.y){
            newY = from.y + (from.y > to.y ? -1 : 1);
        } else { newY = to.y; }

        return new Position(newX, newY);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position that = (Position) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }

}