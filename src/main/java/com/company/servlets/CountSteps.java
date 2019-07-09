package com.company.servlets;


public class CountSteps {

    public static int count(Horse horse, EndSquare endSquare) {
        DirectionVector directionVector = new DirectionVector(horse, endSquare);
        while (horse.isFarFromEndSquare(directionVector, endSquare)) {
            horse.move(directionVector);
            directionVector.updateVector(horse, endSquare);
        }
        return horse.getHorseSteps();
    }
}
