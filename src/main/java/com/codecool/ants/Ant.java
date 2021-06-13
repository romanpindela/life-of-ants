package com.codecool.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

public abstract class Ant {
    protected Position position;
    protected final AntType antType;

    protected Colony colony;

    public Ant(AntType antType) {
        this.antType = antType;
    }


    abstract void move();



    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public AntType getAntType() {
        return antType;
    }

    public void setColony(Colony colony) {
        this.colony = colony;
    }

    public Colony getColony() {
        return colony;
    }

}
