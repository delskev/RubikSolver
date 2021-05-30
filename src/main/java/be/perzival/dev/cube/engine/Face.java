package be.perzival.dev.cube.engine;

import be.perzival.dev.cube.engine.matrix.Matrix;
import be.perzival.dev.cube.exception.DataValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Face {
    Logger logger = LogManager.getLogger(Face.class);

    private Matrix<Cell> cells;

    public static Face of3X3(Cell cell) {
        return new Face(cell, 3, 3);
    }

    private Face(Cell cell, int row, int column) {
        this.cells = new Matrix<>(row, column);
        this.cells.fill(cell);
    }

    public void displayFace() {
        logger.trace(this);
    }

    public List<Cell> setNewLineValues(int index, List<Cell> newLine) throws DataValidationException {
        return this.cells.replaceRow(index, newLine);
    }

    public List<Cell> setNewColumnValues(int index, List<Cell> newColumn) throws DataValidationException {
        return this.cells.replaceColumn(index, newColumn);

    }

    @Override
    public String toString() {
//        var builder = new StringBuilder();
//        for(Cell[] line : cells) {
//            for (Cell cell : line){
//                builder.append(cell).append("\t");
//            }
//            builder.append("\n");
//        }
//        return builder.toString();
        return "";
    }
}
