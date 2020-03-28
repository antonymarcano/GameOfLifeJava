package com.antonymarcano.play.gameoflife;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NeighbourhoodShould {

    @Test
    @Ignore("Failing Test to illustrate step by step process in commits. Comment out @Ignore line to see it fail.")
    public void have_size_of_eight_when_a_cell_is_surrounded() {
        GameOfLife board = mock(GameOfLife.class);
        when(board.contains(any(LiveCell.class))).thenReturn(true);

        LiveCell cell = LiveCell.at(0,0);

        Neighbours neighbours = Neighbourhood.of(cell).on(board);
        assertThat(neighbours.size(), is(8));
    }
}
