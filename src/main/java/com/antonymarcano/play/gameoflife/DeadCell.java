package com.antonymarcano.play.gameoflife;

public class DeadCell extends Cell {
    public DeadCell(int x, int y) {
        super(x, y);
    }

    public static DeadCell at(int x, int y) {
        return new DeadCell(x,y);
    }

    @Override
    public boolean shouldBeAliveInNeighbourhoodOf(int numberOfNeighbours) {
        return numberOfNeighbours == 3;
    }
}
