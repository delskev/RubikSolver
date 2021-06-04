package be.perzival.dev.cube.engine.movement;

public class Movement {
    private final MovementType sideToMove;
    private final boolean isHalfATurn;
    private final boolean clockwise;

    public static Movement of(MovementType sideToMove, boolean isHalfATurn, boolean isClockwise) {
        return new Movement(sideToMove, isHalfATurn, isClockwise);
    }

    private Movement(MovementType sideToMove, boolean isHalfATurn, boolean clockwise) {
        this.sideToMove = sideToMove;
        this.isHalfATurn = isHalfATurn;
        this.clockwise = clockwise;
    }

    public MovementType getMovementType() {
        return sideToMove;
    }

    public boolean issHalfATurn() {
        return isHalfATurn;
    }

    public boolean isClockwise() {
        return clockwise;
    }

    public String getNotation() {
        return new StringBuilder(this.sideToMove.toStandardAnnotation())
                .append(toIterationNotation())
                .append(toClockWiseNotation())
                .toString();
    }

    private final String toIterationNotation() {
        return this.issHalfATurn() ? "2" : "";
    }

    private final String toClockWiseNotation() {
        return this.isClockwise() ? "" : "'";
    }

    @Override
    public String toString() {
        return "Movement{" +
                "sideToMove=" + sideToMove +
                ", isHalfATurn=" + isHalfATurn +
                ", clockwise=" + clockwise +
                '}';
    }
}
