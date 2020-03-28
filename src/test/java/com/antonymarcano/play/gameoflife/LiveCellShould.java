package com.antonymarcano.play.gameoflife;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LiveCellShould {

    @Test
    @Ignore("Failing Test to illustrate step by step process in commits. Comment out @Ignore line to see it fail.")
    public void survive_with_three_live_neighbours() {
        GameOfLife board = mock(GameOfLife.class);
        LiveCell cell = LiveCell.at(0,0);
        when(board.countNeighboursOf(cell)).thenReturn(3);

        cell.shouldLiveOn(board);

        assertThat(cell.shouldLiveOn(board), is(true));
    }
}
