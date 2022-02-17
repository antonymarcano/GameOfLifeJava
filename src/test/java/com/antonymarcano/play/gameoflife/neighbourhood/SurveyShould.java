package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.cell.DeadCell;
import com.antonymarcano.play.gameoflife.cell.LiveCell;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SurveyShould {

    @Test
    public void find_one_live_cell_for_lone_cell() {
        final var oneLivingCell = LiveCell.at(0, 0);
        GameOfLife board = GameOfLife.with(Set.of(
                oneLivingCell
        ));

        final var census = Survey.of(board).startingFrom(oneLivingCell);

        assertThat(census.occupiedAddresses(), is(Set.of(oneLivingCell)));
    }

    @Test
    public void find_eight_vacant_cells_surrounding_one_lone_cell() {
        LiveCell oneLivingCell = LiveCell.at(0, 0);
        GameOfLife board = GameOfLife.with(Set.of(
                oneLivingCell
        ));

        final var census = Survey.of(board).startingFrom(oneLivingCell);

        assertThat(census.vacantAddresses(), is(Set.of(
                DeadCell.at(0, 1),
                DeadCell.at(1, 1),
                DeadCell.at(1, 0),
                DeadCell.at(1, -1),
                DeadCell.at(-1, 0),
                DeadCell.at(-1, -1),
                DeadCell.at(0, -1),
                DeadCell.at(-1, 1)
        )));
    }

    @Test
    public void know_all_addresses() {
        LiveCell oneLivingCell = LiveCell.at(0, 0);
        GameOfLife board = GameOfLife.with(Set.of(
                oneLivingCell
        ));

        final var census = Survey.of(board).startingFrom(oneLivingCell);

        assertThat(census.allAddresses(), is(Set.of(
                LiveCell.at(0, 0),
                DeadCell.at(0, 1),
                DeadCell.at(1, 1),
                DeadCell.at(1, 0),
                DeadCell.at(1, -1),
                DeadCell.at(-1, 0),
                DeadCell.at(-1, -1),
                DeadCell.at(0, -1),
                DeadCell.at(-1, 1)
        )));
    }
}
