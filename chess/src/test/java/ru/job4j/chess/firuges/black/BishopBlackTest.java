package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BishopBlackTest {

    @Test
    public void isPositionRight() {
        Cell cell = Cell.C1;
        BishopBlack bishop = new BishopBlack(cell);
        assertThat(bishop.position(), is(cell));
    }

    @Test
    public void isCopyRight() {
        Cell startPos = Cell.C1;
        Cell endPos = Cell.G5;
        BishopBlack bishop = new BishopBlack(startPos);
        bishop = (BishopBlack) bishop.copy(endPos);
        assertThat(bishop.position(), is(endPos));
    }

    @Test
    public void isRightWay() {
        Cell startPos = Cell.C1;
        Cell endPos = Cell.G5;
        BishopBlack bishop = new BishopBlack(startPos);
        Cell[] way = bishop.way(endPos);
        Cell[] expectedWay = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(way, is(expectedWay));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void isWrongWay() {
        Cell startPos = Cell.C1;
        Cell endPos = Cell.G4;
        BishopBlack bishop = new BishopBlack(startPos);
        Cell[] way = bishop.way(endPos);
    }
}