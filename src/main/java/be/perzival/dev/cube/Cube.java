package be.perzival.dev.cube;

import be.perzival.dev.cube.engine.Face;
import be.perzival.dev.cube.engine.movement.MovementType;
import be.perzival.dev.cube.exception.BadMovementException;

public interface Cube {


    void move(String movement) throws BadMovementException;
    void moveDown();
    void moveUp();
    void moveLeft();
    void moveRight();
    void moveFront();
    void moveBack();
    Face getFace(MovementType faceSide) throws BadMovementException;

}
