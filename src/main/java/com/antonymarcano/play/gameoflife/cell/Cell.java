package com.antonymarcano.play.gameoflife.cell;

import com.antonymarcano.play.gameoflife.neighbourhood.CellOffsets;
import com.antonymarcano.play.gameoflife.neighbourhood.NeighbourhoodNeedsACentre;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@EqualsAndHashCode @ToString @Accessors(fluent = true)
public abstract class Cell {
    @Getter protected final int x;
    @Getter protected final int y;

    protected Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cell(CellOffsets offset, Cell originalCell) {
        x = originalCell.x() + offset.x();
        y = originalCell.y() + offset.y();
    }

     public abstract boolean isAllowedToLiveIn(NeighbourhoodNeedsACentre neighbourhood);


    protected int populationOf(NeighbourhoodNeedsACentre neighbourhood) {
        return neighbourhood.of(this).population();
    }

}
