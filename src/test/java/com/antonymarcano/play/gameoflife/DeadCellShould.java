package com.antonymarcano.play.gameoflife;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DeadCellShould {
    @Test
    public void survive_with_three_live_neighbours() {
        DeadCell cell = DeadCell.at(0, 0);

        assertThat(cell.shouldBeBornInNeighbourhoodOf(3), is(true));
    }
}
