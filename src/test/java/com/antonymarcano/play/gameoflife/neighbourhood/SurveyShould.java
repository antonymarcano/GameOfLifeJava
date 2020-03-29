package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.LiveCell;
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

        Survey census = new Survey(board).areaAround(oneLivingCell);

        assertThat(census.occupiedAddresses(), is(Set.of(LiveCell.at(0,0))));
    }
}
