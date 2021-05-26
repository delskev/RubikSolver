package be.perzival.dev.cube;

public enum ColorCell implements Cell{
    RED,
    BLUE,
    GREEN,
    YELLOW,
    WHITE,
    ORANGE;

    @Override
    public String getValue() {
        return this.name().substring(0,1);
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
