package be.perzival.dev.cube;

import be.perzival.dev.cube.engine.Cell;

public enum ColorCell implements Cell {
    RED,
    BLUE,
    GREEN,
    YELLOW,
    WHITE,
    ORANGE,
    NONE;


    @Override
    public String getValue() {
        return this.name().substring(0,1);
    }


    @Override
    public String toString() {
        return this.getValue();
    }
}
