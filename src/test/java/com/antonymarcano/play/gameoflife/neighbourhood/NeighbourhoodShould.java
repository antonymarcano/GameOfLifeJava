package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.cell.DeadCell;
import com.antonymarcano.play.gameoflife.cell.LiveCell;
import org.junit.Test;

import java.util.Set;

import static com.antonymarcano.play.gameoflife.neighbourhood.Neighbourhood.on;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NeighbourhoodShould {

    @Test
    public void have_population_of_nine_when_a_living_cell_is_surrounded_by_eight_living_neighbours() {
        GameOfLife board = mock(GameOfLife.class);
        when(board.contains(any(LiveCell.class))).thenReturn(true);

        final var cell = LiveCell.at(0, 0);

        Community community = on(board).of(cell);

        assertThat(community.population(), is(9));
    }

    @Test
    public void have_population_of_one_when_a_live_cell_is_surrounded_by_eight_empty_cells() {
        GameOfLife board = mock(GameOfLife.class);
        when(board.contains(any(LiveCell.class)))
                .thenReturn(true)
                .thenReturn(false);

        final var cell = LiveCell.at(0, 0);

        Community community = on(board).of(cell);
        assertThat(community.population(), is(1));
    }

    @Test
    public void know_when_all_neighbouring_cells_are_currently_dead() {
        GameOfLife board = mock(GameOfLife.class);
        when(board.contains(any(LiveCell.class))).thenReturn(false);
        LiveCell cell = LiveCell.at(0, 0);

        final var neighbourhood = on(board).of(cell).all();

        assertThat(neighbourhood, is(Set.of(
                LiveCell.at(0, 0),
                DeadCell.at(0, 1),
                DeadCell.at(1, 1),
                DeadCell.at(1, 0),
                DeadCell.at(1, -1),
                DeadCell.at(-1, 0),
                DeadCell.at(-1, -1),
                DeadCell.at(0, -1),
                DeadCell.at(-1, 1)
        )));
    }
}
