package com.antonymarcano.play.gameoflife.cell;

import com.antonymarcano.play.gameoflife.neighbourhood.CellOffsets;
import com.antonymarcano.play.gameoflife.neighbourhood.NeedsACell;

public class MyCell extends Cell {
    public static MyCell at(int x, int y) {
        return new MyCell(x,y);
    }

    public static MyCell at(CellOffsets offset, Cell originalCell) {
        return new MyCell(offset,originalCell);
    }

    protected MyCell(int x, int y) {
        super(x, y);
    }

    public MyCell(CellOffsets offset, Cell originalCell) {
        super(offset, originalCell);
    }

    @Override
    public boolean isAllowedToLiveIn(NeedsACell neighbourhood) {
        return false;
    }
}
