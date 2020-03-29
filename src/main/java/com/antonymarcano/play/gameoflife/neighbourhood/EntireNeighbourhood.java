package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.Cell;
import com.antonymarcano.play.gameoflife.DeadCell;
import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.LiveCell;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.stream;

public class EntireNeighbourhood implements Neighbourhood, NeedsABoard {
    private Cell cell;
    private Set<LiveCell> aliveInNeighbourhood = new HashSet<>();
    private Set<DeadCell> deadNeighbours = new HashSet<>();

    public static NeedsABoard of(Cell cell) {
        return new EntireNeighbourhood(cell);
    }

    @Override
    public Neighbourhood on(GameOfLife board) {
        stream(CellOffsets.values()).forEach(offSet -> {
            int x = cell.x() + offSet.x();
            int y = cell.y() + offSet.y();
            LiveCell potentialLiveCell = new LiveCell(x, y);
            if (board.contains(potentialLiveCell)) {
                aliveInNeighbourhood.add(potentialLiveCell);
            } else {
                deadNeighbours.add(DeadCell.at(x,y));
            }
        });
        return this;
    }

    @Override
    public int population() {
        return aliveInNeighbourhood.size();
    }

    @Override
    public Set<? extends Cell> all() {
        Set<Cell> neighbours = new HashSet<>();
        neighbours.addAll(aliveInNeighbourhood);
        neighbours.addAll(deadNeighbours);
        return neighbours;
    }

    public EntireNeighbourhood(Cell cell) {
        this.cell = cell;
    }
}
