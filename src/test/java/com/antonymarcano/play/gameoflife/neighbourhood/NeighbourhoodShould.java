package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.LiveCell;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NeighbourhoodShould {

    @Test
    public void have_size_of_eight_when_a_cell_is_surrounded() {
        GameOfLife board = mock(GameOfLife.class);
        when(board.contains(any(LiveCell.class))).thenReturn(true);

        LiveCell cell = LiveCell.at(0,0);

        Neighbours neighbours = Neighbourhood.of(cell).on(board);
        assertThat(neighbours.size(), is(8));
    }

    @Test
    public void have_size_of_zero_when_a_cell_is_surrounded_by_empty_cells() {
        GameOfLife board = mock(GameOfLife.class);
        when(board.contains(any(LiveCell.class))).thenReturn(false);

        LiveCell cell = LiveCell.at(0,0);

        Neighbours neighbours = Neighbourhood.of(cell).on(board);
        assertThat(neighbours.size(), is(0));
    }
}
