package com.company.servlets;

import java.util.regex.*;


public abstract class ChessboardSquare{

    protected int x;
    protected int y;
    protected Chessboard chessboard;


    public ChessboardSquare(String coordinateOfSquare, Chessboard chessboard) {
        this.chessboard = chessboard;
        if (inputIsCorrect(coordinateOfSquare)) {
            int coordinateX = getNumericValueFromLetter(coordinateOfSquare);
            int coordinateY = getNumericValue(coordinateOfSquare);
            Character.getNumericValue(coordinateOfSquare.charAt(1));
            if (isOnBoard(chessboard, coordinateX, coordinateY)) {
                this.x = coordinateX;
                this.y = coordinateY;
            } else {
                System.out.print(-1);
                System.exit(-1);
            }
        }
    }

    public boolean inputIsCorrect (String coordinateOfSquare) {
        Matcher matcher = Pattern.compile("[A-Z]+[1-9][0-9]*").matcher(coordinateOfSquare);
        if (matcher.matches()) {
//            matcher.find();
//            String correctPart = matcher.group();
//            if (correctPart.length() == coordinateOfSquare.length()) {
                return true;
            } else {
                System.out.print(-1);
                System.exit(-1);
                return false;
            }
//        matcher.find();
//        System.out.println(matcher.group().length());
//        System.out.println(coordinateOfSquare.length());
//        } else {
//            System.out.print(-1);
//            System.exit(-1);
//            return false;
//        }
    }

    public int getNumericValue (String coordinateOfSquare) {
        Matcher matcher = Pattern.compile("\\d+").matcher(coordinateOfSquare);
        matcher.find();
        return Integer.valueOf(matcher.group());
    }

    static final int LETTERS_IN_ALPHABET = 26;

    public int getNumericValueFromLetter (String coordinateOfSquare) {
        Matcher matcher = Pattern.compile("\\D+").matcher(coordinateOfSquare);
        matcher.find();
        int coordinateY = 0;
        for (int i = 0; i < matcher.group().length() ; i++) {
            coordinateY += ((int) matcher.group().charAt(i) - (int) ('A') + 1) * fastPow(LETTERS_IN_ALPHABET, matcher.group().length() - 1 - i);
        }
        return coordinateY;
    }


    public boolean isOnBoard (Chessboard chessboard, int coordinateX, int coordinateY){
        if ((coordinateX < chessboard.getWidth() + 1 && coordinateX > 0) && (coordinateY < chessboard.getHeight() + 1 && coordinateY > 0)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isOnBoard (int x, int y){
        if ((x < chessboard.getWidth()+1 && x > 0) && (y < chessboard.getHeight()+1 && y > 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static long fastPow(int baseOfNumber, int power) {
        int result = 1;
        while (power > 0) {
            if ((power & 1) == 1) {
                result *= baseOfNumber;
            }
            power >>= 1;
            baseOfNumber *= baseOfNumber;
        }
        return result;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void updateCoordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Chessboard getChessboard() {
        return chessboard;
    }
}
