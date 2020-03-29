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

public class EntireNeighbourhood implements Neighbourhood, NeedsACell {
    private final GameOfLife board;
    private Set<LiveCell> populatedCells = new HashSet<>();
    private Set<DeadCell> vacantCells = new HashSet<>();

    public static NeedsACell on(GameOfLife board) {
        return new EntireNeighbourhood(board);
    }
    private EntireNeighbourhood(GameOfLife board) { this.board = board; }

    public Neighbourhood of(Cell cell) {
        Map<Boolean, List<LiveCell>> neighbourhoodCensus = surveyNeighbourhoodOf(cell);

        populatedCells = occupiedAddressesFrom(neighbourhoodCensus);
        vacantCells = vacantAddressesFrom(neighbourhoodCensus);

        return this;
    }
    
    private Map<Boolean, List<LiveCell>> surveyNeighbourhoodOf(Cell cell) {
        return stream(CellOffsets.values())
                .map(offset -> LiveCell.at(cell, offset))
                .collect(partitioningBy(board::contains));
    }

    private Set<LiveCell> occupiedAddressesFrom(Map<Boolean, List<LiveCell>> neighbourhoodCensus) {
        return new HashSet<>(neighbourhoodCensus.get(true));
    }

    private Set<DeadCell> vacantAddressesFrom(Map<Boolean, List<LiveCell>> neighbourhoodCensus) {
        return neighbourhoodCensus.get(false).stream()
                .map(EntireNeighbourhood::deadCells)
                .collect(toSet());
    }

    private static DeadCell deadCells(LiveCell c) { return DeadCell.at(c.x(), c.y()); }

    @Override
    public int population() {
        return populatedCells.size();
    }

    public static Set<? extends Cell> entire(Neighbourhood cells) {return cells.all();}
    @Override
    public Set<? extends Cell> all() {
        Set<Cell> neighbours = new HashSet<>();
        neighbours.addAll(populatedCells);
        neighbours.addAll(vacantCells);
        return neighbours;
    }
}
