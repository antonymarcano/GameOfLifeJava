package com.antonymarcano.play.gameoflife;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LiveCellShould {

    @Test
    public void survive_with_three_live_neighbours() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.survivesInNeighbourhoodOf(3), is(true));
    }

    @Test
    public void survive_with_two_live_neighbours() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.survivesInNeighbourhoodOf(2), is(true));
    }

    @Test
    public void not_survive_with_less_than_two_live_neighbours() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.survivesInNeighbourhoodOf(1), is(false));
    }

    @Test
    public void not_survive_with_more_than_three_live_neighbours() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.survivesInNeighbourhoodOf(4), is(false));
    }
}
