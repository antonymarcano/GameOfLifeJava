package com.antonymarcano.play.gameoflife;

import org.junit.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Set;

import static java.util.Set.copyOf;
import static java.util.Set.of;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameOfLifeShould {

    @Test
    public void have_no_live_cells_when_seeded_with_only_one_live_cell() {
        Set<LiveCell> board = of(
                LiveCell.at(0, 0)
        );

        board = nextGenerationOf(board);

        assertThat(board.size(), is(0));
    }

    @Test
    public void have_no_live_cells_when_seeded_with_only_two_live_cells() {
        Set<LiveCell> board = of(
                LiveCell.at(0, 0),
                LiveCell.at(0, 1)
        );

        board = nextGenerationOf(board);

        assertThat(board.size(), is(0));
    }

    @Test
    public void stay_unchanged_when_four_cells_have_three_live_neighbours_up_and_right() {
        Set<LiveCell> board = of(
                LiveCell.at(0, 0),
                LiveCell.at(0, 1),
                LiveCell.at(1, 1),
                LiveCell.at(1, 0)
        );
        Set<LiveCell> stillLifeBlock = copyOf(board);

        board = nextGenerationOf(board);

        assertThat(board, is(stillLifeBlock));
    }


    private Set<LiveCell> nextGenerationOf(Set<LiveCell> board) {
        Set<LiveCell> draftBoard = new HashSet<>(board);
        Set<SimpleEntry<Integer, Integer>> potentialNeighbours = of(
                new SimpleEntry<>(0, 1), //top middle
                new SimpleEntry<>(1, 1), //top right
                new SimpleEntry<>(1, 0), //middle right
                new SimpleEntry<>(1, -1), //bottom right
                new SimpleEntry<>(-1, 0), //bottom middle
                new SimpleEntry<>(-1, -1), //bottom left
                new SimpleEntry<>(0, -1), //middle left
                new SimpleEntry<>(-1, 1)  //top left
        );

        for (LiveCell cell : board) {
            int count = 0;
            for (SimpleEntry<Integer, Integer> neighbour : potentialNeighbours) {
                int x = cell.x() + neighbour.getKey();
                int y = cell.y() + neighbour.getValue();
                LiveCell potentialNeighbour = new LiveCell(x, y);

                if (draftBoard.contains(potentialNeighbour)) count++;
            }
            if (count == 3) continue;
            draftBoard.remove(cell);
        }
        board = copyOf(draftBoard);
        return board;
    }
}
