package com.antonymarcano.play.gameoflife.cell;

import com.antonymarcano.play.gameoflife.neighbourhood.CellOffsets;
import com.antonymarcano.play.gameoflife.neighbourhood.NeighbourhoodNeedsACentre;

public class DeadCell extends Cell {

    public static DeadCell at(int x, int y) {
        return new DeadCell(x,y);
    }
    private DeadCell(int x, int y) { super(x, y); }

    public static DeadCell at(CellOffsets offset, Cell originalCell) {
        return new DeadCell(originalCell,offset);
    }
    private DeadCell(Cell originalCell, CellOffsets offset) { super(offset, originalCell); }

    @Override
    public boolean isAllowedToLiveIn(NeighbourhoodNeedsACentre neighbourhood) {
        return populationOf(neighbourhood) == 3;
    }
}
