package com.antonymarcano.play.gameoflife;

import com.antonymarcano.play.gameoflife.neighbourhood.Neighbourhood;
import com.antonymarcano.play.gameoflife.neighbourhood.SurroundingCells;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

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
        return survivorsFrom(currentBoard);
    }

    private Set<LiveCell> survivorsFrom(Set<LiveCell> board) {
        Set<LiveCell> draftBoard = new HashSet<>();

        for (LiveCell cell : board) {
            Neighbourhood neighbourhood = SurroundingCells.of(cell).on(this);
            int size = neighbourhood.size();
            if (cell.survivesInNeighbourhoodOf(size)) draftBoard.add(cell);
        }
        return draftBoard;
    }

    public Integer size() {
        return currentBoard.size();
    }

    public boolean contains(LiveCell cell) {
        return currentBoard.contains(cell);
    }
}
