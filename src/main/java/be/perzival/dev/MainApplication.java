package be.perzival.dev;

import be.perzival.dev.cube.ColorCell;
import be.perzival.dev.cube.engine.Face;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainApplication {


    public static void main(String[] args) {
        List<Face> cube = Arrays.stream(ColorCell.values())
                .map(Face::of3X3)
                .collect(Collectors.toList());

        cube.forEach(Face::displayFace);
    }
}
