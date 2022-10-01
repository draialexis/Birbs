package model;

import javafx.beans.property.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Birb {

    /**
     * a birb's feeding frequency
     */
    private int feedHz = 2;
    /**
     * the date of a birb's latest previous meal
     */
    private LocalDate prvMealDate = LocalDate.now();
    private boolean isDead = false;
    private final model.Color featherClr = new model.Color(0, 0, 0);

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public model.Color getFeatherClr() {
        return featherClr;
    }

    private final SimpleBooleanProperty isHungry = new SimpleBooleanProperty(false);
        public boolean isIsHungry() {return isHungry.get();}
        public SimpleBooleanProperty isHungryProperty() {return isHungry;}

    private final StringProperty name = new SimpleStringProperty();
        public StringProperty nameProperty() {return name;}
        public String getName() {return name.get();}
        public void setName(String name) {this.name.set(name);}

    public Birb(String name, int feedHz) {
            this.name.set(name);
            this.feedHz = feedHz;
    }

    public void feed(LocalDate newPrvMealDate) {
        prvMealDate = newPrvMealDate;
        isHungry.set(false);
    }

    public void changeDay(LocalDate newDate) {
        if(Period.between(prvMealDate, newDate).getDays() >= feedHz) {
            isHungry.set(true);
        }
        if(Period.between(prvMealDate, newDate).getDays() >= feedHz * 2) {
            setDead(true);
        }
    }
}

