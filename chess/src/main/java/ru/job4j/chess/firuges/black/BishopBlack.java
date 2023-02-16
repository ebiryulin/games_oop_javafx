package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Cell.values().length;
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - position.getX();
        int deltaY = dest.getY() - position.getY();
        int x = position.getX();
        int y = position.getY();
            for (int index = 0; index < size; index++) {
                if (x != dest.getX() || y != dest.getY()) {
                    deltaX = deltaX > 0 ? 1 : -1;
                    deltaY = deltaY > 0 ? 1 : -1;
                    x += deltaX;
                    y += deltaY;
                    steps[index] = Cell.findBy(x, y);
                } else {
                    break;
                }
            }
            return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.pow((dest.getX() - source.getX()), 2) == Math.pow((dest.getY() - source.getY()), 2);
        //return Math.sqrt(dest.getX() - position.getX()) == Math.sqrt(dest.getY() - position.getY());
        //return Math.sqrt(source.getX() - dest.getX()) == Math.sqrt(source.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
