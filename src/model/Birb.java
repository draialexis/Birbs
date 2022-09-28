package model;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Birb {
    private final StringProperty name = new SimpleStringProperty();
        public StringProperty nameProperty() {return name;}
        public String getName() {return name.get();}
        public void setName(String name) {this.name.set(name);}
    private final ObjectProperty<LocalDate> dob = new SimpleObjectProperty<>();
        public ObjectProperty<LocalDate> dobProperty() {return dob;}
        public LocalDate getDob() {return dob.get();}
        public void setDob(LocalDate dob) {this.dob.set(dob);}
    private final LongProperty age = new SimpleLongProperty();
        public LongProperty ageProperty() {return age;}
        public long getAge() {return age.get();}
        public void setAge(LocalDate timeFromCall) {this.age.set(ChronoUnit.DAYS.between(getDob(), timeFromCall));}

    private final StringProperty color = new SimpleStringProperty();
        public StringProperty colorProperty() {return color;}
        public String getColor() {return color.get();}
        public void setColor(String color) {this.color.set(color);}

    private final IntegerProperty hunger = new SimpleIntegerProperty();
        public IntegerProperty hungerProperty() {return hunger;}
        public int getHunger() {return hunger.get();}
        public void setHunger(int hunger) {this.hunger.set(hunger);}

    public Birb(String name, String color) {
        this(name, LocalDate.now(), color, LocalDate.now(), 0);
    }

    public Birb(String name, LocalDate dob, String color, LocalDate timeFromCall, int hunger) {
        setName(name);
        setDob(dob);
        setColor(color);
        setAge(timeFromCall);
        setHunger(hunger);
    }
}
