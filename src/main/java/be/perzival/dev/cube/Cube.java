package be.perzival.dev.cube;

import be.perzival.dev.cube.exception.BadMovementException;
import be.perzival.dev.cube.exception.WrongSideException;

public interface Cube {
    enum FaceSide {
        UP, DOWN, FRONT, LEFT, RIGHT, BOTTOM, NA;

        public static FaceSide valueFrom(char side) throws WrongSideException {
            switch (String.valueOf(side).toUpperCase()) {
                case "U":
                    return UP;
                case "D":
                    return DOWN;
                case "B":
                    return BOTTOM;
                case "F":
                    return FRONT;
                case "R":
                    return RIGHT;
                case "L":
                    return LEFT;
                default:
                    throw new WrongSideException(String.valueOf(side));
            }
        }

        public String toStandardAnnotation() {
            return this.name().substring(0, 1);
        }
    }

    void move(String movement) throws BadMovementException;
    void moveDown();
    void moveUp();
    void moveLeft();
    void moveRight();
    void moveFront();
    void moveBack();
    Face getFace(FaceSide faceSide) throws BadMovementException;

}
