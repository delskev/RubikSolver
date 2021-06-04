package be.perzival.dev.cube;

import be.perzival.dev.cube.engine.Face;
import be.perzival.dev.cube.engine.movement.MovementType;
import be.perzival.dev.cube.exception.BadMovementException;

import java.util.EnumMap;
import java.util.Map;

public class Cube3X3 implements Cube {
    private final Map<MovementType, Face> sideFaceMap;

    public Cube3X3() {
        this.sideFaceMap = new EnumMap<>(MovementType.class);
        this.sideFaceMap.put(MovementType.FRONT, Face.of3X3(ColorCell.WHITE));
        this.sideFaceMap.put(MovementType.UP, Face.of3X3(ColorCell.BLUE));
        this.sideFaceMap.put(MovementType.LEFT, Face.of3X3(ColorCell.ORANGE));
        this.sideFaceMap.put(MovementType.RIGHT, Face.of3X3(ColorCell.RED));
        this.sideFaceMap.put(MovementType.DOWN, Face.of3X3(ColorCell.GREEN));
        this.sideFaceMap.put(MovementType.BOTTOM, Face.of3X3(ColorCell.YELLOW));
    }

    public void move(String notation) throws BadMovementException {
        //to be implemented
    }

    public void moveDown(){
        //To be implemented
    }

    public void moveUp(){
        //To be implemented

    }

    public void moveLeft(){
        //To be implemented

    }

    public void moveRight(){
        //To be implemented

    }

    public void moveFront(){
        //To be implemented

    }

    public void moveBack(){
        //To be implemented

    }

    public Face getFace(MovementType movementType) throws BadMovementException {
        return this.sideFaceMap.get(movementType);
    }

}
