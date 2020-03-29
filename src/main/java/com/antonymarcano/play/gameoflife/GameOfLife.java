package com.antonymarcano.play.gameoflife;

import com.antonymarcano.play.gameoflife.cell.Cell;
import com.antonymarcano.play.gameoflife.cell.LiveCell;
import com.antonymarcano.play.gameoflife.neighbourhood.Neighbourhood;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;
import java.util.stream.Stream;

import static com.antonymarcano.play.gameoflife.neighbourhood.CellOffsets.CURRENT;
import static com.antonymarcano.play.gameoflife.neighbourhood.Neighbourhood.*;
import static java.util.Set.copyOf;
import static java.util.stream.Collectors.toSet;

@EqualsAndHashCode
@ToString
public class GameOfLife {
    private Set<LiveCell> currentBoard;

    public static GameOfLife with(Set<LiveCell> cells) {
        return new GameOfLife(cells);
    }
    public GameOfLife(Set<LiveCell> cells) {
        currentBoard = copyOf(cells);
    }

    public GameOfLife nextGeneration() {
        return GameOfLife.with(
                livingCellsFrom(this)
        );
    }

    private Set<LiveCell> livingCellsFrom(GameOfLife board) {
        return populousOf(board)
                .filter(cell ->
                        cell.isAllowedToLiveWith(population(of(board).forGiven(cell)))
                ).map(cell ->
                        LiveCell.at(cell, CURRENT)
                ).collect(toSet());
    }

    private Stream<? extends Cell> populousOf(GameOfLife board) {
        return board.currentBoard.stream().flatMap(
                cell -> streamOf(
                        Neighbourhood.of(board).forGiven(cell)
                ));
    }

    public Integer size() {
        return currentBoard.size();
    }

    public boolean contains(LiveCell cell) {
        return currentBoard.contains(cell);
    }
}
