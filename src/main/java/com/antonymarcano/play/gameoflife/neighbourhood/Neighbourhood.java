package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.cell.Cell;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Neighbourhood implements Community, StillNeedsACell {
    private final GameOfLife board;
    private Survey census;

    public static StillNeedsACell of(GameOfLife board) {
        return new Neighbourhood(board);
    }
    private Neighbourhood(GameOfLife board) { this.board = board; }

    @Override
    public Community forGiven(Cell cell) {
        census = Survey.within(board).startingFrom(cell);
        return this;
    }

    public static int population(Community populous) {
        return populous.population();
    }

    @Override
    public int population() {
        return census.occupiedAddresses().size();
    }

    public static Stream<? extends Cell> streamOf(Community addresses) {return addresses.all().stream();}
    @Override
    public Set<? extends Cell> all() {
        return new HashSet<>(){{
                addAll(census.occupiedAddresses());
                addAll(census.vacantAddresses());
            }};
    }
}
