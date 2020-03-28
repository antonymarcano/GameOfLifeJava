package com.antonymarcano.play.gameoflife;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LiveCellShould {

    @Test
    public void survive_with_three_live_neighbours() {
        GameOfLife board = mock(GameOfLife.class);
        when(board.contains(any(LiveCell.class)))
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(false);

        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.shouldNotSurvive(board), is(false));
    }
}
