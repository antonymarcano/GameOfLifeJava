package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.cell.Cell;

import java.util.Set;
import java.util.stream.Stream;

public class Neighbourhood implements Community, NeighbourhoodNeedsACentre {
    private final GameOfLife board;
    private Survey census;

    private Neighbourhood(GameOfLife board) { this.board = board; }
    public static NeighbourhoodNeedsACentre on(GameOfLife board) {
        return new Neighbourhood(board);
    }

    @Override
    public Community of(Cell cell) {
        census = Survey.of(board).startingFrom(cell);
        return this;
    }

    @Override
    public int population() {
        return census.occupiedAddresses().size();
    }

    @Override
    public Set<? extends Cell> all() {
        return census.allAddresses();
    }
    public static Stream<? extends Cell> forAllCellsIn(Community addresses) { return addresses.all().stream(); }
}
