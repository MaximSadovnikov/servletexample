package com.company.servlets;

public class Chessboard {
    protected int width;
    protected int height;

    public Chessboard(int width, int height){
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        } else {
            System.out.print(-1);
            System.exit(-1);
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
