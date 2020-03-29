package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.Cell;
import com.antonymarcano.play.gameoflife.DeadCell;
import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.LiveCell;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

public class EntireNeighbourhood implements Neighbourhood, NeedsABoard {
    private Cell cell;
    private Set<LiveCell> populatedCells = new HashSet<>();
    private Set<DeadCell> vacantCells = new HashSet<>();

    public static NeedsABoard of(Cell cell) {
        return new EntireNeighbourhood(cell);
    }
    public EntireNeighbourhood(Cell cell) { this.cell = cell; }

    @Override
    public Neighbourhood on(GameOfLife board) {
        Map<Boolean, List<LiveCell>> neighbourhoodCensus =
                stream(CellOffsets.values())
                        .map(this::potentialCellAt)
                        .collect(partitioningBy(board::contains));

        populatedCells = occupiedAddressesFrom(neighbourhoodCensus);
        vacantCells = vacantAddressesFrom(neighbourhoodCensus);

        return this;
    }
    private LiveCell potentialCellAt(CellOffsets offSet) {
        int x = cell.x() + offSet.x();
        int y = cell.y() + offSet.y();
        return new LiveCell(x, y);
    }
    private Set<DeadCell> vacantAddressesFrom(Map<Boolean, List<LiveCell>> neighbourhoodCensus) {
        return neighbourhoodCensus.get(false).stream()
                .map(EntireNeighbourhood::deadCells)
                .collect(toSet());
    }

    private static DeadCell deadCells(LiveCell c) { return DeadCell.at(c.x(), c.y()); }

    private Set<LiveCell> occupiedAddressesFrom(Map<Boolean, List<LiveCell>> neighbourhoodCensus) {
        return new HashSet<>(neighbourhoodCensus.get(true));
    }

    @Override
    public int population() {
        return populatedCells.size();
    }

    public static Set<? extends Cell> neighbourhood(Neighbourhood neighbourhood) {return neighbourhood.all();}
    @Override
    public Set<? extends Cell> all() {
        Set<Cell> neighbours = new HashSet<>();
        neighbours.addAll(populatedCells);
        neighbours.addAll(vacantCells);
        return neighbours;
    }
}
