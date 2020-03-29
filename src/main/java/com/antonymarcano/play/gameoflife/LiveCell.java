package com.antonymarcano.play.gameoflife;

public class LiveCell extends Cell {
    public static LiveCell at(int x, int y) {
        return new LiveCell(x,y);
    }

    public LiveCell(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean shouldBeAliveInNeighbourhoodOf(int neighbours) {
        return (neighbours -1) >= 2 && (neighbours -1)  <= 3;
    }
}
