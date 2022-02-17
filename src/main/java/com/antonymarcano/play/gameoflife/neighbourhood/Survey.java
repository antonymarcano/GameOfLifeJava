package com.antonymarcano.play.gameoflife.neighbourhood;

import com.antonymarcano.play.gameoflife.cell.Cell;
import com.antonymarcano.play.gameoflife.cell.DeadCell;
import com.antonymarcano.play.gameoflife.GameOfLife;
import com.antonymarcano.play.gameoflife.cell.LiveCell;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.antonymarcano.play.gameoflife.neighbourhood.CellOffsets.CURRENT;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

@Accessors(fluent = true)
public class Survey implements SurveyNeedsACentre {
    private GameOfLife board;
    @Getter private Set<LiveCell> occupiedAddresses;
    @Getter private Set<DeadCell> vacantAddresses;

    private Survey(GameOfLife board) { this.board = board; }
    public static SurveyNeedsACentre of(GameOfLife board) {
        return new Survey(board);
    }

    @Override
    public Survey startingFrom(Cell cell) {
        Map<Boolean, List<LiveCell>> survey = surveyNeighbourhoodOf(cell);
        occupiedAddresses = occupiedAddressesFrom(survey);
        vacantAddresses = vacantAddressesFrom(survey);
        return this;
    }

    public Set<? extends Cell> allAddresses() {
        return new HashSet<>(){{
            addAll(occupiedAddresses);
            addAll(vacantAddresses);
        }};
    }

    private Map<Boolean, List<LiveCell>> surveyNeighbourhoodOf(Cell cell) {
        return stream(CellOffsets.values())
                .map(offset -> LiveCell.at(cell, offset))
                .collect(partitioningBy(board::contains));
    }
    private Set<LiveCell> occupiedAddressesFrom(Map<Boolean, List<LiveCell>> survey) {
        return new HashSet<>(survey.get(true));
    }

    private Set<DeadCell> vacantAddressesFrom(Map<Boolean, List<LiveCell>> survey) {
        return survey.get(false).stream()
                .map(cell -> DeadCell.at(CURRENT, cell))
                .collect(toSet());
    }
}
