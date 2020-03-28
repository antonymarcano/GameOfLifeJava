package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.LiveCell;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.stream;

public class SurroundingCells implements Neighbourhood, NeedsABoard {
    private LiveCell cell;
    private Set<LiveCell> neighbours = new HashSet<>();

    public static NeedsABoard of(LiveCell cell) {
        return new SurroundingCells(cell);
    }

    @Override
    public Neighbourhood on(GameOfLife board) {
        stream(RelativePositionOfNeighbours.values()).forEach(offSet -> {
            int x = cell.x() + offSet.x();
            int y = cell.y() + offSet.y();
            LiveCell neighbour = new LiveCell(x, y);
            if (board.contains(neighbour)) neighbours.add(neighbour);
        });
        return this;
    }

    @Override
    public int size() {
        return neighbours.size();
    }

    public SurroundingCells(LiveCell cell) {
        this.cell = cell;
    }

}
