package com.company.servlets;

public class Horse extends ChessboardSquare {

    protected int horseSteps = 0;
    private int minDistance = 3;
    public Horse(String startSquare, Chessboard chessboard){
        super(startSquare, chessboard);
    }

    public void move(DirectionVector directionVector) {
        if (isOnBoard(super.getX() + directionVector.getStepX(), super.getY() + directionVector.getStepY())) {
            super.updateCoordinate(super.getX() + directionVector.getStepX(), super.getY() + directionVector.getStepY());
            this.horseSteps++;
        } else if (isOnBoard(super.getX() + directionVector.getStepY(), super.getY() + directionVector.getStepX())) {
            super.updateCoordinate(getX() + directionVector.getStepY(), super.getY() + directionVector.getStepX());
            this.horseSteps++;
        }
    }

    public boolean isFarFromEndSquare(DirectionVector directionVector, EndSquare endSquare) {
        if (directionVector.getDistance() > minDistance) {
            return true;
        } else {
            this.horseSteps += isNearEndSquare(directionVector, endSquare);
            return false;
        }
    }


    public int isNearEndSquare(DirectionVector directionVector, EndSquare endSquare) {
        if (directionVector.getDistance() == 0) {
            return 0;
        }
        int row = 0;
        int coll = 0;
        int[][] mat = new int[7][7];
        for (int i = endSquare.getX() - 3; i < endSquare.getX() + 4; i++) {
            for (int j = endSquare.getY() - 3; j < endSquare.getY() + 4; j++) {
                if (isOnBoard(i, j)) {
                    mat[row][coll] = 0;
                } else {
                    mat[row][coll] = 1;
                }
                row++;
            }
            row = 0;
            coll++;
        }
        return (Util.LeeAlgorithm(mat, this.getX() - endSquare.getX() + 3,
                this.getY() - endSquare.getY() + 3, 3, 3));
    }

    public int getHorseSteps() {
        return horseSteps;
    }


}
