package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.LiveCell;

public class Neighbourhood implements NeedsABoard, Neighbours {
    private LiveCell cell;

    public Neighbourhood(LiveCell cell) {
        this.cell = cell;
    }

    public static NeedsABoard of(LiveCell cell) {
        return new Neighbourhood(cell);
    }

    @Override
    public Neighbours on(GameOfLife board) {
        return this;
    }

    @Override
    public int size() {
        return 8;
    }
}
