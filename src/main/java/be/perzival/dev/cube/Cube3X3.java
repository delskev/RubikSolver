package be.perzival.dev.cube;

import be.perzival.dev.cube.exception.BadMovementException;

import java.util.EnumMap;
import java.util.Map;

public class Cube3X3 implements Cube{
    private final Map<FaceSide, Face> sideFaceMap;


    public Cube3X3() {
        this.sideFaceMap = new EnumMap(FaceSide.class);
        this.sideFaceMap.put(FaceSide.FRONT, Face.of3X3(ColorCell.WHITE));
        this.sideFaceMap.put(FaceSide.UP, Face.of3X3(ColorCell.BLUE));
        this.sideFaceMap.put(FaceSide.LEFT, Face.of3X3(ColorCell.ORANGE));
        this.sideFaceMap.put(FaceSide.RIGHT, Face.of3X3(ColorCell.RED));
        this.sideFaceMap.put(FaceSide.DOWN, Face.of3X3(ColorCell.GREEN));
        this.sideFaceMap.put(FaceSide.BOTTOM, Face.of3X3(ColorCell.YELLOW));
    }

    public void move(String notation) throws BadMovementException {
        if (!Movement.isNotationValid(notation)) {
            throw new BadMovementException(notation);
        }
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

    public Face getFace(FaceSide faceSide) throws BadMovementException {
        return this.sideFaceMap.get(faceSide);
    }

}
