package com.antonymarcano.play.gameoflife;

import com.antonymarcano.play.gameoflife.cell.LiveCell;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

import static com.antonymarcano.play.gameoflife.neighbourhood.CellOffsets.CURRENT;
import static com.antonymarcano.play.gameoflife.neighbourhood.Neighbourhood.forAllCellsIn;
import static com.antonymarcano.play.gameoflife.neighbourhood.Neighbourhood.on;
import static java.util.Set.copyOf;

@EqualsAndHashCode
@ToString
public class GameOfLife {
    private Set<LiveCell> currentBoard;

    private GameOfLife(Set<LiveCell> cells) { currentBoard = copyOf(cells); }
    public static GameOfLife with(Set<LiveCell> cells) {
        return new GameOfLife(cells);
    }

    public GameOfLife nextGeneration() {
        return GameOfLife.with(
                livingCellsFrom(this)
        );
    }

    public boolean contains(LiveCell cell) {
        return currentBoard.contains(cell);
    }

    private Set<LiveCell> livingCellsFrom(GameOfLife board) {
        var livingCells = new HashSet<LiveCell>();
        var neighbourhood = on(board);

        board.currentBoard.forEach(liveCell ->
                forAllCellsIn(neighbourhood.of(liveCell))
                        .filter(cell -> cell.shouldLiveIn(neighbourhood))
                        .map(cell -> LiveCell.at(cell, CURRENT))
                        .forEach(livingCells::add));
        return livingCells;
    }
}
