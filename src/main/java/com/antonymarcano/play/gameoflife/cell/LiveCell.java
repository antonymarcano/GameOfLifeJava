package com.antonymarcano.play.gameoflife.cell;

import com.antonymarcano.play.gameoflife.neighbourhood.CellOffsets;

public class LiveCell extends Cell {
    private LiveCell(int x, int y) {
        super(x, y);
    }

    public static LiveCell at(int x, int y) {
        return new LiveCell(x,y);
    }

    public static LiveCell at(Cell originalCell, CellOffsets offset) {
        int x = originalCell.x() + offset.x();
        int y = originalCell.y() + offset.y();
        return LiveCell.at(x,y);
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
