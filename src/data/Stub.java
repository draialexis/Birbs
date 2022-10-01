package data;

import javafx.scene.paint.Color;
import model.Birb;
import model.BirbBox;

import java.time.LocalDate;

public class Stub {

    public BirbBox loadBirbs() {
        BirbBox birbBox = new BirbBox();
        birbBox.addBirb(new Birb("Alice", 1));
        birbBox.addBirb(new Birb("Bob", 2));
        birbBox.addBirb(new Birb("Fucking Kevin GOSH", 4));
        return birbBox;
    }
}
