package com.antonymarcano.play.gameoflife.cell;

import com.antonymarcano.play.gameoflife.neighbourhood.Community;
import com.antonymarcano.play.gameoflife.neighbourhood.StillNeedsACell;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LiveCellShould {

    private StillNeedsACell neighbourhood;
    private Community community;
    private LiveCell cell;

    @Before
    public void establishCommunity() {
        cell = LiveCell.at(0, 0);

        neighbourhood = mock(StillNeedsACell.class);
        community = mock(Community.class);

        when(neighbourhood.ofGiven(cell)).thenReturn(community);
    }

    @Test
    public void survive_with_three_live_neighbours_excluding_itself() {
        when(community.population()).thenReturn(4);

        assertThat(cell.isAllowedToLiveIn(neighbourhood), is(true));
    }

    @Test
    public void survive_with_two_live_neighbours_excluding_itself() {
        when(community.population()).thenReturn(3);

        assertThat(cell.isAllowedToLiveIn(neighbourhood), is(true));
    }

    @Test
    public void not_survive_with_less_than_two_live_neighbours_excluding_itself() {
        when(community.population()).thenReturn(2);

        assertThat(cell.isAllowedToLiveIn(neighbourhood), is(false));
    }

    @Test
    public void not_survive_with_more_than_three_live_neighbours_excluding_itself() {
        when(community.population()).thenReturn(5);

        assertThat(cell.isAllowedToLiveIn(neighbourhood), is(false));
    }
}
