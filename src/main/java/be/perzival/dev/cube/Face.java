package be.perzival.dev.cube;

import be.perzival.dev.cube.exception.TooManyCellsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Face {
    Logger logger = LogManager.getLogger(Face.class);

    private Cell[][] cells;
    private final int row;
    private final int column;

    public static Face of3X3(Cell cell) {
        return new Face(cell, 3, 3);
    }

    private Face(Cell cell, int row, int column) {
        this.row = row;
        this.column = column;
        this.cells = new Cell[row][column];
        Arrays.stream(this.cells)
                .forEach(c -> Arrays.fill(c, cell));
    }

    public void displayFace() {
        logger.trace(this);
    }

    public List<Cell> setNewLineValues(int index, Cell[] newLine) throws TooManyCellsException {
        if( newLine.length > row) {
            throw new TooManyCellsException(newLine);
        }
        var oldLine = MatrixOperation.getLineByIndex(cells, index);
        IntStream.range(0, row).boxed().forEach(i -> cells[index][i] = newLine[i]);
        return oldLine;
    }

    public List<Cell> setNewColumnValues(int index, Cell[] newColumn) throws TooManyCellsException {
        if( newColumn.length > column) {
            throw new TooManyCellsException(newColumn);
        }
        var oldColumn = MatrixOperation.getColumnByIndex(cells, index);
        IntStream.range(0, row).boxed().forEach(i -> cells[i][index] = newColumn[i]);

        return oldColumn;
    }

    private final void updateCubeWithNewValue(int index, Cell[] newLine) throws TooManyCellsException {
        if( newLine.length > cells[index].length) {
            throw new TooManyCellsException(newLine);
        }
        var oldColumn = new Cell[]{cells[0][index], cells[1][index], cells[2][index]};
        IntStream.range(0, row).boxed().forEach(i -> cells[index][i] = newLine[i]);

//        return oldColumn;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        for(Cell[] line : cells) {
            for (Cell cell : line){
                builder.append(cell).append("\t");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
