package com.codecool.ants;

public final class AntFactory {
    public static Ant createAnt(AntType antType) throws IllegalArgumentException{
        if(antType == AntType.QUEEN) {
            return new Queen(AntType.QUEEN);
        } else if (antType == AntType.WORKER) {
            return new Worker(AntType.WORKER);
        } else if (antType == AntType.SOLDIER) {
            return new Soldier(AntType.SOLDIER);
        } else if (antType == AntType.DRONE) {
            return new Drone(AntType.DRONE);
        }else{
            throw new IllegalArgumentException("Wrong ant type: " + antType);
        }

        /*        String version: String antType
        return switch(antType){
            case "Queen" -> new Queen();
            case "Worker" -> new Worker();
            case "Solder" -> new Soldier();
            case "Drone" -> new Drone();
            default -> throw new IllegalArgumentException("Wrong ant type: " + antType);
        };*/
    }
}
