package com.codecool.ants;

import com.codecool.ants.geometry.Position;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Colony {
    private int width;

    private List<Ant> ants = new ArrayList<Ant>();
    private Map<Position, List<Ant>> colonyMap = new HashMap<>();
    protected Queen queen;

    public Colony(int width) {
        this.width = width;
        initializeColonyMap();
        createQueen();
    }


    private void initializeColonyMap() {
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < width; x++) {
                colonyMap.put(new Position(x, y), new ArrayList<Ant>());
            }
        }
    }

    public boolean checkPossiblePosition(Position p){
        if(p.getX() >= 0 && p.getX() < width &&
        p.getY() >= 0 && p.getY() < width){
            return true;
        } else { return false; }
    }



    public void display() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < width; row++) {
            for (int column = 0; column < width; column++) {
                Position mapPosition = new Position(row, column);
                List<Ant> ants = colonyMap.get(mapPosition);

                sb.append(ants == null || ants.isEmpty() ? " " : ants.get(0).getAntType().getSymbol());
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private void createQueen() {
        queen = (Queen) AntFactory.createAnt(AntType.QUEEN);
        Position queenPosition = new Position(width/2, width/2);
        queen.setPosition(queenPosition);
        colonyMap.get(queenPosition).add(queen);
        ants.add(queen);

    }


    public void addAnt(Position antPosition, Ant newAnt) {
        newAnt.setPosition(antPosition);
        ants.add(newAnt);
        newAnt.setColony(this);
        colonyMap.get(antPosition).add(newAnt);
//        System.out.println(newAnt.getPosition().toString() +" -> " + newAnt.getAntType().getSymbol());
    }


    public Position getRandomPosition(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int x = random.nextInt(width), y = random.nextInt(width);
        return new Position(x, y);
    }




    public void update() {
        for (Ant ant : ants) {
            colonyMap.get(ant.getPosition()).remove(ant);
            ant.move();
            colonyMap.get(ant.getPosition()).add(ant);
        }
    }
}
