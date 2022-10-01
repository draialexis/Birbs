package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class DateManager {
    private final ObjectProperty<LocalDate> currentDate = new SimpleObjectProperty<>(LocalDate.now());
    public LocalDate getCurrentDate() {return currentDate.get();}
    public ReadOnlyObjectProperty<LocalDate> currentDateProperty() {return currentDate;}

    public void addDays(long toAdd) {
        currentDate.set(getCurrentDate().plusDays(toAdd));
    }
}
