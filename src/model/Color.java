package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Color {

    private final IntegerProperty red = new SimpleIntegerProperty();
    public int getRed() {return red.get();}
    public IntegerProperty redProperty() {return red;}
    public void setRed(int red) {this.red.set(red);}

    private final IntegerProperty green = new SimpleIntegerProperty();
    public int getGreen() {return green.get();}
    public IntegerProperty greenProperty() {return green;}
    public void setGreen(int green) {this.green.set(green);}

    private final IntegerProperty blue = new SimpleIntegerProperty();
    public int getBlue() {return blue.get();}
    public IntegerProperty blueProperty() {return blue;}
    public void setBlue(int blue) {this.blue.set(blue);}

    private final ObjectProperty<javafx.scene.paint.Color> color = new SimpleObjectProperty<>();
    public javafx.scene.paint.Color getColor() {return color.get();}
    public ObjectProperty<javafx.scene.paint.Color> colorProperty() {return color;}
    public void setColor(javafx.scene.paint.Color color) {this.color.set(color);}

    /**
     *
     * @param red [0-255]
     * @param green [0-255]
     * @param blue [0-255]
     */
    Color(int red, int green, int blue) {
        color.addListener(((__, ___, fxColor) -> {
            setRed((int) (fxColor.getRed() * 255));
            setGreen((int) (fxColor.getGreen() * 255));
            setBlue((int) (fxColor.getBlue() * 255));
        }));

        color.set(new javafx.scene.paint.Color(red / 255.0, green / 255.0, blue / 255.0, 1));
    }
}
