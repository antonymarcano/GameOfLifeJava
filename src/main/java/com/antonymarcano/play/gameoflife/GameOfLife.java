package com.antonymarcano.play.gameoflife;

import com.antonymarcano.play.gameoflife.neighbourhood.NeedsACell;
import com.antonymarcano.play.gameoflife.neighbourhood.Neighbourhood;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

import static com.antonymarcano.play.gameoflife.neighbourhood.CellOffsets.HERE;
import static com.antonymarcano.play.gameoflife.neighbourhood.EntireNeighbourhood.entire;
import static com.antonymarcano.play.gameoflife.neighbourhood.EntireNeighbourhood.on;
import static java.util.Set.copyOf;

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
        return GameOfLife.with(livingCellsFrom(this));
    }

    private Set<LiveCell> livingCellsFrom(GameOfLife board) {
        Set<LiveCell> livingCells = new HashSet<>();
        NeedsACell neighbourhood = on(board);

        for (LiveCell liveCell : board.currentBoard()) {
            entire(neighbourhood.of(liveCell)).forEach(cell -> {
                Neighbourhood area = neighbourhood.of(cell);
                int size = area.population();
                if (cell.shouldBeAliveInNeighbourhoodOf(size)) livingCells.add(LiveCell.at(cell, HERE));
            });
        }

        return new HashSet<>(livingCells);
    }

    private Set<LiveCell> currentBoard() {
        return currentBoard;
    }

    public Integer size() {
        return currentBoard.size();
    }

    public boolean contains(LiveCell cell) {
        return currentBoard.contains(cell);
    }
}
