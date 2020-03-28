package com.antonymarcano.play.gameoflife;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Set;

import static java.util.Set.copyOf;
import static java.util.Set.of;

@EqualsAndHashCode
@ToString
public class GameOfLife {
    private Set<LiveCell> currentBoard;

    public static final Set<SimpleEntry<Integer, Integer>> POTENTIAL_NEIGHBOURS = of(
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
        return new GameOfLife(copyOf(cells));
    }

    public GameOfLife nextGeneration() {
        return GameOfLife.with(livingCellsFrom(this));
    }

    private Set<LiveCell> livingCellsFrom(GameOfLife board) {
        Set<LiveCell> draftBoard = new HashSet<>(board.currentBoard);

        for (LiveCell cell : currentBoard) {
            if (numberOfNeighboursOn(currentBoard, cell) == 3) continue;
            draftBoard.remove(cell);
        }
        return draftBoard;
    }

    private int numberOfNeighboursOn(Set<LiveCell> board, LiveCell cell) {
        int count = 0;
        for (SimpleEntry<Integer, Integer> neighbour : POTENTIAL_NEIGHBOURS) {
            int x = cell.x() + neighbour.getKey();
            int y = cell.y() + neighbour.getValue();
            LiveCell potentialNeighbour = new LiveCell(x, y);

            if (board.contains(potentialNeighbour)) count++;
        }
        return count;
    }

    public Integer size() {
        return currentBoard.size();
    }

    public Integer countNeighboursOf(LiveCell cell) {
        return 0;
    }
}
