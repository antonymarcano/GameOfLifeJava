package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.cell.Cell;

public interface StillNeedsACell {
    Community ofGiven(Cell cell);
}
