package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.cell.DeadCell;
import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.cell.LiveCell;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SurveyShould {

    @Test
    public void find_one_live_cell_for_lone_cell() {
        LiveCell oneLivingCell = LiveCell.at(0, 0);
        GameOfLife board = GameOfLife.with(Set.of(
                oneLivingCell
        ));

        Survey census = Survey.within(board).startingFrom(oneLivingCell);

        assertThat(census.occupiedAddresses(), is(Set.of(LiveCell.at(0,0))));
    }

    @Test
    public void find_eight_vacant_cells_surrounding_one_lone_cell() {
        LiveCell oneLivingCell = LiveCell.at(0, 0);
        GameOfLife board = GameOfLife.with(Set.of(
                oneLivingCell
        ));

        Survey census = Survey.within(board).startingFrom(oneLivingCell);

        Set<DeadCell> expectedVacantAddresses = Set.of(
                DeadCell.at(0, 1),
                DeadCell.at(1, 1),
                DeadCell.at(1, 0),
                DeadCell.at(1, -1),
                DeadCell.at(-1, 0),
                DeadCell.at(-1, -1),
                DeadCell.at(0, -1),
                DeadCell.at(-1, 1)
        );
        assertThat(census.vacantAddresses(), is(expectedVacantAddresses));
    }
}
