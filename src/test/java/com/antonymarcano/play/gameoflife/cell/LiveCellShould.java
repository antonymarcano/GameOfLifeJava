package com.antonymarcano.play.gameoflife.cell;

import com.antonymarcano.play.gameoflife.cell.LiveCell;
import org.junit.Test;

import static com.antonymarcano.play.gameoflife.neighbourhood.CellOffsets.BOTTOM_LEFT;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LiveCellShould {

    @Test
    public void survive_with_three_live_neighbours_excluding_itself() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.shouldBeAliveInNeighbourhoodOf(4), is(true));
    }

    @Test
    public void survive_with_two_live_neighbours_excluding_itself() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.shouldBeAliveInNeighbourhoodOf(3), is(true));
    }

    @Test
    public void not_survive_with_less_than_two_live_neighbours_excluding_itself() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.shouldBeAliveInNeighbourhoodOf(2), is(false));
    }

    @Test
    public void not_survive_with_more_than_three_live_neighbours_excluding_itself() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.shouldBeAliveInNeighbourhoodOf(5), is(false));
    }

    @Test
    public void be_created_from_an_offset() {
        LiveCell originalCell = LiveCell.at(0,0);
        LiveCell cell = LiveCell.at(originalCell, BOTTOM_LEFT);
        assertThat(cell, is(LiveCell.at(-1,-1)));
    }
}
