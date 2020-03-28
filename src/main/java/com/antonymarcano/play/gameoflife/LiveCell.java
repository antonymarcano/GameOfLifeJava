package com.antonymarcano.play.gameoflife;

import com.antonymarcano.play.gameoflife.neighbourhood.SurroundingCells;
import com.antonymarcano.play.gameoflife.neighbourhood.Neighbourhood;
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

    public boolean shouldNotSurvive(GameOfLife board) {
        Neighbourhood population = SurroundingCells
                .of(this)
                .on(board);

        return !(population.size() == 3);
    }

    public LiveCell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int x() { return x; }
    public int y() { return y; }
}
