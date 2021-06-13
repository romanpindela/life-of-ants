package com.codecool.ants;

public enum AntType {
    WORKER('W'), SOLDIER('S'), DRONE('D'), QUEEN('Q');

    public char getSymbol() {
        return symbol;
    }

    char symbol;

    AntType(char symbol) {
        this.symbol = symbol;
    }


}
