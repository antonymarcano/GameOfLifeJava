package com.antonymarcano.play.gameoflife;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LiveCellShould {

    @Test
    public void survive_with_three_live_neighbours() {
        GameOfLife board = mock(GameOfLife.class);
        LiveCell cell = LiveCell.at(0,0);
        when(board.countNeighboursOf(cell)).thenReturn(3);

        cell.shouldNotSurvive(board);

        assertThat(cell.shouldNotSurvive(board), is(false));
    }
}
