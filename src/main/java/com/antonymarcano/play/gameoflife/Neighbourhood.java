package com.antonymarcano.play.gameoflife;

public class Neighbourhood implements NeedsABoard, Neighbours {
    private LiveCell cell;
    private GameOfLife board;

    public Neighbourhood(LiveCell cell) {
        this.cell = cell;
    }

    public static NeedsABoard of(LiveCell cell) {
        return new Neighbourhood(cell);
    }

    @Override
    public Neighbours on(GameOfLife board) {
        this.board = board;
        return this;
    }

    @Override
    public int size() {
        return 0;
    }
}
