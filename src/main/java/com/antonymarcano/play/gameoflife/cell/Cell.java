package com.antonymarcano.play.gameoflife.cell;

import com.antonymarcano.play.gameoflife.neighbourhood.CellOffsets;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public abstract class Cell {
    protected final int x;
    protected final int y;

    protected Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cell(CellOffsets offset, Cell originalCell) {
        x = originalCell.x() + offset.x();
        y = originalCell.y() + offset.y();
    }

    public int x() { return x; }
    public int y() { return y; }

    public abstract boolean isAllowedToLiveWith(int numberOfNeighbours);
}
