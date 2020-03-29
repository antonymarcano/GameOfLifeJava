package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.Cell;
import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.LiveCell;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.partitioningBy;

public class Survey {
    private GameOfLife board;
    private Map<Boolean, List<LiveCell>> survey;

    public Survey(GameOfLife board) {
        this.board = board;
    }

    public Survey areaAround(LiveCell cell) {
        survey = surveyNeighbourhoodOf(cell);
        return this;
    }

    public Set<LiveCell> occupiedAddresses() {
        return new HashSet<>(survey.get(true));
    }

    private Map<Boolean, List<LiveCell>> surveyNeighbourhoodOf(Cell cell) {
        return stream(CellOffsets.values())
                .map(offset -> LiveCell.at(cell, offset))
                .collect(partitioningBy(board::contains));
    }
}
