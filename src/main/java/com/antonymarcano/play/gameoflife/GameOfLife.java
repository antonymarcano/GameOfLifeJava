package com.antonymarcano.play.gameoflife;

import com.antonymarcano.play.gameoflife.cell.LiveCell;
import com.antonymarcano.play.gameoflife.neighbourhood.StillNeedsACell;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

import static com.antonymarcano.play.gameoflife.neighbourhood.CellOffsets.CURRENT;
import static com.antonymarcano.play.gameoflife.neighbourhood.Neighbourhood.forAllCellsIn;
import static com.antonymarcano.play.gameoflife.neighbourhood.Neighbourhood.of;
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
        return GameOfLife.with(
                livingCellsFrom(this)
        );
    }

    private Set<LiveCell> livingCellsFrom(GameOfLife board) {
        Set<LiveCell> livingCells = new HashSet<>();
        StillNeedsACell neighbourhood = of(board);

        board.currentBoard.forEach(liveCell ->
                forAllCellsIn(neighbourhood.ofGiven(liveCell))
                        .filter(cell -> cell.isAllowedToLiveIn(neighbourhood.ofGiven(cell).population()))
                        .map(cell -> LiveCell.at(cell, CURRENT))
                        .forEach(livingCells::add));
        return livingCells;
    }

    public boolean contains(LiveCell cell) {
        return currentBoard.contains(cell);
    }
}
