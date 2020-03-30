package com.antonymarcano.play.gameoflife.cell;

import com.antonymarcano.play.gameoflife.neighbourhood.Community;
import com.antonymarcano.play.gameoflife.neighbourhood.Neighbourhood;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LiveCellShould {

    @Test
    public void survive_with_three_live_neighbours_excluding_itself() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.isAllowedToLiveIn(4), is(true));
    }

    @Test
    public void survive_with_two_live_neighbours_excluding_itself() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.isAllowedToLiveIn(3), is(true));
    }

    @Test
    public void not_survive_with_less_than_two_live_neighbours_excluding_itself() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.isAllowedToLiveIn(2), is(false));
    }

    @Test
    public void not_survive_with_more_than_three_live_neighbours_excluding_itself() {
        LiveCell cell = LiveCell.at(0, 0);

        assertThat(cell.isAllowedToLiveIn(5), is(false));
    }

    @Test
    public void know_whether_it_should_live_in_its_neighbourhood() {
        LiveCell cell = LiveCell.at(0, 0);

        Neighbourhood neighbourhood = mock(Neighbourhood.class);
        Community community = mock(Community.class);
        when(neighbourhood.ofGiven(cell)).thenReturn(community);
        when(community.population()).thenReturn(3);

        assertThat(cell.isAllowedToLiveIn(neighbourhood), is(true));
    }
}
