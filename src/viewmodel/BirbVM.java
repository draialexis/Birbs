package viewmodel;

import javafx.beans.property.*;

import java.awt.*;

public class BirbVM {
    private final StringProperty name = new SimpleStringProperty();
    public String getName() {return name.get();}
    public StringProperty nameProperty() {return name;}
    public void setName(String name) {this.name.set(name);}

    private final BooleanProperty isHungry = new SimpleBooleanProperty(false);

    public boolean isIsHungry() {
        return isHungry.get();
    }

    public BooleanProperty isHungryProperty() {
        return isHungry;
    }

    public void setIsHungry(boolean isHungry) {
        this.isHungry.set(isHungry);
    }
}
