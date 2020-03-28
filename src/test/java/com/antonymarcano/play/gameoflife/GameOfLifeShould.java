package com.antonymarcano.play.gameoflife;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameOfLifeShould {

    @Test
    public void have_no_live_cells_when_seeded_with_only_one_live_cell() {
        GameOfLife board = new GameOfLife(
                LiveCell.at(0, 0)
        );

        board = board.nextGeneration();

        assertThat(board.size(), is(0));
    }

    @Test
    public void have_no_live_cells_when_seeded_with_only_two_live_cells() {
        GameOfLife board = new GameOfLife(
                LiveCell.at(0, 0),
                LiveCell.at(0, 1)
        );

        board = board.nextGeneration();

        assertThat(board.size(), is(0));
    }

    @Test
    public void stay_unchanged_when_four_cells_have_three_live_neighbours_up_and_right() {
        GameOfLife board = new GameOfLife(
                LiveCell.at(0, 0),
                LiveCell.at(0, 1),
                LiveCell.at(1, 1),
                LiveCell.at(1, 0)
        );
        GameOfLife stillLifeBlock = new GameOfLife(
                LiveCell.at(0, 0),
                LiveCell.at(0, 1),
                LiveCell.at(1, 1),
                LiveCell.at(1, 0)
        );

        board = board.nextGeneration();

        assertThat(board, is(stillLifeBlock));
    }
}
