package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.Cell;
import com.antonymarcano.play.gameoflife.DeadCell;
import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.LiveCell;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.stream;

public class SurroundingCells implements Neighbourhood, NeedsABoard {
    private LiveCell cell;
    private Set<LiveCell> livingNeighbours = new HashSet<>();
    private Set<DeadCell> deadNeighbours = new HashSet<>();

    public static NeedsABoard of(LiveCell cell) {
        return new SurroundingCells(cell);
    }

    @Override
    public Neighbourhood on(GameOfLife board) {
        stream(RelativePositionOfNeighbours.values()).forEach(offSet -> {
            int x = cell.x() + offSet.x();
            int y = cell.y() + offSet.y();
            LiveCell neighbour = new LiveCell(x, y);
            if (board.contains(neighbour)) {
                livingNeighbours.add(neighbour);
            } else {
                deadNeighbours.add(DeadCell.at(x,y));
            }
        });
        return this;
    }

    @Override
    public int size() {
        return livingNeighbours.size();
    }

    @Override
    public Set<? extends Cell> all() {
        Set<Cell> neighbours = new HashSet<>();
        neighbours.addAll(livingNeighbours);
        neighbours.addAll(deadNeighbours);
        return neighbours;
    }

    public SurroundingCells(LiveCell cell) {
        this.cell = cell;
    }

}
