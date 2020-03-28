package com.antonymarcano.play.gameoflife;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public abstract class Cell {
    protected final int x;
    protected final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() { return x; }
    public int y() { return y; }
}