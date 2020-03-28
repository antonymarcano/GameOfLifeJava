package com.antonymarcano.play.gameoflife;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DeadCellShould {

    @Test
    public void be_reborn_with_three_live_neighbours() {
        DeadCell cell = DeadCell.at(0, 0);

        assertThat(cell.shouldBeBornInNeighbourhoodOf(3), is(true));
    }

    @Test
    @Ignore("Failing Test to illustrate step by step process in commits. Comment out @Ignore line to see it fail.")
    public void not_be_reborn_with_less_then_three_live_neighbours() {
        DeadCell cell = DeadCell.at(0, 0);

        assertThat(cell.shouldBeBornInNeighbourhoodOf(2), is(false));
    }
}
