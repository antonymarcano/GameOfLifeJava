package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.Cell;

public interface NeedsACell {
    Neighbourhood of(Cell cell);
}
