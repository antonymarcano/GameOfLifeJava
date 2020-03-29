package com.antonymarcano.play.gameoflife;

import com.antonymarcano.play.gameoflife.neighbourhood.Neighbourhood;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

import static com.antonymarcano.play.gameoflife.neighbourhood.EntireNeighbourhood.neighbourhood;
import static com.antonymarcano.play.gameoflife.neighbourhood.EntireNeighbourhood.of;
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

        for (LiveCell liveCell : board.currentBoard()) {
            for (Cell cell : neighbourhood(of(liveCell).on(board))) {
                Neighbourhood neighbourhood = of(cell).on(board);
                int size = neighbourhood.population();
                if (cell.shouldBeAliveInNeighbourhoodOf(size)) livingCells.add(LiveCell.at(cell.x(), cell.y()));
            }
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
