package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.LiveCell;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Set;

public class SurroundingCells implements Neighbourhood, NeedsABoard {
    private LiveCell cell;
    private Set<LiveCell> neighbours = new HashSet<>();

    private static final Set<SimpleEntry<Integer, Integer>> RELATIVE_POSITION_OF_NEIGHBOURS = Set.of(
            new SimpleEntry<>(0, 1), //top middle
            new SimpleEntry<>(1, 1), //top right
            new SimpleEntry<>(1, 0), //middle right
            new SimpleEntry<>(1, -1), //bottom right
            new SimpleEntry<>(-1, 0), //bottom middle
            new SimpleEntry<>(-1, -1), //bottom left
            new SimpleEntry<>(0, -1), //middle left
            new SimpleEntry<>(-1, 1)  //top left
    );

    public SurroundingCells(LiveCell cell) { this.cell = cell; }
    public static NeedsABoard of(LiveCell cell) { return new SurroundingCells(cell); }

    @Override
    public Neighbourhood on(GameOfLife board) {
        for (SimpleEntry<Integer, Integer> neighbourOffset : RELATIVE_POSITION_OF_NEIGHBOURS) {
            int x = cell.x() + neighbourOffset.getKey();
            int y = cell.y() + neighbourOffset.getValue();
            LiveCell neighbour = new LiveCell(x, y);

            if (board.contains(neighbour)) neighbours.add(neighbour);
        }
        return this;
    }

    @Override
    public int size() {
        return neighbours.size();
    }
}
