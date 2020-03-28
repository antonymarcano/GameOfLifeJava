package com.antonymarcano.play.gameoflife;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Set;

import static java.util.Set.copyOf;

@EqualsAndHashCode
@ToString
public class GameOfLife {
    private Set<LiveCell> currentBoard;

    public static final Set<SimpleEntry<Integer, Integer>> RELATIVE_POSITION_OF_NEIGHBOURS = Set.of(
            new SimpleEntry<>(0, 1), //top middle
            new SimpleEntry<>(1, 1), //top right
            new SimpleEntry<>(1, 0), //middle right
            new SimpleEntry<>(1, -1), //bottom right
            new SimpleEntry<>(-1, 0), //bottom middle
            new SimpleEntry<>(-1, -1), //bottom left
            new SimpleEntry<>(0, -1), //middle left
            new SimpleEntry<>(-1, 1)  //top left
    );

    public GameOfLife(Set<LiveCell> cells) {
        currentBoard = copyOf(cells);
    }
    public static GameOfLife with(Set<LiveCell> cells) {
        return new GameOfLife(cells);
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

    public Integer countNeighboursOf(LiveCell cell) {
        return neighboursOf(cell).size();
    }

    private Set<LiveCell> neighboursOf(LiveCell cell) {
        Set<LiveCell> neighbours = new HashSet<>();

        for (SimpleEntry<Integer, Integer> neighbourOffset : RELATIVE_POSITION_OF_NEIGHBOURS) {
            int x = cell.x() + neighbourOffset.getKey();
            int y = cell.y() + neighbourOffset.getValue();
            LiveCell neighbour = new LiveCell(x, y);

            if (currentBoard.contains(neighbour)) neighbours.add(neighbour);
        }
        return neighbours;
    }

    public Integer size() {
        return currentBoard.size();
    }
}
