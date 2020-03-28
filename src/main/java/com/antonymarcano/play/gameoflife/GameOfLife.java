package com.antonymarcano.play.gameoflife;

import lombok.EqualsAndHashCode;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Set;

import static java.util.Set.copyOf;
import static java.util.Set.of;

@EqualsAndHashCode
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

    public GameOfLife(LiveCell... cells) {
        currentBoard = Set.of(cells);
    }

    public GameOfLife nextGeneration() {
        Set<LiveCell> draftBoard = new HashSet<>(currentBoard);

        for (LiveCell cell : currentBoard) {
            int count = 0;
            for (SimpleEntry<Integer, Integer> neighbour : POTENTIAL_NEIGHBOURS) {
                int x = cell.x() + neighbour.getKey();
                int y = cell.y() + neighbour.getValue();
                LiveCell potentialNeighbour = new LiveCell(x, y);

                if (draftBoard.contains(potentialNeighbour)) count++;
            }
            if (count == 3) continue;
            draftBoard.remove(cell);
        }
        currentBoard = copyOf(draftBoard);
        return this;
    }

    public Integer size() {
        return currentBoard.size();
    }
}
