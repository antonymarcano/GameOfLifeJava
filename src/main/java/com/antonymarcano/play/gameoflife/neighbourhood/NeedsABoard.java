package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.GameOfLife;

public interface NeedsABoard {
    Neighbours on(GameOfLife board);
}
