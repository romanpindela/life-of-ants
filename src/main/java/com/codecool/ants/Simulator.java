package com.codecool.ants;

import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {

        int colonySize = 20;
        Colony colony = initializeColony(colonySize,colonySize/3,colonySize/5,colonySize/10);

        String userInput;
        Scanner scanner = new Scanner(System.in);
        do {
            userInput = scanner.nextLine();

            colony.update();
            colony.display();
        } while (!userInput.equals("q"));

    }

    private static Colony initializeColony(int colonySize, int newWorkers, int newSoldiers, int newDrones){
        Colony colony = new Colony(colonySize);
        try {

            for (int numberOfWorkers = newWorkers; numberOfWorkers > 0; numberOfWorkers--) {
                Ant newAnt = AntFactory.createAnt(AntType.WORKER);
                colony.addAnt(colony.getRandomPosition(), newAnt);
            }

            for (int numberOfSoldiers = newSoldiers; numberOfSoldiers > 0; numberOfSoldiers--) {
                Ant newAnt = AntFactory.createAnt(AntType.SOLDIER);
                colony.addAnt(colony.getRandomPosition(), newAnt);
            }

            for (int numberOfDrones = newDrones; numberOfDrones > 0; numberOfDrones--) {
                Ant newAnt = AntFactory.createAnt(AntType.DRONE);
                colony.addAnt(colony.getRandomPosition(), newAnt);
            }

        } catch(IllegalArgumentException e){
            System.err.println(e);
        }
        return colony;

    }

//        System.out.println("You can use `mvn package; java -jar target/ants-1.0.jar` to run this app from the console");
//    }

}
