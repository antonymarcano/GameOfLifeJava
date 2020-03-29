package com.antonymarcano.play.gameoflife;

import org.junit.Test;

import static com.antonymarcano.play.gameoflife.neighbourhood.CellOffsets.BOTTOM_LEFT;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AnyCellShould {
    @Test
    public void be_created_from_an_offset() {
        MyCell originalCell = MyCell.at(0,0);

        MyCell cell = MyCell.at(BOTTOM_LEFT, originalCell);

        assertThat(cell, is(MyCell.at(-1,-1)));
    }
}
