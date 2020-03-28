package com.antonymarcano.play.gameoflife;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class LiveCell {
    private final int x;
    private final int y;

    public static LiveCell at(int x, int y) {
        return new LiveCell(x,y);
    }
    public LiveCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() { return x; }
    public int y() { return y; }

    public boolean shouldLiveOn(GameOfLife board) {
        return false;
    }
}
