package com.antonymarcano.play.gameoflife.cell;

import com.antonymarcano.play.gameoflife.neighbourhood.CellOffsets;
import com.antonymarcano.play.gameoflife.neighbourhood.NeighbourhoodNeedsACentre;

public class LiveCell extends Cell {

    public static LiveCell at(int x, int y) {
        return new LiveCell(x,y);
    }
    private LiveCell(int x, int y) { super(x, y); }

    public static LiveCell at(Cell originalCell, CellOffsets offset) {
        return new LiveCell(originalCell, offset);
    }
    private LiveCell(Cell originalCell, CellOffsets offset) {
        super(offset, originalCell);
    }

    @Override
    public boolean shouldLiveIn(NeighbourhoodNeedsACentre neighbourhood) {
        var neighbours = neighboursIn(populationOf(neighbourhood));

        return neighbours >= 2 && neighbours  <= 3;
    }

    private int neighboursIn(int population) {
        int me = 1;
        return population - me;
    }
}
