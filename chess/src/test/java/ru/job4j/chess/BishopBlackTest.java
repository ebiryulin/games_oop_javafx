package ru.job4j.chess;

import org.assertj.core.api.AbstractComparableAssert;
import org.assertj.core.api.FileSizeAssert;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BishopBlackTest {

    @Test
    public void whenSamePosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.position();
        Cell positionToCheck = Cell.C1;
        assertThat(bishopBlack.position()).isEqualTo(positionToCheck);
    }

    @Test
    public void whenSameCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.copy(Cell.D2);
        assertThat(bishopBlack.position()).isEqualTo(bishopBlack.position());
    }

    @Test
    public void whenCheckWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.G5)).isEqualTo(expected);
    }

    @Test
    public void isNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell position = bishopBlack.position();
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> bishopBlack.way(Cell.C2)
        );
        String expected = String.format("Could not way by diagonal from %s to %s",
                position, Cell.C2);
        assertThat(exception.getMessage()).isEqualTo(expected);

    }
}
