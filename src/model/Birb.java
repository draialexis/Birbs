package model;

import javafx.beans.property.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Birb {
    private static final String GREEN_PAINT_STRING = "0x008000ff";
    private static final String YELLOW_PAINT_STRING = "0xffff00ff";
    private static final String RED_PAINT_STRING = "0xff0000ff";
    private static final String GREY_PAINT_STRING = "0x808080ff";

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
        public void setAge(long age) {this.age.set(age);}

    private final ObjectProperty<Paint> color = new SimpleObjectProperty<>();
        public ObjectProperty<Paint> colorProperty() {return color;}
        public Paint getColor() {return color.get();}
        public void setColor(Paint color) {this.color.set(color);}

    private final ObjectProperty<Paint> hunger = new SimpleObjectProperty<>();
        public ObjectProperty<Paint> hungerProperty() {return hunger;}
        public Paint getHunger() {return hunger.get();}
        public void setHunger(Paint hunger) {this.hunger.set(hunger);}

    public Birb(String name, Paint color) {
        this(name, color, LocalDate.now(), LocalDate.now(), Color.GREEN);
    }

    public Birb(String name, Paint color, LocalDate dob) {
        this(name, color, dob, LocalDate.now(), Color.GREEN);
    }

    public Birb(String name, Paint color, LocalDate dob, LocalDate timeFromCall, Paint hunger) {
        setName(name);
        setColor(color);
        setDob(dob);
        setAge(ChronoUnit.DAYS.between(getDob(), timeFromCall));
        setHunger(hunger);
    }

    @Override
    public String toString() {
        return getName();
    }

    public void feed(){
        System.out.println();
        setHunger(Color.GREEN);
    }

    public void ageDays(int days){
        setAge(getAge() + days);
        for (int i = 0; i < days; i++) {
            switch(getHunger().toString()){
                case GREEN_PAINT_STRING -> setHunger(Color.YELLOW);
                case YELLOW_PAINT_STRING -> setHunger(Color.RED);
                case RED_PAINT_STRING -> setHunger(Color.GREY);
            }
        }
    }
}

