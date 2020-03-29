package com.antonymarcano.play.gameoflife.neighbourhood;

public enum CellOffsets {
    CURRENT       ( 0, 0 ),
    TOP_MIDDLE    ( 0, 1 ),
    TOP_RIGHT     ( 1, 1 ),
    MIDDLE_RIGHT  ( 1, 0 ),
    BOTTOM_RIGHT  ( 1,-1 ),
    BOTTOM_MIDDLE (-1 ,0 ),
    BOTTOM_LEFT   (-1,-1 ),
    MIDDLE_LEFT   ( 0,-1 ),
    TOP_LEFT      (-1, 1 );

    private final int x;
    private final int y;
    CellOffsets(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() { return x; }
    public int y() { return y; }
}
