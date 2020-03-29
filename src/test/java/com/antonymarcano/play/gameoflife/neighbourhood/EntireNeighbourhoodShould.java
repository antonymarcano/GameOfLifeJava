package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.Cell;
import com.antonymarcano.play.gameoflife.DeadCell;
import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.LiveCell;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EntireNeighbourhoodShould {

    @Test
    public void have_size_of_eight_when_a_cell_is_surrounded() {
        GameOfLife board = mock(GameOfLife.class);
        when(board.contains(any(LiveCell.class))).thenReturn(true);

        LiveCell cell = LiveCell.at(0, 0);

        Neighbourhood neighbourhood = EntireNeighbourhood.of(cell).on(board);
        assertThat(neighbourhood.size(), is(9));
    }

    @Test
    public void have_size_of_zero_when_a_cell_is_surrounded_by_empty_cells() {
        GameOfLife board = mock(GameOfLife.class);
        when(board.contains(any(LiveCell.class))).thenReturn(false);

        LiveCell cell = LiveCell.at(0, 0);

        Neighbourhood neighbourhood = EntireNeighbourhood.of(cell).on(board);
        assertThat(neighbourhood.size(), is(0));
    }

    @Test
    public void know_when_all_neighbouring_cells_are_currently_dead() {
        GameOfLife board = mock(GameOfLife.class);
        when(board.contains(any(LiveCell.class))).thenReturn(false);
        LiveCell cell = LiveCell.at(0, 0);

        Set<? extends Cell> cells = EntireNeighbourhood.of(cell).on(board).all();

        Set<? extends Cell> expectedCellsInNeighbourhood = Set.of(
                DeadCell.at( 0,  1),
                DeadCell.at( 1,  1),
                DeadCell.at( 1,  0),
                DeadCell.at( 1, -1),
                DeadCell.at( -1 ,0),
                DeadCell.at( -1,-1),
                DeadCell.at(  0, -1),
                DeadCell.at( -1, 1 ),
                LiveCell.at(0,0)
                );
        assertThat(cells, is(expectedCellsInNeighbourhood));
    }
}
