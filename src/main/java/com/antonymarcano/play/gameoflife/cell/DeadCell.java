package com.antonymarcano.play.gameoflife.cell;

import com.antonymarcano.play.gameoflife.neighbourhood.CellOffsets;

public class DeadCell extends Cell {
    public DeadCell(int x, int y) {
        super(x, y);
    }
    public DeadCell(Cell originalCell, CellOffsets offset) {
        super(offset, originalCell);
    }

    public static DeadCell at(int x, int y) {
        return new DeadCell(x,y);
    }
    public static DeadCell at(CellOffsets offset, Cell originalCell) {
        return new DeadCell(originalCell,offset);
    }

    @Override
    public boolean isAllowedToLiveWith(int numberOfNeighbours) {
        return numberOfNeighbours == 3;
    }
}
