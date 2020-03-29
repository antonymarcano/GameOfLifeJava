package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.Cell;

import java.util.Set;

public interface Neighbourhood {
    int population();
    Set<? extends Cell> all();
}
