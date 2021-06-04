package be.perzival.dev.cube.engine.movement;

public enum MovementType {
    UP, DOWN, FRONT, LEFT, RIGHT, BOTTOM, NA;

    public static MovementType of(char side) {
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
                return NA;
        }
    }

    public String toStandardAnnotation() {
        return this.name().substring(0, 1);
    }
}
