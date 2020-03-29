package com.antonymarcano.play.gameoflife;

public class LiveCell extends Cell {
    public static LiveCell at(int x, int y) {
        return new LiveCell(x,y);
    }

    public LiveCell(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean shouldBeAliveInNeighbourhoodOf(int population) {
        return neighboursIn(population) >= 2 && (neighboursIn(population))  <= 3;
    }

    private int neighboursIn(int population) {
        int me = 1;
        return population - me;
    }
}
