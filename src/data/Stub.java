package data;

import javafx.scene.paint.Color;
import model.Birb;
import model.BirbBox;

import java.time.LocalDate;

public class Stub {

    public BirbBox loadBirbs() {
        BirbBox birbBox = new BirbBox();
        birbBox.addBirb(new Birb("Alice", Color.AQUAMARINE, LocalDate.of(1995, 8, 14)));
        birbBox.addBirb(new Birb("Bob", Color.BISQUE, LocalDate.of(2001, 3, 19)));
        birbBox.addBirb(new Birb("Clyde", Color.CORNFLOWERBLUE, LocalDate.of(1992, 2, 29)));
        return birbBox;
    }
}
