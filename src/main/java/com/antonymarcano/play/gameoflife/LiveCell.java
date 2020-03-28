package com.antonymarcano.play.gameoflife;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@SuppressWarnings({"unused", "FieldCanBeLocal"})//because they're needed for @EqualsAndHashCode but the IDE can't tell they're being used
public class LiveCell {
    private final int x;
    private final int y;

    public LiveCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static LiveCell at(int x, int y) {
        return new LiveCell(x,y);
    }
}
