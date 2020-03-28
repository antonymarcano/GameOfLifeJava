package com.antonymarcano.play.gameoflife;

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
        Set<LiveCell> draftBoard = new HashSet<>(board.currentBoard);

        for (LiveCell cell : currentBoard) {
            if (cell.shouldNotSurvive(this)) draftBoard.remove(cell);
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
