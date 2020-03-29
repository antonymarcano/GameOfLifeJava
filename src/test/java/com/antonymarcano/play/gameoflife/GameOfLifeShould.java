package com.antonymarcano.play.gameoflife;

import com.antonymarcano.play.gameoflife.cell.LiveCell;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameOfLifeShould {

    @Test
    public void have_no_live_cells_when_seeded_with_only_one_live_cell() {
        GameOfLife board = GameOfLife.with(Set.of(
                LiveCell.at(0, 0)
        ));

        board = board.nextGeneration();

        assertThat(board, is(GameOfLife.with(Set.of())));
    }

    @Test
    public void have_no_live_cells_when_seeded_with_only_two_live_cells() {
        GameOfLife board = GameOfLife.with(Set.of(
                LiveCell.at(0, 0),
                LiveCell.at(0, 1)
        ));

        board = board.nextGeneration();

        assertThat(board, is(GameOfLife.with(Set.of())));
    }

    @Test
    public void stay_unchanged_when_four_cells_have_three_live_neighbours() {
        Set<LiveCell> stillLifeBlock = Set.of(
                LiveCell.at(0, 0),
                LiveCell.at(0, 1),
                LiveCell.at(1, 1),
                LiveCell.at(1, 0)
        );
        GameOfLife board = GameOfLife.with(stillLifeBlock);

        board = board.nextGeneration();

        assertThat(board, is(GameOfLife.with(stillLifeBlock)));
    }

    @Test
    public void get_a_still_life_block_from_L_shaped_seed() {
        Set<LiveCell> rightAngle = Set.of(
                LiveCell.at(0, 0),
                LiveCell.at(0, 1),
                LiveCell.at(1, 1)
        );
        GameOfLife board = GameOfLife.with(rightAngle);

        board = board.nextGeneration();

        Set<LiveCell> stillLifeBlock = Set.of(
                LiveCell.at(0, 0),
                LiveCell.at(0, 1),
                LiveCell.at(1, 1),
                LiveCell.at(1, 0)
        );
        assertThat(board, is(GameOfLife.with(stillLifeBlock)));
    }

    @Test //superfluous test but included to illustrate the scope of behaviour
    public void oscillator_blinker() {
        Set<LiveCell> horizontalBar = Set.of(
                LiveCell.at(0, 0),
                LiveCell.at(1, 0),
                LiveCell.at(-1, 0)
        );
        GameOfLife board = GameOfLife.with(horizontalBar);

        board = board.nextGeneration();

        Set<LiveCell> verticalBar = Set.of(
                LiveCell.at(0, 0),
                LiveCell.at(0, 1),
                LiveCell.at(0, -1)
        );
        assertThat(board, is(GameOfLife.with(verticalBar)));

        board = board.nextGeneration();

        assertThat(board, is(GameOfLife.with(horizontalBar)));
    }
}
