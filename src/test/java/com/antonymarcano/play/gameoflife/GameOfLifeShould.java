package com.antonymarcano.play.gameoflife;

import org.junit.Test;

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
                LiveCell.at(0,0)
        );

        board = nextGenerationOf(board);

        assertThat(board.size(), is(0));
    }

    @Test
    public void have_no_live_cells_when_seeded_with_only_two_live_cells() {
        Set<LiveCell> board = of(
                LiveCell.at(0,0),
                LiveCell.at(0,1)
        );

        board = nextGenerationOf(board);

        assertThat(board.size(), is(0));
    }


    private Set<LiveCell> nextGenerationOf(Set<LiveCell> board) {
        Set<LiveCell> draftBoard = new HashSet<>(board);
        draftBoard.removeAll(board);
        board = copyOf(draftBoard);
        return board;
    }
}
