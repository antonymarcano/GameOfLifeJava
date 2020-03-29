package com.antonymarcano.play.gameoflife.cell;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DeadCellShould {

    @Test
    public void be_reborn_with_three_live_neighbours() {
        DeadCell cell = DeadCell.at(0, 0);

        assertThat(cell.isAllowedToLiveWith(3), is(true));
    }

    @Test
    public void not_be_reborn_with_less_than_three_live_neighbours() {
        DeadCell cell = DeadCell.at(0, 0);

        assertThat(cell.isAllowedToLiveWith(2), is(false));
    }

    @Test
    public void not_be_reborn_with_more_than_three_live_neighbours() {
        DeadCell cell = DeadCell.at(0, 0);

        assertThat(cell.isAllowedToLiveWith(4), is(false));
    }
}
