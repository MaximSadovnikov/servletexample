package com.company.servlets;

import java.lang.Math;

public class DirectionVector {
    protected int stepX;
    protected int stepY;
    protected double distance;

    public DirectionVector(Horse horse, EndSquare endSquare){
        updateVector(horse, endSquare);
    }

    public void updateVector (Horse horse, EndSquare endSquare) {
        if (Math.abs(endSquare.getX() - horse.getX()) >= Math.abs(endSquare.getY() - horse.getY())) {
            this.stepX = (int)(2 * (((float)(endSquare.getX() - horse.getX())) < 0 ? -1: 1));
            this.stepY = (int)((((float)(endSquare.getY() - horse.getY())) < 0 ? -1: 1));

        } else {

            this.stepX = (int)((((float)(endSquare.getX() - horse.getX())) < 0 ? -1: 1));
            this.stepY = (int)(2 * (((float)(endSquare.getY() - horse.getY())) < 0 ? -1: 1));

        }
        this.distance = Math.abs(endSquare.getX() - horse.getX()) + Math.abs(endSquare.getY() - horse.getY());
    }


    public int getStepX() {
        return stepX;
    }

    public int getStepY() {
        return stepY;
    }

    public double getDistance() {
        return distance;
    }

    public double getDistance(Horse horse, EndSquare endSquare) {
        return Math.abs(endSquare.getX() - horse.getX()) + Math.abs(endSquare.getY() - horse.getY());
    }

}

