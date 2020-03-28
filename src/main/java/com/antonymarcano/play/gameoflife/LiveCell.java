package com.antonymarcano.play.gameoflife;

public class LiveCell extends Cell {
    public static LiveCell at(int x, int y) {
        return new LiveCell(x,y);
    }

    public LiveCell(int x, int y) {
        super(x, y);
    }

    public boolean survivesInNeighbourhoodOf(int neighbours) {
        return neighbours >= 2 && neighbours <= 3;
    }
}
