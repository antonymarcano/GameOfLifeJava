package com.antonymarcano.play.gameoflife.cell;

import com.antonymarcano.play.gameoflife.neighbourhood.Community;
import com.antonymarcano.play.gameoflife.neighbourhood.NeighbourhoodNeedsACentre;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeadCellShould {

    private NeighbourhoodNeedsACentre neighbourhood;
    private Community community;
    private DeadCell cell;

    @Before
    public void establishCommunity() {
        cell = DeadCell.at(0, 0);

        neighbourhood = mock(NeighbourhoodNeedsACentre.class);
        community = mock(Community.class);

        when(neighbourhood.of(cell)).thenReturn(community);
    }

    @Test
    public void be_reborn_with_three_live_neighbours() {
        when(community.population()).thenReturn(3);

        assertThat(cell.shouldLiveIn(neighbourhood), is(true));
    }

    @Test
    public void not_be_reborn_with_less_than_three_live_neighbours() {
        when(community.population()).thenReturn(2);

        assertThat(cell.shouldLiveIn(neighbourhood), is(false));
    }

    @Test
    public void not_be_reborn_with_more_than_three_live_neighbours() {
        when(community.population()).thenReturn(4);

        assertThat(cell.shouldLiveIn(neighbourhood), is(false));
    }
}
