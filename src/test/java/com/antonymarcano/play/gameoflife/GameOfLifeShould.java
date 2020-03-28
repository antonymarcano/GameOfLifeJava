package com.antonymarcano.play.gameoflife;

import org.junit.Ignore;
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

        Set<LiveCell> draftBoard = new HashSet<>(board);
        draftBoard.remove(LiveCell.at(0,0));
        board = copyOf(draftBoard);

        assertThat(board.size(), is(0));
    }

    @Test
    @Ignore("Failing Test to illustrate step by step process in commits. Comment out @Ignore line to see it fail.")
    public void have_no_live_cells_when_seeded_with_only_two_live_cells() {
        Set<LiveCell> board = of(
                LiveCell.at(0,0),
                LiveCell.at(0,1)
        );

        Set<LiveCell> draftBoard = new HashSet<>(board);
        draftBoard.remove(LiveCell.at(0,0));
        board = copyOf(draftBoard);

        assertThat(board.size(), is(0));
    }
}
