package com.antonymarcano.play.gameoflife.cell;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LiveCellShould {

    @Test
    public void survive_with_three_live_neighbours_excluding_itself() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.isAllowedToLiveWith(4), is(true));
    }

    @Test
    public void survive_with_two_live_neighbours_excluding_itself() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.isAllowedToLiveWith(3), is(true));
    }

    @Test
    public void not_survive_with_less_than_two_live_neighbours_excluding_itself() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.isAllowedToLiveWith(2), is(false));
    }

    @Test
    public void not_survive_with_more_than_three_live_neighbours_excluding_itself() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.isAllowedToLiveWith(5), is(false));
    }
}
