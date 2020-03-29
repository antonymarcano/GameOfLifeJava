package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.cell.Cell;
import com.antonymarcano.play.gameoflife.cell.DeadCell;
import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.cell.LiveCell;

import java.util.HashSet;
import java.util.Set;

public class EntireNeighbourhood implements Neighbourhood, NeedsACell {
    private final GameOfLife board;
    private Set<LiveCell> populatedCells = new HashSet<>();
    private Set<DeadCell> vacantCells = new HashSet<>();

    public static NeedsACell on(GameOfLife board) {
        return new EntireNeighbourhood(board);
    }
    private EntireNeighbourhood(GameOfLife board) { this.board = board; }

    @Override
    public Neighbourhood of(Cell cell) {
        Survey census = Survey.within(board).startingFrom(cell);

        populatedCells = census.occupiedAddresses();
        vacantCells = census.vacantAddresses();

        return this;
    }

    @Override
    public int population() {
        return populatedCells.size();
    }

    public static Set<? extends Cell> entire(Neighbourhood addresses) {return addresses.all();}
    @Override
    public Set<? extends Cell> all() {
        return new HashSet<>(){{
                addAll(populatedCells);
                addAll(vacantCells);
            }};
    }
}
